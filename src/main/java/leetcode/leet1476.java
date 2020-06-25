package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet1476 {
   //mine


    class SubrectangleQueries {
        Map<String,Integer> map=new HashMap<>();
        int [][]rectangle;
        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle=rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for(int i=row1;i<=row2;i++){
                for(int j=col1;j<=col2;j++){
                   rectangle[i][j]=newValue;
                }
            }
        }

        public int getValue(int row, int col) {

     return  rectangle[row][col];
        }
    }
}
