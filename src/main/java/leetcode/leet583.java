package leetcode;

public class leet583 {

    //mine dp舒服了
    public int minDistance(String word1, String word2) {
      int[][]dp=new int[word1.length()+1][word2.length()+1];
        dp[0][0]=0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0]=dp[i-1][0]+1;
        }
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=dp[0][i-1]+1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
               if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
               else dp[i][j]= Math.min(dp[i][j-1],dp[i-1][j])+1;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }




    //先求公共子串 然后再减出来
   /* public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i <= word1.length(); i++) {
            for(int j = 0; j <= word2.length(); j++) {
                if(i == 0 || j == 0) dp[i][j] = 0;
                else dp[i][j] = (word1.charAt(i-1) == word2.charAt(j-1)) ? dp[i-1][j-1] + 1
                        : Math.maxSum(dp[i-1][j], dp[i][j-1]);
            }
        }
        int val =  dp[word1.length()][word2.length()];
        return word1.length() - val + word2.length() - val;
    }*/
}
