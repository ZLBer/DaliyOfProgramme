package leetcode.leetcode1_499;

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
/*    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[n + 1][m + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n][m];
    }*/


    //2020/12/9
/*    public int uniquePaths(int m, int n) {
        int [][]dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0){
                    dp[0][0]=1;
                }
                else if(i==0){
                    dp[i][j]=dp[i][j-1];
                }  else if(j==0){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }*/



   //组合数
    public int uniquePaths(int m, int n) {
        return  comnination(m+n-2,n-1);
    }


    // m>=n
    public int comnination(int m,int n){
        if(n==0) return 1;
        long ans = 1;

        for (int x = m-n+1, y = 1; y <=n ; ++x, ++y) {
            ans = ans * x / y;
           // System.out.println(x+" "+y+" "+ans);
        }
        return (int) ans;
    }




    public static void main(String args[]) {

    }

}
