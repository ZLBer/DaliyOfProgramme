package leetcode.leetcode1_499;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class leet493$ {
    //基本思路是这样的  二叉搜索树count来记录比这个val大或等于的数字数目
    //虽然TLE 但是很有参考价值

/*
    class Node {
        int val, cnt;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.cnt = 1;
        }
    }
    private int search(Node root, long val) {
        if (root == null) {
            return 0;
        } else if (val == root.val) {
            return root.cnt;
        } else if (val < root.val) {
            return root.cnt + search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    private Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
        } else if (val == root.val) {
            root.cnt++;
        } else if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.cnt++;
            root.right = insert(root.right, val);
        }

        return root;
    }
    public int reversePairs(int[] nums) {
        int res = 0;
        Node root = null;

        for (int ele : nums) {
            res += search(root, 2L * ele + 1); //找比2L * ele + 1大的节点数有多少，此处肯定使搜索的前面的
            root = insert(root, ele); //把这个节点添加进去
        }

        return res;
    }
*/






//正向遍历需要减去
//树状数组  count-比它小的=比它大的
/*    private int search(int[] bit, int i) {
        int sum = 0;

        while (i > 0 ) {
            sum += bit[i];
            i -= i & -i;
        }

        return sum;
    }

    private void insert(int[] bit, int i) {
        while (i < bit.length) {
            bit[i] += 1;
            i += i & -i;
        }
    }
    public int reversePairs(int[] nums) {
        int res = 0;
        int[] copy = Arrays.copyOf(nums, nums.length);
        int[] bit = new int[copy.length + 1];

        Arrays.sort(copy);

        int count=0;
        for (int ele : nums) {
            count++;
            res += (count-search(bit, index(copy, 2L * ele + 1)-1));  //现在的个数- ( < 2L * ele + 1 )
            System.out.println(res);
            insert(bit, index(copy, ele));
        }

        return res;
    }

    //搜索val在arr中的位置
   static private int index(int[] arr, long val) {
        int l = 0, r = arr.length - 1, m = 0;

        while (l <= r) {
            m = l + ((r - l) >> 1);

            if (arr[m] >= val) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l + 1;
    }*/



/*    int[] BIT;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int n = nums.length;

        int[] copy = nums.clone();
        Arrays.sort(copy);

        //discretization
        //so different num will be mapped to 0 - (p - 1)...in order...
        //为了保证不重复
        int p = 0;
        for (int num : copy) {
            if (p == 0 || num != copy[p - 1]) {
                copy[p++] = num;
            }
        }

        BIT = new int[p + 1];
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) { //逆序遍历  查找后边比自己一半小的数字
            int index1 = binarySearch(1.0 * nums[i] / 2, 0, p, copy); //查找满足 <= nums[i]/2 -1的位置
            //if all number are negative... the index could be p...
            int index2 = binarySearch(nums[i], 0, p , copy); //查找插入位置
            cnt += query(index1);
            update(index2 + 1); //need to add 1...
        }
        return cnt;
    }

    private int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += BIT[i];
            i -= (i & -i);
            //System.out.println("loop1");
        }
        return sum;
    }

    private void update(int i) {
        int n = BIT.length;
        while (i < n) {
            BIT[i] += 1;
            i += (i & -i);
        }
    }
    //find the first index with nums[index] * 2 >= num...
    //查找最左边的
    private int binarySearch(double num, int lo, int hi, int[] nums) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] >= num) {
                hi = mid;
            } else {
                lo = mid + 1;

            }
            //System.out.println("loop3");
        }
        return lo;
    }*/

//直接反转  存的时候往下存，取的时候往下取
/*private int search(int[] bit, int i) {
    int sum = 0;

    while (i < bit.length) {
        sum += bit[i];
        i += i & -i;
    }

    return sum;
}

    private void insert(int[] bit, int i) {
        while (i > 0) {
            bit[i] += 1;
            i -= i & -i;
        }
    }
    public int reversePairs(int[] nums) {
        int res = 0;
        int[] copy = Arrays.copyOf(nums, nums.length);
        int[] bit = new int[copy.length + 1];

        Arrays.sort(copy);

        for (int ele : nums) {
            res += search(bit, index(copy, 2L * ele + 1));
            insert(bit, index(copy, ele));
        }

        return res;
    }

    private int index(int[] arr, long val) {
        int l = 0, r = arr.length - 1, m = 0;

        while (l <= r) {
            m = l + ((r - l) >> 1);

            if (arr[m] >= val) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l + 1;
    }*/


    //自己尝试写一下归并解法
/*    public int reversePairs(int[] nums) {
        return   mergeSort(nums,0,nums.length-1);
    }
    int mergeSort(int []nums,int left,int right){
        if(right<=left) return 0;
        int mid=(left+right)/2;
        int res=mergeSort(nums,left,mid)+mergeSort(nums,mid+1,right);
        int i=left,j=mid+1,p=mid+1,index=0;
        int []copy=new int[right-left+1];
        while (i<=mid){
            while (p<=right&&nums[i]>2L*nums[p]) p++;//防止溢出
            res+=(p-(mid+1));

            while (j<=right&&nums[i]>=nums[j]){
                copy[index++]=nums[j++];
            }
            copy[index++]=nums[i++];
        }
        while (j<=right){
            copy[index++]=nums[j++];
        }
        for (int c = 0; c < copy.length; c++) {
            nums[c+left]=copy[c];
        }
        return res;
    }*/
    public static void main(String[] args) {
        int []arr=new int[]{5,4,3,2,1};
         leet493$ l=new leet493$();
         l.reversePairs(arr);
    }








    // 2020/11/28
   /* public int reversePairs(int[] nums) {

        helper(0,nums.length-1,nums);
        return res;
    }


   int res=0;
    void helper(int left,int right,int []nums){
        System.out.println(left+" "+right);
      if(left>=right)return;

     int mid=(left+right)/2;

     int []temp=new int[right-left+1];
     int index=0;

     helper(left,mid,nums);
     helper(mid+1,right,nums);
     int i=left,j=mid+1,p=mid+1;
     while (i<=mid&&j<=right){

         while (p<=right&&nums[i]>2L*nums[p]) p++;
       if(nums[i]<nums[j]){
           res+=(p-mid-1);
         temp[index++]=nums[i];
         i++;
       }else {
           temp[index++]=nums[j];
           j++;
       }
     }

     while (i<=mid){
         while (p<=right&&nums[i]>2*nums[p]) p++;

         res+=(p-mid-1);
      temp[index++]=nums[i++];
     }

     while (j<=right){
        temp[index++]=nums[j++];
     }

    for(i=0;i<temp.length;i++){
        nums[left+i]=temp[i];
    }

    }
*/

   //  2020/11/28
    public int reversePairs(int[] nums) {
        TreeSet<Long> set=new TreeSet<>();
        for (int num : nums) {
            set.add((long)num);
            set.add((long)num*2L);
        }
        Map<Long,Integer> map=new HashMap<>();
        int index=1;
        for (Long integer : set) {
            map.put(integer,index++);
        }

       FenwickTree fenwickTree=new FenwickTree(index);

        int res=0;
        for (int i=0;i<nums.length;i++) {
          int left=map.get(nums[i]*2L),right=index;
          res+=fenwickTree.query(right)-fenwickTree.query(left);
        fenwickTree.update(map.get(nums[i]),1);
        }

       return res;
        
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
