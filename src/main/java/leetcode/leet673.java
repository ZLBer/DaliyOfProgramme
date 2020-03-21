package leetcode;

public class leet673 {
    //mine 似暴力非暴力
/*
    public int findNumberOfLIS(int[] nums) {
        if(nums.length==0) return 0;

        int[] dp = new int[nums.length];
        int []count =new int[nums.length];
        Arrays.fill(dp,1);
        int maxSum=1;
        count[0]=1;
          dp[0]=1;
        for (int i = 1; i < nums.length; i++) {
            dp[i]=1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] >= nums[i]) continue;
                else {
                    if(dp[j]+1>dp[i]){
                        dp[i] = dp[j]+1 ;
                        maxSum=Math.maxSum(maxSum,dp[i]);
                    }

                }
            }
            int tc=0;
            for (int j = i - 1; j >= 0; j--) {
                if(nums[j]<nums[i]&&dp[j]+1==dp[i]) tc+=count[j];
            }
            count[i]=tc==0?1:tc;
        }
        //  System.out.println(maxSum);
        int res=0;
        for (int i = 0; i < dp.length; i++) {
            //   System.out.println(dp[i]+" "+count[i]);

            if(dp[i]==maxSum) res+=count[i];
        }
        return res;
    }
*/

   //思路一样 凭什么他的比我快？ 把三个遍历合成一个，tql
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len =  new int[n], cnt = new int[n];
        //把求 最大 和 计数 和 统计结果 全放在一个遍历里面  确实可以
        for(int i = 0; i<n; i++){
            len[i] = cnt[i] = 1;
            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                    if(len[i] == len[j] + 1)cnt[i] += cnt[j];
                    if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(max_len == len[i])res += cnt[i];
            if(max_len < len[i]){
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}
