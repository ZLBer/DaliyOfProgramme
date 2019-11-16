package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leet1254 {
    int [][]next={
            {0,1},{0,-1},{1,0},{-1,0}
    };

    //mine BFS
    public int closedIsland(int[][] grid) {
     boolean[][]visited=new boolean[grid.length][grid[0].length];
  /*   for(int i=0;i<grid.length;i++){
            visited[i][0]=true;
            visited[i][grid[0].length-1]=true;
        }

        for(int i=0;i<grid[0].length;i++){
            visited[0][i]=true;
            visited[grid.length-1][i]=true;
        }*/
          int res=0;
        for (int i = 0; i < grid.length; i++) {
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j]&&grid[i][j]==0){
                    Queue<Integer[]> queue=new LinkedList<>();
                    queue.offer(new Integer[]{i,j});
                    visited[i][j]=true;
                    boolean flag=true;
                    while (!queue.isEmpty()){
                        int size=queue.size();
                        while (size-->0){
                            Integer [] node=queue.poll();
                            if(node[0]==0||node[1]==0||node[0]==grid.length-1||node[1]==grid[0].length-1){
                                flag=false;
                            }
                            for(int n=0;n<next.length;n++){
                                int x=node[0]+next[n][0];
                                int y=node[1]+next[n][1];
                                if(x>=0&&y>=0&&x<grid.length&&y<grid[0].length&&grid[x][y]==0&&!visited[x][y]){
                                    queue.offer(new Integer[]{x,y});
                                    visited[x][y]=true;
                                }
                            }
                        }
                    }
                 if(flag){
                     res++;
                 }

                }
            }
        }

return res;

    }



  //DFS
   /* int fill(int[][] g, int i, int j) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[i].length || g[i][j] != 0)
            return 0;
        return (g[i][j] = 1) + fill(g, i + 1, j) + fill(g, i, j + 1)
                + fill(g, i - 1, j) + fill(g, i, j - 1);
    }
    public int closedIsland(int[][] g) {
        //首先把边界填充成1
        for (int i = 0; i < g.length; ++i)
            for (int j = 0; j < g[i].length; ++j)
                if (i * j * (i - g.length + 1) * (j - g[i].length + 1) == 0)
                    fill(g, i, j);
        int res = 0;
        //计算未填充的数目
        for (int i = 0; i < g.length; ++i)
            for (int j = 0; j < g[i].length; ++j)
                res += fill(g, i, j) > 0 ? 1 : 0;
        return res;
    }
*/


   //并查集  看看就好
 /*   private static final int[] d = {0, 1, 0, -1, 0};
    private int m, n; // numbers of rows and comlumns of grid.
    private int[] id; // parent ids.

    public int closedIsland(int[][] grid) {
        m = grid.length; n = m == 0 ? 0 : grid[0].length;
        id = IntStream.range(0, m * n).toArray(); // Initialized as i * n + j the parent id of cell (i, j).
        for (int i = 1; i < m - 1; ++i) // traverse non-boundary rows.
            for (int j = 1; j < n - 1; ++j) // traverse non-boundary cells within a row.
                if (grid[i][j] == 0) // (i, j) is land.
                    for (int k = 0; k < 4; ++k) { // traverse the neighbors of (i, j).
                        int r = i + d[k], c = j + d[k + 1];
                        if (grid[r][c] == 0) // (r, c) is a land neighbor.
                            union(i * n + j, r * n + c);
                    }
        int cnt = 0; // number of closed islands: number of the non-boundary lands that are ids (parent) of itself.
        for (int i = 1; i < m - 1; ++i) // traverse non-boundary rows.
            for (int j = 1; j < n - 1; ++j) // traverse non-boundary cells within a row.
                if (grid[i][j] == 0 && id[i * n + j] == i * n + j) // Is (i, j) a land as well as the id (parent) of self?
                    ++cnt;
        return cnt;
    }

    private int find(int x) {
        while (x != id[x])
            x = id[x];
        return x;
    }

    private void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY)
            return;
        if (isBoundary(rootY)) {
            id[rootX] = rootY;
        }else {
            id[rootY] = rootX;
        }
    }

    private boolean isBoundary(int id) {
        int i = id / n, j = id % n;
        return i == 0 || j == 0 || i == m - 1 || j == n - 1;
    }*/


/*    void DFS(int[][]grid,boolean [][]visited,int x,int y){


        visited[x][y]=true;

    for(int i=0;i<next.length;i++){
        int tx=x+next[i][0];
        int ty=y+next[i][1];
     if(grid[tx][ty]==1&&tx>=0&&ty>=0&&tx<grid.length&&ty<grid[0].length&&!visited[tx][ty]){
         DFS(grid,visited,)
     }
    }

    }*/
}
