package leetcode;

import java.util.Arrays;

public class leet1589 {

    //差分还是别人高速的
    //就是两次排序
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
  int []f=new int[nums.length+1];
        for (int[] request : requests) {
            int a=request[0],b=request[1];

          f[a]+=1;
          f[b+1]-=1;

        }
        for (int i = 0; i < f.length-1; i++) {
           f[i+1]+=f[i];
        }


        Arrays.sort(f);
        Arrays.sort(nums);
        long res=0;
        for (int i = 0; i < nums.length; i++) {
            res=(res+(long)nums[i]*f[i+1])%1000000007;
        }
       return (int)res;

    }
}
