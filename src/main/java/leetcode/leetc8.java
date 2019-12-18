package leetcode;

import java.util.*;

public class leetc8 {



    //mine TLE
/*   static int[][] next = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
  static   public int shortestPath(int[][] grid, int k) {
        all pos = new all(0, 0, k, new HashSet<>());
        Queue<all> queue = new LinkedList<>();
        queue.add(pos);
        int step = -1;
        Set<String> set = new HashSet<>();
        set.add(pos.toString());
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- > 0) {
                all p = queue.poll();
                if (p.x == grid.length-1 && p.y == grid[0].length-1)
                    return step;
                for (int i = 0; i < next.length; i++) {
                    int nextX = p.x + next[i][0];
                    int nextY = p.y + next[i][1];
                    if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length) {
                        all tp = new all();
                        boolean flag=false;
                        if (grid[nextX][nextY] == 1) {
                            //之前消去了这个点
                            if (p.set.contains(nextX + "" + nextY)) {
                                tp = new all(nextX, nextY, p.k, new HashSet<>(p.set));
                                flag=true;
                           //可以消去这个点
                            } else if (p.k > 0) {
                                Set<String> s = new HashSet<>(p.set);
                                s.add(nextX + "" + nextY);
                                tp = new all(nextX, nextY, p.k - 1, s);
                                flag=true;
                            }

                            //没有阻隔物体
                        } else {
                            tp = new all(nextX, nextY, p.k, new HashSet<>(p.set));
                            flag=true;
                        }
                        if (!set.contains(tp.toString())&&flag) {
                            set.add(tp.toString());
                            queue.add(tp);
                        }
                    }
                }
            }
        }
        return -1;
    }


   static class all {
        int x;
        int y;
        int k;
        Set<String> set = new HashSet<>();

        all(int x, int y, int k, Set<String> list) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.set = list;
        }

        all() {

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (String s : set) {
                sb.append(s);
            }
            return x + "" + y + "" + k + sb.toString();
        }
    }*/





    //用矩阵来记录访问点
    //好像没必要担心消除重复的石头，要是早了解了这一点就好做了
/*    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList();
        //访问矩阵
        boolean[][][] visited = new boolean[n][m][k+1];
        visited[0][0][0] = true;
        q.offer(new int[]{0,0,0});
        int res = 0;
        //BFS
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] info = q.poll();
                int r = info[0], c = info[1], curK = info[2];
                if(r==n-1 && c==m-1){
                    return res;
                }
                //四个方向
                for(int[] dir : dirs){
                    int nextR = dir[0] + r;
                    int nextC = dir[1] + c;
                    int nextK = curK;
                    if(nextR>=0 && nextR<n && nextC>=0 && nextC<m){
                        if(grid[nextR][nextC]==1){
                            nextK++;
                        }
                        //此状态没被访问过
                        if(nextK<=k && !visited[nextR][nextC][nextK]){
                            visited[nextR][nextC][nextK] = true;
                            q.offer(new int[]{nextR, nextC, nextK});
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }*/


    //更快的方法
    //和上面一样，只是用一个二维矩阵代替三维的  存的是最小消灭石头数目
      public int shortestPath(int[][] grid, int k) {
        int step = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] seen = new int[m][n]; // min obstacles elimination from (0,0) to (x, y)
        for (int i = 0; i < m; i++) {
            Arrays.fill(seen[i], Integer.MAX_VALUE);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        seen[0][0] = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return step;
                }
                //方向遍历
                for (int[] dir : DIRS) {
                    int x = dir[0] + cur[0];
                    int y = dir[1] + cur[1];
                    //越界判断
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    //计算消去石头的数目
                    int o = grid[x][y] + cur[2];
                    if (o >= seen[x][y] || o > k) {
                        continue;
                    }
                    seen[x][y] = o;
                    q.offer(new int[]{x, y, o});
                }
            }
            ++step;
        }
        return -1;
    }



    public static void main(String[] args) {
      Map<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        map.keySet();
  ThreadLocal<Integer> set=new ThreadLocal<>();
  set.set(1);
      //  shortestPath(new int[][]{{0,1,1},{1,1,1},{1,0,0}},1);
    }
}
