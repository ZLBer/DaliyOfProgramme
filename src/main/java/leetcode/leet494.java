package leetcode;

/**
 * Created by libin on 2019/1/22.
 */
public class leet494 {
        //mine  DFS  BF
 /*   int count=0;
    public int findTargetSumWays(int[] nums, int S) {
     helper(nums,S,0,0);
     return count;
    }

    void helper(int []nums,int S,int index,int sum){
          if(index==nums.length) return;
          if(index==nums.length-1&&sum+nums[index]==S)  count++;
          if(index==nums.length-1&&sum-nums[index]==S)  count++;
          helper(nums,S,index+1,sum+nums[index]);
          helper(nums,S,index+1,sum-nums[index]);
    }
*/





    //DP
    /*
     *
     *
     * @author BNer
     * @date 2019/1/22 20:54
The original problem statement is equivalent to:
Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target

Let P be the positive subset and N be the negative subset
For example:
Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]

Then let's see how this can be converted to a subset sum problem:

                  sum(P) - sum(N) = target
sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                       2 * sum(P) = target + sum(nums)
So the original problem has been converted to a subset sum problem as follows:

Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2

Note that the above formula has proved that target + sum(nums) must be even

     */
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        //全部加起来还小于s或者 s+sum是奇数  则不存在P                   //(s+sum)/2
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }
  //// TODO: 2019/1/23  不是很理解DP
    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }
}
