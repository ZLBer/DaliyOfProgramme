package leetcode;

public class leet37 {

    //mine 比较长的长一个题
    //基本就是回溯吧  注意状态复原！
    public void solveSudoku(char[][] board) {
   dfs(board,0,0);
    }
    boolean dfs(char[][]board,int x,int y){
        if(x>=board.length){
            return true;
        }
        //已经有数字了 继续搜索
        if(board[x][y]!='.'){
           y++;
           if(y==board[0].length){
               x++;
               y=0;
           }
           if (dfs(board,x,y)) return true;
            else return false;
        }
       //若没有占有 需要填数字
        for(int num=1;num<10;num++){
            board[x][y]=(char)(num+'0');
            if(check(board,x,y)) {
                int ty=y+1,tx=x;
                if(ty==board[0].length){
                    tx++;
                    ty=0;
                }
                if (dfs(board,tx,ty)) return true;
            }
        }
     //记得回退！！！！！！！！！搞了我好久
   board[x][y]='.';
    return false;
    }

     boolean check(char[][]board,int r,int c){
        int []count=new int[10];
        for(int i=0;i<9;i++){
            if(board[r][i]!='.'&&count[board[r][i]-'0']++>0) return false;
        }
        count=new int[10];
        for(int i=0;i<9;i++){
            if(board[i][c]!='.'&&count[board[i][c]-'0']++>0) return false;
        }
        count=new int[10];
       int beginR=r/3*3,beginC=c/3*3;
        for(int i=beginR;i<beginR+3;i++){
            for(int j=beginC;j<beginC+3;j++){
                if(board[i][j]!='.'&&count[board[i][j]-'0']++>0) return false;
            }
        }
        return true;
    }


    //别人的想法
    //我感觉没我的直接  它是以整个期盼状态作为dfs的深度 我是一个格子一个格子
  /*  public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell
                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }*/


    public static void main(String[] args) {
   /*     solveSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}
        });*/
    }
}
