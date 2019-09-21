package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/1/17.
 */
public class leet419$ {
    /*  
     *    
    X..X
    ...X
    ...X
     */

    //更像是个脑筋急转弯
    public int countBattleships(char[][] board) {
        int width=board.length;
        int length=board[0].length;
        int count=0;
        for(int i=0;i<width;i++){
            for(int j=0;j<length;j++){
                if(board[i][j]=='.') continue;
                if(i>0&&board[i-1][j]=='X') continue;
                if(j>0&&board[i][j-1]=='X') continue;
                count++;
            }
        }
        return count;
    }
}
