package leetcode.leetcode1000_;

public class leet1277 {
    //mine 伪Dp.. 实则暴力
 /*  static public int countSquares(int[][] matrix) {
        boolean[][] dp = new boolean[matrix.length + 1][matrix[0].length];
        int res=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = true;
                    res++;
                }
            }

        }
        int maxSum = Math.min(matrix.length, matrix[0].length);
        for (int length = 2; length <= maxSum; length++) {
            boolean[][] tdp = new boolean[matrix.length + 1][matrix[0].length];
            for (int i = length - 1; i < matrix.length; i++) {
                for (int j = length - 1; j < matrix[0].length; j++) {
                    if (matrix[i][j]==1&&dp[i - 1][j - 1] &check(matrix,i,j-length+1,j-1,j,i-length+1,i-1)){
                        tdp[i][j]=true;
                        res++;
                    }
                }
            }
            dp=tdp;
        }
return res;
    }
  static   boolean check(int [][]board,int row,int rowBegin,int rowEnd,int col,int colBegin,int colEnd){

         while (rowBegin<=rowEnd){
           if(board[row][rowBegin]==0) return false;
           rowBegin++;
         }
         while (colBegin<=colEnd){
             if(board[colBegin][col]==0) return false;
             colBegin++;
         }
         return true;
    }
*/



    public int countSquares(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int count = 0;

        for(int i = 0; i < n; i++) if(matrix[i][0] == 1) dp[i][0] = 1;
        for(int j = 0; j < m; j++) if(matrix[0][j] == 1) dp[0][j] = 1;

        // dp[i][j] 表示以i j为右下角的正方形数目
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == 1){
                    //这么理解 最小的那个一定可以和右下角的1做成正方形
                    int min = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    //更新dp
                    dp[i][j] = min;
                }
            }
        }

        //统计结果
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) count += dp[i][j];
        }

        return count;

    }

   /* public int countSquares(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int count = 0;

        for(int i = 0; i < n; i++) if(matrix[i][0] == 1) {
            count ++;
            dp[i][0] = 1;
        }
        //原点多计算了一次
        for(int j = 1; j < m; j++) if(matrix[0][j] == 1){
            dp[0][j] = 1;
            count++;
        }

        // dp[i][j] 表示以i j为右下角的正方形数目
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == 1){
                    //这么理解 最小的那个一定可以和右下角的1做成正方形
                    int min = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    //更新dp
                    dp[i][j] = min;
                    count+=min;
                }
            }
        }

        return count;

    }*/
    public static void main(String[] args) {
      /*  countSquares(new int[][]{
                {1,0,1,1,0},{1,1,1,1,1}
        });*/
    }
}