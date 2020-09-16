package leetcode.leetcode1000_1499;

public class leet1035$ {
    //其实就i是最长公共子序列
    public int maxUncrossedLines(int[] A, int[] B) {
        int a=A.length,b=B.length;
        int [][]dp= new int[a+1][b+1];
        for(int i=1;i<=a;i++){
            for(int j=1;j<=b;j++){
                if(A[i-1]==B[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);

            }
        }
   return dp[a][b];
    }
}
