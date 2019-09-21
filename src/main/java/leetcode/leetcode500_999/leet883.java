package leetcode.leetcode500_999;

public class leet883 {
    public int projectionArea(int[][] grid) {
        int countNOTzero=0;
        int countMaxY[]=new int[grid[0].length];
        int countMaxX[]=new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
          for(int j=0;j<grid[i].length;j++){
              if(grid[i][j]!=0) countNOTzero++;

              countMaxY[j]=Math.max(countMaxY[j],grid[i][j]);
              countMaxX[i]=Math.max(countMaxX[i],grid[i][j]);
          }
        }

        int result=countNOTzero;
        for (int a:countMaxX){
            result+=a;
        }
        for(int a:countMaxY){
            result+=a;
        }
return result;
    }
}
