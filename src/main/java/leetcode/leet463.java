package leetcode;

/**
 * Created by libin on 2017/9/9.
 */
public class leet463 {
    public int islandPerimeter(int[][] grid) {
        int island=0;
        int neignbor=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1) island++;
                if(grid[i][j]==1&&j<grid[i].length-1&&grid[i][j+1]==1) neignbor++;
                if(grid[i][j]==1&&i<grid.length-1&&grid[i+1][j]==1)neignbor++;
            }
        return island*4-neignbor*2;
    }
}
