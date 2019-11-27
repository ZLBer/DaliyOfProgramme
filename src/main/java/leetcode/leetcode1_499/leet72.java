package leetcode.leetcode1_499;

public class leet72 {
    public int minDistance(String word1, String word2) {
         int m=word2.length();
         int n=word1.length();
         int [][]dp=new int[m+1][n+1];
         for(int i=0;i<=m;i++){
             dp[i][0]=i;
         }

         for(int i=0;i<=n;i++){
              dp[0][i]=i;
         }

         for(int i=1;i<=m;i++){
             for(int j=1;j<=n;j++){
                 if(word2.charAt(i-1)==word1.charAt(j-1)){
                     dp[i][j]=dp[i-1][j-1];
                 }else {
                     int a=dp[i-1][j]+1;
                     int b=dp[i][j-1]+1;
                     int c=dp[i-1][j-1]+1;
                     dp[i][j]=Math.min(a,Math.min(b,c));
                 }
             }
         }
         return dp[m][n];
    }
}
