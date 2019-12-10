package leetcode;

public class leet1275 {
    //mine  每次都去检查状态
/*
    public String tictactoe(int[][] moves) {
        int[][]board=new int[3][3];
        int count=0;
        for (int i = 0; i < moves.length; i++) {
            count++;
          //放置1
            if(i%2==0) {
                board[moves[i][0]][moves[i][1]]=1;
                if(check(board,1)) return "A";
            }
            else{
                board[moves[i][0]][moves[i][1]]=2;
                if(check(board,2)) return "B";
            }
        }
        if(count==9) return "Draw";
        else return "Pending";
    }

    boolean check(int[][]board,int player){

        for(int i=0;i<board.length;i++){
            int countRow=0;
            int countCol=0;
         for(int j=0;j<board[0].length;j++){
             if(board[i][j]==player) countRow++;
             if(board[j][i]==player) countCol++;
         }
         if(countRow==3||countCol==3) return true;
        }

        int countX=0;
        for(int i=0;i<board.length;i++){
             if(board[i][i]==player) countX++;
        }
        if(countX==3) return true;
        countX=0;
        for(int i=0,j=2;i<board.length;i++,j--){
           if(board[i][j]==player) countX++;
        }
        if(countX==3) return true;
        return false;
    }
*/


    //不用每次都去检查   只需要检查行 列 对角线
    public String tictactoe(int[][] moves) {
        int[] aRow = new int[3], aCol = new int[3], bRow = new int[3], bCol = new int[3];
        int  aD1 = 0, aD2 = 0, bD1 = 0, bD2 = 0;
        for (int i = 0; i < moves.length; ++i) {
            int r = moves[i][0], c = moves[i][1];
            //B回合
            if (i % 2 == 1) {
                //分别检查b的行 列  正对角线  斜对角线
                if (++bRow[r] == 3 || ++bCol[c] == 3 || r == c && ++bD1 == 3 || r + c == 2 && ++bD2 == 3) return "B";
            }else {
                //同理
                if (++aRow[r] == 3 || ++aCol[c] == 3 || r == c && ++aD1 == 3 || r + c == 2 && ++aD2 == 3) return "A";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}