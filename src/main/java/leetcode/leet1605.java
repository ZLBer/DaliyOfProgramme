package leetcode;

public class leet1605 {

    //mine 这也算贪心吧
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        int j = 0;
        for (int i = 0; i < rowSum.length; i++) {
            while (j < colSum.length) {
                if (rowSum[i] > colSum[j]) {
                    res[i][j] = colSum[j];
                    rowSum[i] -= colSum[j];
                    j++;
                } else {
                    res[i][j] = rowSum[i];
                    colSum[j] -= rowSum[i];
                    break;
                }
            }
        }
        return res;
    }


    //这个贪心就有点不讲道理了啊
    //但其实和上面的过程是一样的
  /*  public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length, m = colSum.length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }
        return ans;

    }*/
}
