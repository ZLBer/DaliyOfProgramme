package leetcode;

/**
 * Created by libin on 2018/12/30.
 */
public class leet62 {

    //自己写的深度优先遍历，时间超时不通过
//    static  int count=0;
//  static    public int uniquePaths(int m, int n) {
//       count=0;
//          int board[][]=new int[m][n];
//          DFS(0,0,board);
//
//          return count;
//    }
//   static void DFS(int i,int j,int[][] board){
//      // System.out.println("i======"+i+"j====="+j);
//        if (i==board.length-1&&j==board[0].length-1) {
//              count++;
//              return;
//        }
//        if(i<board.length&&j<board[0].length) {
//            if (board[i][j]==0) {
//                board[i][j] = 1;
//                DFS(i + 1, j, board);
//                DFS(i, j + 1, board);
//            }
//            board[i][j]=0;
//   }
//   else return;
//
//    }


    //DP很容易就解决了
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[n + 1][m + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(23,12));
    }
}
