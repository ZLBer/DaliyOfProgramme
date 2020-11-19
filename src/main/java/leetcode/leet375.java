package leetcode;

public class leet375 {

    //区间dp
    public int getMoneyAmount(int n) {
      int [][]dp=new int[n+1][n+1];

      for(int i=n;i>=1;i--){
          for(int j=i+1;j<=n;j++){
              dp[i][j]=Integer.MAX_VALUE;
              for(int k=i+1;k<j;k++){
                  dp[i][j]=Math.min(dp[i][j],k+Math.max(dp[i][k-1],dp[k+1][j]));
              }

              dp[i][j]=Math.min(dp[i][j],i+dp[i+1][j]);
              dp[i][j]=Math.min(dp[i][j],j+dp[i][j-1]);


          }
      }
      return dp[1][n];
    }
}
