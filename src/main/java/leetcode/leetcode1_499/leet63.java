package leetcode.leetcode1_499;

/**
 * Created by libin on 2018/12/30.
 */
public class leet63 {
    //DFS依然超时
//    static  int count=0;
//  static    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//       count=0;
//
//          DFS(0,0,obstacleGrid);
//
//          return count;
//    }
//   static void DFS(int i,int j,int[][] board){
//      // System.out.println("i======"+i+"j====="+j);
//        if (i==board.length-1&&j==board[0].length-1&&board[board.length-1][board[0].length-1]!=1) {
//              count++;
//            System.out.println(count);
//              return;
//        }
//        if(i<board.length&&j<board[0].length) {
//            if (board[i][j]==0) {
//                board[i][j] = 2;
//                DFS(i + 1, j, board);
//                DFS(i, j + 1, board);
//            }
//          if (board[i][j]==2)
//              board[i][j]=0;
//   }
//   else return;
//
//    }
  static   public int uniquePathsWithObstacles(int[][] obstacleGrid) {
      int row = obstacleGrid.length;
      int column = obstacleGrid[0].length;


      if (obstacleGrid[0][0] == 1) {
          return 0;
      }
      obstacleGrid[0][0] = 1;
  //    int i=1;
//for( i=1;i<row;i++){
//    if(obstacleGrid[i][0]==0) obstacleGrid[i][0]=1;
//    else break;
//}
//
//for(;i<row;i++){
//    obstacleGrid[i][0]=0;
//}

      //更简便的写法
      for(int i=1;i<row;i++){  obstacleGrid[i][0]=(obstacleGrid[i][0]==0&&obstacleGrid[i-1][0]==1)?1:0;

      }
      for(int i=1;i<column;i++){
          obstacleGrid[0][i]=(obstacleGrid[0][i]==0&&obstacleGrid[0][i-1]==1)?1:0;
      }
      for(int i=1;i<row;i++){
          for(int j=1;j<column;j++){
              if(obstacleGrid[i][j]==0) obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
              else obstacleGrid[i][j]=0;
          }
      }



return obstacleGrid[row-1][column-1];
  }

    public static void main(String[] args) {
//       int [][]board= {
//               {0, 0, 0},
//               {0, 1, 0},
//               {0 ,0,  0}
//       };
        int board[][]={{0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},{0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0},{1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,1},{0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0},{0,0,0,1,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0},{1,0,1,1,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0},{0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,1,0,0,0,0,1},{0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,1},{1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,1,0,0,1,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,1,1,0,1,0,0,0,0,1,1},{0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1},{1,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,1},{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0}};
               System.out.println(uniquePathsWithObstacles(board));
    }
}
