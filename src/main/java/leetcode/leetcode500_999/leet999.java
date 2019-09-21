package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/4/11.
 */
public class leet999 {
    public int numRookCaptures(char[][] board) {
        int []index=new  int[2];
        int result=0;
        //find rook
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[i].length; i1++) {
                if(board[i][i1]=='R') {
                    index[0]=i;
                    index[1]=i1;
                }
            }
        }
       //搜索列
        int search=index[0];
        //列上
        for (int i=search-1;i>=0;i--){
          if(board[i][index[1]]=='B') break;
          else if(board[i][index[1]]=='p'){
              result++;
              break;
          }
        }
        //列下
        for (int i=search+1;i<board.length;i++){
            if(board[i][index[1]]=='B') break;
            else if(board[i][index[1]]=='p'){
                result++;break;
            }
        }
        //搜索行
        search=index[1];
        for (int i=search-1;i>=0;i--){
            if(board[index[0]][i]=='B') break;
            else if(board[index[0]][i]=='p'){
                result++;
                break;
            }
        }
        for (int i=search+1;i<board[0].length;i++){
            if(board[index[0]][i]=='B') break;
            else if(board[index[0]][i]=='p'){
                result++;
                break;
            }
        }
        return result;
    }


// 更优雅的做法
//    public int numRookCaptures(char[][] board) {
//        int x0 = 0, y0 = 0, res = 0;
//        for (int i = 0; i < 8; ++i)
//            for (int j = 0; j < 8; ++j)
//                if (board[i][j] == 'R') {
//                    x0 = i;
//                    y0 = j;
//                }
//
//        for (int[] d : new int[][] {{1, 0}, {0, 1}, { -1, 0}, {0, -1}}) {
//            for (int x = x0 + d[0], y = y0 + d[1]; 0 <= x && x < 8 && 0 <= y && y < 8; x += d[0], y += d[1]) {
//                if (board[x][y] == 'p') res++;
//                if (board[x][y] != '.') break;
//            }
//        }
//        return res;
//    }
}
