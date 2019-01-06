package leetcode;

/**
 * Created by libin on 2018/12/29.
 */
public class leet79 {

static public boolean exist(char[][] board, String word) {
if(board[0].length==1&&board.length==1&&word.length()==1)
    if (board[0][0]==word.charAt(0))return  true;

        for(int i=0; i<board.length;i++)
            for(int j=0;j<board[0].length;j++) {
              //  System.out.println("i++++" + i + "j+++++" + j);
                int[][] isSearch=new int   [board.length][board[0].length];
                if (DFS(board, word, i, j, 0, isSearch))
                    return true;
            }
        return false;

    }
  static boolean DFS(char[][] board, String word,int i,int j,int r,int [][]isSearch){
        int length=board.length;
        int width=board[0].length;
      System.out.println("i++++" + i + "j+++++" + j);
     // System.out.println("r====="+r);
      if (r==word.length()) return true;
      if(isSearch[i][j]==0&&board[i][j]==word.charAt(r)) {
          System.out.println("正确");
          isSearch[i][j] = 1;
          if(i+1<length)
             if(DFS(board,word,i+1,j,r+1,isSearch))
                 return true; //下
          if(i-1>=0)
             if(DFS(board,word,i-1,j,r+1,isSearch))
                 return  true;//上
          if(j-1>=0)
             if(DFS(board,word,i,j-1,r+1,isSearch))
                 return true; //左
          if(j+1<width)
              if(DFS(board,word,i,j+1,r+1,isSearch))
                  return true; //右

      }
      else return false;
       isSearch[i][j]=0;
      return false;
   }


    public static void main(String[] args) {

//      char [][]board=
//              {
//                      {'a', 'a', 'a','a'},
//                      {'a', 'a', 'a','a'},
//                      {'a', 'a', 'a','a'}
//};
      //  char [][]board={{'a'}};
        char [][]board=
                {
                        {'C', 'A', 'A'},
                        {'A', 'A', 'A'},
                        {'B', 'C', 'D'}
                };


//              char [][]board=
//              {
//                      {'A', 'B', 'C','E'},
//                      {'S', 'F', 'E','S'},
//                      {'A', 'D', 'E','E'}
//};

        System.out.println( exist(board,"AAB"));
    }
}
