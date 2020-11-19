package leetcode;

public class leet377 {
    public int combinationSum4(int[] nums, int target) {
    int []dp=new int[target+1];
    dp[0]=1;
        for (int i = 1; i < dp.length; i++) {
            for (int num : nums) {
                int pre=i-num;
               if(pre<0)continue;
               dp[i]+=dp[pre];
            }    
        }
        return dp[target];
    }
}
