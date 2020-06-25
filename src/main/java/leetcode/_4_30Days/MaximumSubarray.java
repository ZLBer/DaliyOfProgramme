package leetcode._4_30Days;

public class MaximumSubarray {
    //mine  其实也是动态规划吧
  /*  public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int res=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(sum<0) sum=0;
            sum+=nums[i];
            res=Math.max(sum,res);


        }
        return res;
    }*/

//带数组的动态规划
    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
