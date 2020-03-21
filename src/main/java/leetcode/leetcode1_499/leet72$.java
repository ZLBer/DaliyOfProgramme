package leetcode.leetcode1_499;

public class leet72$ {
 /*   public int minDistance(String word1, String word2) {
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
    }*/

    //2020/3/14
    public int minDistance(String word1, String word2) {
     int [][]dp=new int[word1.length()+1][word2.length()+1];
     for(int i=0;i<=word1.length();i++){
         dp[i][0]=i;
     }
     for(int i=0;i<=word2.length();i++){
         dp[0][i]=i;
     }


     for(int i=1;i<=word1.length();i++){
         for(int j=1;j<=word2.length();j++){
             if(word1.charAt(i-1)==word2.charAt(j-1)){
                 dp[i][j]=dp[i-1][j-1];
             }else {
                 //分别对应 增加一个、删除一个、改变一个
                 dp[i][j]=Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
             }
         }
     }
     return dp[word1.length()][word2.length()];
    }

    //不用二维数组
/*    public int minDistance(String word1, String word2) {
        int []dp=new int[word2.length()+1];
        for(int i=0;i<=word1.length();i++){
            dp[i]=i;
        }
        int pre=0;
        for(int i=1;i<=word1.length();i++){
            pre=dp[0];//用来保存之前的dp[i-1][j-1]
            dp[0]=i;
            for(int j=1;j<=word2.length();j++){
                int temp=dp[j];
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[j]=pre;
                }else {
                    //分别对应 增加一个、删除一个、改变一个
                    dp[j]=Math.min(pre,Math.min(dp[j-1],dp[j]))+1;
                }
                pre=temp;
            }
        }
        return dp[word2.length()];
    }*/
}
