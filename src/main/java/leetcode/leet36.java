package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leet36 {

    //很巧妙的用一次排序就完事了
 /*   public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> column = new HashSet<>();
            Set<Character> chunk = new HashSet<>();
for(int j=0;j<board[0].length;j++){
    if(board[i][j]!='.'&&!row.add(board[i][j])){
        return false;
    }
    if(board[j][i]!='.'&&!column.add(board[j][i])){
        return false;
    }


    int rowIndex=(i/3)*3;
    int colIndex=(i%3)*3;
    if(board[rowIndex + j/3][colIndex + j%3]!='.' && !chunk.add(board[rowIndex + j/3][colIndex + j%3]))
        return false;


}
        }
        return true;
    }*/


   //编码一下 真的skrskr
    //https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings
    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
