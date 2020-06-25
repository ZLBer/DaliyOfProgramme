package leetcode._4_30Days;

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int res=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    int [][]next=new int[][]{
            {0,1},{0,-1},{1,0},{-1,0}
    };
    void dfs(char[][]grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0')
            return;
        grid[i][j]='0';

        for (int k = 0; k < next.length; k++) {
            int nextX=i+next[k][0];
            int nextY=j+next[k][1];
            dfs(grid,nextX,nextY);
        }
    }
}
