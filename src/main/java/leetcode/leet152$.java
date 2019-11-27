package leetcode;

public class leet152$ {
    //最大连续和
/*
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
     int []dp=new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            if(dp[i]>0){
                dp[i+1]+=dp[i]+nums[i];
            }else {
                dp[i+1]=nums[i];
            }
            max= Math.max(max,dp[i+1]);
        }
        return max;
    }
*/

    // 最大连续成绩乘积
      //依赖两个状态的动态规划问题
/*  static   public int maxProduct(int[] nums) {
         int res=nums[0];
       int []min=new int[nums.length];
        int []max=new int[nums.length];
        min[0]=nums[0];
        max[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
           min[i]=Math.min(nums[i],Math.min(nums[i]*min[i-1],nums[i]*max[i-1]));
           max[i]=Math.max(nums[i],Math.max(nums[i]*max[i-1],nums[i]*min[i-1]));
           res=Math.max(res,max[i]);
        }
        return res;
    }*/
//放弃使用两个数组
static public int maxProduct(int[] nums) {
      int min=nums[0];
      int max=nums[0];
      int res=nums[0];
    for (int i = 1; i < nums.length; i++) {
        if(nums[i]<0){
            int temp=min;
            min=max;
            max=temp;
        }
        max=Math.max(nums[i],nums[i]*max);
        min=Math.min(nums[i],nums[i]*min);
        res=Math.max(res,max);
    }
    return res;
}
 /*  static public int maxProduct(int[] nums) {
        int max =nums[0] , imax =nums[0], imin = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] < 0){ int tmp = imax; imax = imin; imin = tmp;}
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }*/
    public static void main(String[] args) {
        maxProduct(new int[]{2,3,-2,4});
    }
}
