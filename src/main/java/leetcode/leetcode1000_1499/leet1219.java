package leetcode.leetcode1000_1499;

public class leet1219 {
   static int [][]dir={
            {0,1},{0,-1},{1,0},{-1,0}
    };
 static    int maxSum=0;
   static public int getMaximumGold(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0)
                    DFS(grid,i,j,0);
            }
        }
        return maxSum;
    }

    static void  DFS(int[][]grid,int x,int y,int sum){
        int gold=grid[x][y];
        sum+=gold;
        grid[x][y]=0;
        maxSum=Math.max(sum,maxSum);
        for (int i = 0; i < dir.length; i++) {
           int tx=x+dir[i][0];
           int ty=y+dir[i][1];
           if(tx>=0&&ty>=0&&tx<grid.length&&ty<grid[0].length&&grid[tx][ty]!=0){
              DFS(grid,tx,ty,sum);
           }
        }
        grid[x][y]=gold;
    }

    public static void main(String[] args) {
        getMaximumGold(new int[][]{
                {0,6,0},
                {5,8,7},
                {0,9,0}

        });
    }
}
