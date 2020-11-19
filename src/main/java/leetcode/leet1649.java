package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class leet1649 {
    public int createSortedArray(int[] instructions) {
    TreeSet<Integer> set=new TreeSet<>();
        for (int instruction : instructions) {
            set.add(instruction);
        }
       int idx=1;
        Map<Integer,Integer> map=new HashMap<>();
        for (Integer integer : set) {
          map.put(integer,idx++);
        }

        long res=0;
        int mod = (int)1e9+7;
        FenwickTree fenwickTree=new FenwickTree(idx);
        for (int instruction : instructions) {
           int id=map.get(instruction);
            int left=fenwickTree.query(id-1);
            int right=fenwickTree.query(idx)-fenwickTree.query(id);
         res=(res+Math.min(left,right))%mod;
         fenwickTree.update(id,1);
        }  
return (int)res;
    }

    //树状数组板子
    public class FenwickTree {

        /**
         * 预处理数组
         */
        private int[] tree;
        private int len;

        public FenwickTree(int n) {
            this.len = n;
            tree = new int[n + 1];
        }

        /**
         * 单点更新
         *
         * @param i     原始数组索引 i
         * @param delta 变化值 = 更新以后的值 - 原始值
         */
        public void update(int i, int delta) {
            // 从下到上更新，注意，预处理数组，比原始数组的 len 大 1，故 预处理索引的最大值为 len
            while (i <= len) {
                tree[i] += delta;
                i += lowbit(i);
            }
        }

        /**
         * 查询前缀和
         *
         * @param i 前缀的最大索引，即查询区间 [0, i] 的所有元素之和
         */
        public int query(int i) {
            // 从右到左查询
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= lowbit(i);
            }
            return sum;
        }

        public  int lowbit(int x) {
            return x & (-x);
        }
    }
}
