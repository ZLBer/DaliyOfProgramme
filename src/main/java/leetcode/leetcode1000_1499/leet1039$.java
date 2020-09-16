package leetcode.leetcode1000_1499;

public class leet1039$ {
    public int minScoreTriangulation(int[] A) {
        //类似于矩阵连乘积
        //斜着算
        //dp[i][j]表示从i到j的最小三角
        // dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]
    int n=A.length;
    int[][]dp=new int[n][n];
    for(int d=2;d<n;d++){;
        for(int i=0;i+d<n;i++){
          int j=i+d;
          dp[i][j]=Integer.MAX_VALUE;
          for(int k=i+1;k<j;k++){
              dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]+A[i]*A[j]*A[k]);
          }
        }

    }
    return dp[0][n-1];
    }
}
