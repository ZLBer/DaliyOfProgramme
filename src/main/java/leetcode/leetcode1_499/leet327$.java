package leetcode.leetcode1_499;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leet327$ {

    //2020/11/07 勉勉强强能过..
   /* public int countRangeSum(int[] nums, int lower, int upper) {
        int res=0;
        for(int len=0;len<nums.length;len++){

            long sum=0;
            for(int begin=0;begin+len<nums.length;begin++){
                if(begin==0){ //初始化
                    for(int i= begin;i<=begin+len;i++){
                        sum+=nums[i];
                    }
                }else {
                    sum-=nums[begin-1];
                    sum+=nums[begin+len];
                }
                System.out.println(sum);
                if(sum>=lower&&sum<=upper){
                    res++;
                }
            }
        }
        return res;
    }*/
    //TreeMap+数学
    /*public int countRangeSum(int[] nums, int lower, int upper) {
        TreeMap<Long,Integer> treeMap=new TreeMap<>();

        long sum=0;
        int res=0;
        treeMap.put(0L,1);
        for (int num : nums) {
          sum+=num;
          for(int count:treeMap.subMap(sum-upper,true,sum-lower,true).values()){
              res+=count;
          }
        treeMap.put(sum,treeMap.getOrDefault(sum,0)+1);
        }
        return res;
    }*/

    //归并排序 自己写


    //树状数组
  static   public int countRangeSum(int[] nums, int lower, int upper) {
        List<Long> cand = new ArrayList<>();
        cand.add(Long.MIN_VALUE); // make sure no number gets a 0-index.
        cand.add(0L);
        long[] sum = new long[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            cand.add(sum[i]);
            cand.add(lower + sum[i - 1] - 1);
            cand.add(upper + sum[i - 1]);
        }
        Collections.sort(cand); // finish discretization

        int[] bit = new int[cand.size()];
        for (int i = 0; i < sum.length; i++) plus(bit, Collections.binarySearch(cand, sum[i]), 1);
        int ans = 0;
        //看后边有多少符合条件的
        for (int i = 1; i < sum.length; i++) {
          plus(bit, Collections.binarySearch(cand, sum[i - 1]), -1); //把序号小的删掉
            ans += query(bit, Collections.binarySearch(cand, upper + sum[i - 1]));
            ans -= query(bit, Collections.binarySearch(cand, lower + sum[i - 1] - 1));
        }
        return ans;
    }

  static   private void plus(int[] bit, int i, int delta) {
        for (; i < bit.length; i += i & -i) bit[i] += delta;
    }

  static   private int query(int[] bit, int i) {
        int sum = 0;
        for (; i > 0; i -= i & -i) sum += bit[i];
        return sum;
    }



    public static void main(String[] args) {
        countRangeSum(new int[]{1,5},0,9);
    }
}
