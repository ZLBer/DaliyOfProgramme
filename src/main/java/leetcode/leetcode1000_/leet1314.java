package leetcode.leetcode1000_;

public class leet1314 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][]res=new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int sum=0;
                for(int r=Math.max(0,i-K);r<=Math.min(mat.length-1,i+K);r++){
                    for(int c=Math.max(0,j-K);c<=Math.min(mat[0].length-1,j+K);c++){
                        sum+=mat[r][c];
                    }
                }
                res[i][j]=sum;
            }
        }
        return res;
    }


    //前项和也可以做 这里就不试了
 /*   public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] rangeSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                rangeSum[i + 1][j + 1] = rangeSum[i + 1][j] + rangeSum[i][j + 1] - rangeSum[i][j] + mat[i][j];
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                int r1 = Math.maxSum(0, i - K), c1 = Math.maxSum(0, j - K), r2 = Math.min(m, i + K + 1), c2 = Math.min(n, j + K + 1);
                ans[i][j] = rangeSum[r2][c2] + rangeSum[r1][c1] - rangeSum[r2][c1] - rangeSum[r1][c2];
            }
        return ans;
    }*/
}
