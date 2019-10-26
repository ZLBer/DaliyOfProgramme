package leetcode;

public class leet64 {
    int[]next={

    };
    //TLE    25 / 61 test cases passed.
/*    public int minPathSum(int[][] grid) {
       DFS(0,0,grid,0);
       return minCost;
    }
int minCost=Integer.MAX_VALUE;
    void DFS(int x,int y,int[][]grid,int cost){
         if(x==grid.length-1&&y==grid[0].length-1){
             minCost=Math.min(cost+grid[x][y],minCost);
             return;
         }
if(x+1<grid.length)
         DFS(x+1,y,grid,cost+grid[x][y]);
if(y+1<grid[0].length)
      DFS(x,y+1,grid,cost+grid[x][y]);
    }*/




// TLE 60 / 61 test cases passed. 怎么剪枝都通不过
/*
    public int minPathSum(int[][] grid) {
        DFS(0,0,grid,0);
        return minCost;
    }
    int minCost=Integer.MAX_VALUE;
    void DFS(int x,int y,int[][]grid,int cost){
        if(x==grid.length-1&&y==grid[0].length-1){
            minCost=Math.min(cost+grid[x][y],minCost);
            return;
        }
   if(cost>=minCost) return;
        if(x+1<grid.length)
            DFS(x+1,y,grid,cost+grid[x][y]);
    if(cost>=minCost) return;
        if(y+1<grid[0].length)
            DFS(x,y+1,grid,cost+grid[x][y]);
    }
*/


    //mine 反手给你一个dp
    public int minPathSum(int[][] grid) {
        for(int i=1;i<grid[0].length;i++){
            grid[0][i]+=grid[0][i-1];
        }
        for(int i=1;i<grid.length;i++){
            grid[i][0]+=grid[i-1][0];
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }

return  grid[grid.length-1][grid[0].length-1];

    }
}
