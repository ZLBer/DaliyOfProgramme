package leetcode.leetcode500_999;

public class leet712$ {
    public int minimumDeleteSum(String s1, String s2) {
      int [][]dp=new int[s1.length()+1][s2.length()+1];
      char[] s1Array=s1.toCharArray();
      char [] s2Array=s2.toCharArray();
      for(int i=1;i<dp[0].length;i++){
          dp[0][i]=dp[0][i-1]+s2Array[i-1];
      }
      for(int i=1;i<dp.length;i++){
          dp[i][0]=dp[i-1][0]+s1Array[i-1];
      }

      for(int i=1;i<dp.length;i++){
          for(int j=1;j<dp[0].length;j++){
              if(s1Array[i-1]==s2Array[j-1])
                  dp[i][j]=dp[i-1][j-1];
              else {
                  dp[i][j]=Math.min(dp[i-1][j]+s1Array[i-1],dp[i][j-1]+s2Array[j-1]);
                //  dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]+s1Array[i-1]+s2Array[j-1]);

              }
          }
      }
      return dp[s1.length()][s2.length()];
    }
}
