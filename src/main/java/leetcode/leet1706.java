package leetcode;

public class leet1706 {


    Integer [][]memo;
    public int[] findBall(int[][] grid) {
   memo=new Integer[grid.length][grid[0].length];


     int []ans=new int[grid[0].length];
        for (int b = 0; b < grid[0].length; b++) {
         ans[b]=helper(0,b,grid);
        }
        return ans;
    }

    int helper(int x,int y,int [][]grid){
        if(y<0||y>=grid[0].length) return -1;

        if(x>=grid.length) return y;

     if(memo[x][y]!=null) return memo[x][y];
     int res=0;
      if(grid[x][y]==1){
        if(y+1<grid[0].length&&grid[x][y+1]==-1) {
            res=-1;
        }else {
            res= helper(x+1,y+1,grid);
        }

      } else {
          if(y-1>=0&&grid[x][y-1]==1){
              res= -1;
          }else {
              res= helper(x+1,y-1,grid);
          }

      }
    return (memo[x][y]=res);

    }


    //直接用数组模拟就好
    /*public int[] findBall(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] ans = new int[col];

        // 默认位置
        for (int i = 0; i < col; i++) {
            ans[i] = i;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ans[j] == -1) {//忽略卡住的球
                    continue;
                }
                if (grid[i][ans[j]] == 1 && ans[j] + 1 < col && grid[i][ans[j] + 1] == 1) {
                    //右移
                    ans[j]++;
                } else if (grid[i][ans[j]] == -1 && ans[j] - 1 >= 0 && grid[i][ans[j] - 1] == -1) {
                    //左移
                    ans[j]--;
                } else {
                    //卡住
                    ans[j] = -1;
                }
            }
        }
        return ans;
    }*/

}
