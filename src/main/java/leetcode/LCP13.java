package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LCP13 {
    public int minimalSteps(String[] maze) {

        //找到各个组件
   List<int[]> OS=new ArrayList<>();
   List<int[]> MS=new ArrayList<>();
    int []start=new int[2];
    int []target=new int[2];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                char c=maze[i].charAt(j);
                if(c=='S'){
                   start[0]=i;
                   start[1]=j;
                }else if(c=='O'){
                  OS.add(new int[]{i,j});
                }else if(c=='M'){
                    MS.add(new int[]{i,j});
                }else if(c=='T'){
                    target[0]=i;
                    target[1]=j;
                }
            } 
        }
     MS.add(start);
     OS.add(target);
        //计算 机关 -> 石头 的最短距离
        int [][] m2o=new int[MS.size()][OS.size()];
        for (int i = 0; i < MS.size(); i++) {
            for (int j = 0; j < OS.size(); j++) {
                m2o[i][j]=dfs(MS.get(i),OS.get(j),maze);
            }
        }


        int[][]m2m=new int[MS.size()][MS.size()];
        //计算 机关 -> 石头 ->机关 的距离
        for (int i = 0; i < MS.size(); i++) {
            for (int j = 0; j < MS.size(); j++) {
                if(i==j)continue;
                m2m[i][j]=Integer.MAX_VALUE;
                for (int k = 0; k < OS.size()-1; k++) { //注意此处不要把taget加上，taget是假的石头
                    if(m2o[i][k]==-1||m2o[j][k]==-1) continue;
                    m2m[i][j]=Math.min(m2m[i][j],m2o[i][k]+m2o[j][k]);
                }   
            }
        }



        //状态压缩 ，机关的状态
      int lim=1<<(MS.size()-1); //  注意里面有个start哦 ，要减去
        Integer [][]dp=new Integer[MS.size()][lim];
        dp[MS.size()-1][0]=0; //从最后一个MS开始是0
        for (int status = 0; status < lim; status++) {
            //本次机关
            for (int i = 0; i < MS.size(); i++) {
                //下次机关
                if(dp[i][status]==null) continue;
                for (int j = 0; j < MS.size()-1; j++) {  //注意这里 ，不能把start加上，这里是假的机关
                   if(i==j||(1&(status>>j))==1||m2m[i][j]==Integer.MAX_VALUE) continue;
                    if(dp[j][status|(1<<j)]==null)  dp[j][status|(1<<j)]=dp[i][status]+m2m[i][j];
                   else  dp[j][status|(1<<j)]=Math.min(dp[j][status|(1<<j)],dp[i][status]+m2m[i][j]);
                }
            }
        }

       int res=Integer.MAX_VALUE;
        for (int i = 0; i < MS.size(); i++) {
           if(dp[i][lim-1]==null) continue;;
           if(m2o[i][OS.size()-1]==-1) continue;
           res=Math.min(dp[i][lim-1]+m2o[i][OS.size()-1],res);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
   static int [][]next=new int[][]{
            {0,1},{0,-1},{-1,0},{1,0}
    };
 static   int dfs(int []from,int[] to,String[]maze){
       Queue<int[]> queue=new LinkedList<>();
       queue.add(from);
       int step=0;

       boolean[][]visited=new boolean[maze.length][maze[0].length()];
     visited[from[0]][from[1]] = true;
       while (!queue.isEmpty()){
          int size=queue.size();
          while (size-->0) {
              int[] index = queue.poll();


              for (int i = 0; i < next.length; i++) {
                  int nextX = index[0] + next[i][0];
                  int nextY = index[1] + next[i][1];

                  if (nextX >= 0 && nextX < maze.length && nextY >= 0 && nextY < maze[0].length() && !visited[nextX][nextY]&&maze[nextX].charAt(nextY)!='#') {
                      queue.add(new int[]{nextX,nextY});
                      visited[nextX][nextY]=true;
                      if(nextX==to[0]&&nextY==to[1]) return step+1;
                  }
              }
          }
         step++;
       }
       return -1;
   }

    public static void main(String[] args) {
        dfs(new int[]{1,0},new int[]{0,2},new String[]{"S#O", "M..", "M.T"});
    }

/*
 *
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int n, m;

    public int minimalSteps(String[] maze) {
        n = maze.length;
        m = maze[0].length();
        // 机关 & 石头
        List<int[]> buttons = new ArrayList<int[]>();
        List<int[]> stones = new ArrayList<int[]>();
        // 起点 & 终点
        int sx = -1, sy = -1, tx = -1, ty = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i].charAt(j) == 'M') {
                    buttons.add(new int[]{i, j});
                }
                if (maze[i].charAt(j) == 'O') {
                    stones.add(new int[]{i, j});
                }
                if (maze[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                }
                if (maze[i].charAt(j) == 'T') {
                    tx = i;
                    ty = j;
                }
            }
        }
        int nb = buttons.size();
        int ns = stones.size();
        int[][] startDist = bfs(sx, sy, maze);

        // 边界情况：没有机关
        if (nb == 0) {
            return startDist[tx][ty];
        }
        // 从某个机关到其他机关 / 起点与终点的最短距离。
        int[][] dist = new int[nb][nb + 2];
        for (int i = 0; i < nb; i++) {
            Arrays.fill(dist[i], -1);
        }
        // 中间结果
        int[][][] dd = new int[nb][][];
        for (int i = 0; i < nb; i++) {
            int[][] d = bfs(buttons.get(i)[0], buttons.get(i)[1], maze);
            dd[i] = d;
            // 从某个点到终点不需要拿石头
            dist[i][nb + 1] = d[tx][ty];
        }

        for (int i = 0; i < nb; i++) {
            int tmp = -1;
            for (int k = 0; k < ns; k++) {
                int midX = stones.get(k)[0], midY = stones.get(k)[1];
                if (dd[i][midX][midY] != -1 && startDist[midX][midY] != -1) {
                    if (tmp == -1 || tmp > dd[i][midX][midY] + startDist[midX][midY]) {
                        tmp = dd[i][midX][midY] + startDist[midX][midY];
                    }
                }
            }
            dist[i][nb] = tmp;
            for (int j = i + 1; j < nb; j++) {
                int mn = -1;
                for (int k = 0; k < ns; k++) {
                    int midX = stones.get(k)[0], midY = stones.get(k)[1];
                    if (dd[i][midX][midY] != -1 && dd[j][midX][midY] != -1) {
                        if (mn == -1 || mn > dd[i][midX][midY] + dd[j][midX][midY]) {
                            mn = dd[i][midX][midY] + dd[j][midX][midY];
                        }
                    }
                }
                dist[i][j] = mn;
                dist[j][i] = mn;
            }
        }

        // 无法达成的情形
        for (int i = 0; i < nb; i++) {
            if (dist[i][nb] == -1 || dist[i][nb + 1] == -1) {
                return -1;
            }
        }

        // dp 数组， -1 代表没有遍历到
        int[][] dp = new int[1 << nb][nb];
        for (int i = 0; i < 1 << nb; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < nb; i++) {
            dp[1 << i][i] = dist[i][nb];
        }

        // 由于更新的状态都比未更新的大，所以直接从小到大遍历即可
        for (int mask = 1; mask < (1 << nb); mask++) {
            for (int i = 0; i < nb; i++) {
                // 当前 dp 是合法的
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < nb; j++) {
                        // j 不在 mask 里
                        if ((mask & (1 << j)) == 0) {
                            int next = mask | (1 << j);
                            if (dp[next][j] == -1 || dp[next][j] > dp[mask][i] + dist[i][j]) {
                                dp[next][j] = dp[mask][i] + dist[i][j];
                            }
                        }
                    }
                }
            }
        }

        int ret = -1;
        int finalMask = (1 << nb) - 1;
        for (int i = 0; i < nb; i++) {
            if (ret == -1 || ret > dp[finalMask][i] + dist[i][nb + 1]) {
                ret = dp[finalMask][i] + dist[i][nb + 1];
            }
        }

        return ret;
    }

    public int[][] bfs(int x, int y, String[] maze) {
        int[][] ret = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ret[i], -1);
        }
        ret[x][y] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int curx = p[0], cury = p[1];
            for (int k = 0; k < 4; k++) {
                int nx = curx + dx[k], ny = cury + dy[k];
                if (inBound(nx, ny) && maze[nx].charAt(ny) != '#' && ret[nx][ny] == -1) {
                    ret[nx][ny] = ret[curx][cury] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return ret;
    }

    public boolean inBound(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
 */
    

}
