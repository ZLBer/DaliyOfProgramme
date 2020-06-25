package leetcode._4_30Days;

public class MaximalSquare {
    //mine
/*    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
     int [][]dp=new int[matrix.length+1][matrix[0].length+1];
     int [][]row=new int[matrix.length+1][matrix[0].length+1];
     int [][]col=new int[matrix.length+1][matrix[0].length+1];
       int res=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]=='1'){
                    row[i+1][j+1]=row[i][j+1]+1;
                    col[i+1][j+1]=col[i+1][j]+1;
                dp[i+1][j+1]=Math.min(dp[i][j]+1,Math.min(row[i+1][j+1],col[i+1][j+1]));
      res =Math.max(res,dp[i+1][j+1]);


                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < row[0].length; j++) {
                System.out.print(row[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < row[0].length; j++) {
                System.out.print(col[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < row[0].length; j++) {
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
        return res*res;    }*/

//没必要那么多
    public int maximalSquare(char[][] a) {
        if(a.length == 0) return 0;
        int m = a.length, n = a[0].length, result = 0;
        int[][] b = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(a[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        return result*result;
    }
}
