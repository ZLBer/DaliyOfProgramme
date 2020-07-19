package leetcode;

public class leet1510 {

    //就自己拼拼凑凑就过了？?
    public boolean winnerSquareGame(int n) {
      boolean []dp=new boolean[n+1];
    for(int i=0;i<n;i++) {
      for(int j=1;i+j*j<=n;j++){
          //下一个状态取反 ，为了保证alice是最佳，只要有一个true就可以哦
          dp[i+j*j]|=!dp[i];
      }
    }
    return dp[n];
    }
}
