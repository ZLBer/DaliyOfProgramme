package leetcode.leetcode1000_1499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet1222 {
    int [][]direct={{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,-1},{-1,1}};
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
          List<List<Integer>> result=new ArrayList<>();
          boolean [][]board=new boolean[8][8];
        for (int i = 0; i < queens.length; i++) {
             board[queens[i][0]][queens[i][1]]=true;
        }
        for (int i = 0; i < direct.length; i++) {
            int originX=king[0];
            int originY=king[1];
            int x=originX+direct[i][0];
            int y=originY+direct[i][1];
            for (int j=1;(x>=0&&y>=0&&x<board.length&&y<board.length);j++){

                if(board[x][y]==true){
              result.add(Arrays.asList(x,y));
                    break;
                }
                x+=direct[i][0];
                y+=direct[i][1];
            }
        }

        return result;
    }


}
