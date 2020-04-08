package leetcode;

/**
 * Created by libin on 2017/10/10.
 */
public class leet695 {
    public int maxAreaOfIsland(int[][] grid) {
        int  maxArea=0;
     int [][]selected=new int[grid.length][grid[0].length];
     for(int i=0;i<grid.length;i++){
         for(int j=0;j<grid[i].length;j++){
            if(selected[i][j]==1) continue;
            else  maxArea=Math.max(maxArea,isIsland(grid,i,j,selected));
         }
     }
     return maxArea;
    }
    int isIsland(int [][]grid,int i,int j,int[][]selected){
        if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&selected[i][j]==0&&grid[i][j]==1) {
            selected[i][j]=1;
            return 1 + isIsland(grid, i + 1, j, selected) + isIsland(grid, i, j + 1, selected) + isIsland(grid, i - 1, j, selected) + isIsland(grid, i, j - 1, selected);
        }
        else return 0;

    }
}
