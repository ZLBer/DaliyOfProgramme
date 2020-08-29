package leetcode;

public class leet1559 {


    //mine
     public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    int[] point = new int[]{i, j};
                    if (dfs(point, point,visited , grid, grid[i][j]))
                        return true;
                }
            }
        }
        return false;
    }

     int[][] move = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

     boolean dfs(int[] from, int[] point, boolean[][] visited, char[][] grid, char c) {
        boolean answer = false;
        visited[point[0]][point[1]] = true;
        for (int i = 0; i < move.length; i++) {
            int nextX = point[0] + move[i][0];
            int nextY = point[1] + move[i][1];
            if (nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length) { //点合法
                if(grid[nextX][nextY]!=c) continue;
                if(visited[nextX][nextY]&&((from[0] != nextX || from[1] != nextY))) return true;//下一个点已经访问过并且不是来的那个点，整明形成环
                if(visited[nextX][nextY] ) continue; //访问过的都跳过
                answer |= dfs(point, new int[]{nextX, nextY}, visited, grid, c);
            }
        }
        return answer;
    }

    //并查集又可以起作用咯

    /*class UnionFind {
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

        public boolean connect(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA != rootB) {
                father[rootB] = rootA;
                return false;
            }else {
                return true;
            }
        }
    }

    public boolean containsCycle(char[][] grid) {
         UnionFind uf=new UnionFind(grid.length*grid[0].length);
         int row=grid.length,col=grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char c=grid[i][j];
               if(j+1<col&&grid[i][j+1]==c){  //右边
                   if(uf.connect(i*col+j,i*col+j+1)){
                       return true;
                   }
               }
               if(i+1<row&&grid[i+1][j]==c){
                   if(uf.connect(i*col+j,(i+1)*col+j)){
                       return true;
                   }
               }
            }
        }
        return false;
    }*/
    public static void main(String[] args) {
  /*      containsCycle(new char[][]{
                {'c', 'c', 'c', 'a'}, {'c', 'd', 'c', 'c'}, {'c', 'c', 'e', 'c'}, {'f', 'c', 'c', 'c'}
        });*/
    }
}
