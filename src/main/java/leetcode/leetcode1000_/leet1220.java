package leetcode.leetcode1000_;

public class leet1220 {
    public int countVowelPermutation(int n) {
        int mod=1000000000+7;
        long[][]dp=new long[n][5];
      for (int i=0;i<5;i++){
          dp[0][i]=1;
      }
      //a e i o u
      for(int i=1;i<dp.length;i++){
          dp[i][0]=((dp[i-1][1]+dp[i-1][2])%mod+dp[i-1][4])%mod;
          dp[i][1]=(dp[i-1][0]+dp[i-1][2])%mod;
          dp[i][2]=(dp[i-1][1]+dp[i-1][3])%mod;
          dp[i][3]=dp[i-1][2];
          dp[i][4]=(dp[i-1][2]+dp[i-1][3])%mod;
      }
      long sum=0;
      for(int i=0;i<5;i++){
          sum+=dp[n-1][i];
          sum%=mod;
      }
      return (int) sum;
    }
}
