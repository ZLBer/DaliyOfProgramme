package leetcode._4_30Days;

public class MinimumPathSum {
/*    public int minPathSum(int[][] grid) {
        dp=new int[grid.length][grid[0].length];
        dfs(grid,0,0,grid[0][0]);
        return minSum;
    }
  int[][]dp;
    int minSum=Integer.MAX_VALUE;
    int [][]next=new int[][]{{0,1},{1,0}};
    void dfs(int [][]grid,int x,int y,int sum){


        if(x==grid.length-1&&y==grid[0].length-1){
            minSum=Math.min(minSum,sum);
            return;
        }

        if(dp[x][y]!=0&&sum>=dp[x][y]) return;
        dp[x][y]=sum;

        for (int i = 0; i < next.length; i++) {
            int nextX=x+next[i][0];
            int nextY=y+next[i][1];

            if(nextX>=0&&nextY>=0&&nextX<grid.length&&nextY<grid[0].length)
                dfs(grid,nextX,nextY,sum+grid[nextX][nextY]);
        }


    }*/
    public int minPathSum(int[][] grid) {

        int[][]dp=new int[grid.length][grid[0].length];

        dp[0][0]=grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i]=grid[0][i]+dp[0][i-1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
