package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/1/10.
 */
public class leet198$ {
    //dp[i][1] means we rob the current house and dp[i][0] means we don't,
    public int rob(int[] nums) {
        int [][]dp =new int[nums.length+1][2];
        for(int i=1;i<=nums.length;i++){
            dp[i][0] =Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i-1];
        }
        return Math.max(dp[nums.length][0],dp[nums.length][1]);
    }
}
