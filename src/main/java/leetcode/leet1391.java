package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leet1391 {
    public boolean hasValidPath(int[][] grid) {
        boolean [][]visited=new boolean[grid.length][grid[0].length];
   return      dfs(grid,visited,0,0,0);
    }

    //1表示从上方来  2表示从右方来  3表示从下方来  4表示从左方来

    int [][] next=new int[][]{
            {0,1,0,-1},{1,0,-1,0},{0,-1,1,0},{1,0,0,1},{0,-1,-1,0},{-1,0,0,1}
    };
    int [][] direction=new int[][]{
            {4,2},{1,3},{2,1},{1,4},{2,3},{3,4}
    };
    boolean dfs(int[][]grid,boolean[][]visited,int fromDirection,int x,int y){
       int here=grid[x][y];
       if(!checkCanArrivedHere(fromDirection,here)) return false;
       if(x==grid.length-1&&y==grid[0].length-1) return true;
       visited[x][y]=true;
       boolean flag=false;
       for (int i = 0; i < next[here-1].length; i++) {
           int toX=x+next[here-1][i];
           int toY=y+next[here-1][++i];
           int dir=direction[here-1][(i+1)/2];
           if(toX>=0&&toY>=0&&toX<grid.length&&toY<grid[0].length&&!visited[toX][toY]){
               flag=dfs(grid,visited,dir,toX,toY);
               if(flag) return true;
           }
        }
        return flag;
    }

    boolean checkCanArrivedHere(int fromDirection,int here){
        switch (fromDirection){
            case 0:return true;
            case 1:{
                if(here==2||here==6||here==5) return true;
                else return false;
            }
            case 2:{
                if(here==1||here==4||here==6)return true;
                else return false;
            }
            case 3:{
                if(here==2||here==3||here==4)return true;
                else return false;
            }
            default:{
                if(here==1||here==3||here==5) return true;
                else return false;
            }
        }
    }





    //比自己的做法要简单
    //判断下一个点是 用下一个点反过来判断能不能到达这个点
  /*  int[][][] dirs = {
            {{0, -1}, {0, 1}},
            {{-1, 0}, {1, 0}},
            {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}},
            {{0, -1}, {-1, 0}},
            {{0, 1}, {-1, 0}}
    };
    //the idea is you need to check port direction match, you can go to next cell and check whether you can come back.
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            int num = grid[x][y] - 1;
            for (int[] dir : dirs[num]) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) continue;
                //go to the next cell and come back to orign to see if port directions are same
                for (int[] backDir : dirs[grid[nx][ny] - 1])
                    if (nx + backDir[0] == x && ny + backDir[1] == y) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
            }
        }
        return visited[m - 1][n - 1];
    }*/

  //并查集解决联通问题
/*  int[] id;
    int[] sz;
    public boolean hasValidPath(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return false;
        }
        int m = grid.length;
        int n = grid[0].length;
        id = new int[m * n];
        sz = new int[m * n];
        for (int i = 0; i < m * n; i++){
            id[i] = i;
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1 || grid[i][j] == 6){
                    if (j != n - 1 && (grid[i][j + 1] == 3 || grid[i][j + 1] == 5 || grid[i][j + 1] == 1)){
                        unite(i * n + j, i * n + j + 1);
                    }
                } else if (grid[i][j] == 2 || grid[i][j] == 3){
                    if (i != m - 1 && (grid[i + 1][j] == 5 || grid[i + 1][j] == 6 || grid[i + 1][j] == 2)){
                        unite(i * n + j, (i + 1) * n + j);
                    }
                } else if (grid[i][j] == 4){
                    if (j != n - 1 && (grid[i][j + 1] == 3 || grid[i][j + 1] == 5 || grid[i][j + 1] == 1)){
                        unite(i * n + j, i * n + j + 1);
                    }
                    if (i != m - 1 && (grid[i + 1][j] == 5 || grid[i + 1][j] == 6 || grid[i + 1][j] == 2)){
                        unite(i * n + j, (i + 1) * n + j);
                    }
                } else {
                    if (j != 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6)){
                        unite(i * n + j, i * n + j - 1);
                    }
                    if (i != 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4)){
                        unite(i * n + j, (i - 1) * n + j);
                    }
                }
            }
        }

        return find(0, m * n - 1);
    }

    public boolean find(int p, int q) {
        return root(p) == root(q);
    }

    public int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public void unite(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }*/
  class UnionFind {
      int[] father;
      public UnionFind(int n) {
          father = new int[n];
          for (int i = 0; i < n; i++) {
              father[i] = i;
          }
      }

      public int find(int x) {
          if (father[x] == x) {
              return x;
          }
          return father[x] = find(father[x]);
      }

      public void connect(int a, int b) {
          int rootA = find(a);
          int rootB = find(b);

          if (rootA != rootB) {
              father[rootB] = rootA;
          }
      }
  }


  //把点都成二 相当于把一个正方形十字切割，形成田字  原来的点在中心位置 （零点除外）
    //依次判断中心点和上下左右是否联通
    class Solution {
        public boolean hasValidPath(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            UnionFind uf = new UnionFind(2 * m * 2 * n);
            //可以连通上边的
            Set<Integer> top = new HashSet<>(Arrays.asList(2, 5, 6));
            //可以连通性下边的
            Set<Integer> right = new HashSet<>(Arrays.asList(1, 4, 6));
            Set<Integer> bottom = new HashSet<>(Arrays.asList(2, 3, 4));
            Set<Integer> left = new HashSet<>(Arrays.asList(1, 3, 5));

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int current = grid[i][j];
                    int currentId = id(2 * i, 2 * j, m);
                    System.out.println("currentId "+currentId);
                    int next = 0; // just for initialize
                    //是否可以链接top
                    if (top.contains(current)) {
                        next = id(2 * i - 1, 2 * j, m);
                        //判断top点合不合法
                        if (next >= 0) {
                            uf.connect(currentId, next);
                        }
                    }

                    if (right.contains(current)) {
                        next = id(2 * i, 2 * j + 1, m);
                        if (next >= 0) {
                            uf.connect(currentId, next);
                        }
                    }

                    if (bottom.contains(current)) {
                        next = id(2 * i + 1, 2 * j, m);
                        if (next >= 0) {
                            uf.connect(currentId, next);
                        }
                    }

                    if (left.contains(current)) {
                        next = id(2 * i, 2 * j - 1, m);
                        if (next >= 0) {
                            uf.connect(currentId, next);
                        }
                    }
                }
            }
            int fatherOri = uf.find(0);
            int fatherEnd = uf.find(id((n - 1) * 2, (m - 1) * 2, m));
            return fatherOri == fatherEnd;
        }

        //坐标转换  乘2的意思是需要跳过一行
        public int id(int x, int y, int m) {
            return  (2*m)*x  + y;
        }
    }
}
