package leetcode;

import java.util.Arrays;

public class leet1594 {


    //周赛写的乱七八糟
    //要学会舍弃啊  你一看写的这么复杂了 还不赶紧删除换种方法？

/*   static public int maxProductPath(int[][] grid) {
        Long[]res= dfs(grid,grid.length-1,grid[0].length-1,0,0);

     if(res[0]==null&&flag==true) return 0;
 return res[0]==null?-1:(int)(res[0]%1000000007);

    }
static boolean  flag=false;
  static   Long []dfs(int [][]grid,int m,int n,int x,int y) {
        if (x == m && y == n) {
            if(grid[x][y]==0) flag=true;
            if (grid[x][y] > 0) {
                return new Long[]{(long) grid[x][y], null};
            } else {
                return new Long[]{null, (long) grid[x][y]};
            }
        }
  if(grid[x][y]==0) flag=true;
        Long[] temp = new Long[]{null,null};
        if (x + 1 <= m) {
            temp = dfs(grid, m, n, x + 1, y);
        }

        if (y + 1 <= n) {
            Long[] t = dfs(grid, m, n, x, y + 1);
            if (t[0] != null && temp[0] != null) {

                temp[0] = Math.max(t[0], temp[0]);
            } else {
                if (t[0] != null) {
                    temp[0] = t[0];
                }
            }
            if (t[1] != null && temp[1] != null) {
                temp[1] = Math.min(t[1], temp[1]);
            } else {
                if (t[1] != null) {
                    temp[1] = t[1];
                }
            }

        }


        if (grid[x][y] >= 0) {
            if (temp[0] != null) {
                temp[0] *= grid[x][y];
            }
            if (temp[1] != null) {
                if(grid[x][y]!=0) {
                    temp[1] *= grid[x][y];
                }else {
                    temp[1]=null;
                   if(temp[0]==null){
                       temp[0]=0L;
                   }
                }
            }

        } else {
            if (temp[0] != null&&temp[1]!=null) {

               long  t1 = temp[0] * grid[x][y];
                long t0 = temp[1] * grid[x][y];
                temp[1]=t1;
                temp[0]=t0;
            }
           else if (temp[0] != null) {
               if(temp[0]==0L) {
                   temp[0]=0L;
                   temp[1]=null;
               }else {
                   temp[1] = temp[0] * grid[x][y];
                   temp[0] = null;
               }
            }
           else if (temp[1] != null) {
                temp[0] = temp[1] * grid[x][y];
                temp[1]=null;
            }

        }
        return temp;
    }

    public static void main(String[] args) {
        maxProductPath(new int[][]{
                {-1,3,0},{3,-2,3},{-1,1,-4}

        });
    }*/


//赛后自己写的  其实想法真不难
int mod=1000000007;
    public int maxProductPath(int[][] grid) {
        long [][]min=new long[grid.length][grid[0].length];
        long [][]max=new long[grid.length][grid[0].length];

        for (long[] ints : min) {
            Arrays.fill(ints,Integer.MAX_VALUE);
        }

        //没必要的操作
        //  for (long[] ints : max) {
        //      Arrays.fill(ints,Integer.MIN_VALUE);
        //  }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(i==0&&j==0){
                    min[0][0]=max[0][0]=grid[0][0];
                }else if(i==0){
                    min[i][j]=Math.min(max[i][j-1]*grid[i][j],min[i][j-1]*grid[i][j]);
                    max[i][j]=Math.max(max[i][j-1]*grid[i][j],min[i][j-1]*grid[i][j]);
                }else  if(j==0){
                    min[i][j]=Math.min(max[i-1][j]*grid[i][j],min[i-1][j]*grid[i][j]);
                    max[i][j]=Math.max(max[i-1][j]*grid[i][j],min[i-1][j]*grid[i][j]);
                }else {
                    min[i][j]=Math.min(max[i-1][j]*grid[i][j],min[i-1][j]*grid[i][j]);
                    min[i][j]=Math.min(min[i][j],max[i][j-1]*grid[i][j]);
                    min[i][j]=Math.min(min[i][j],min[i][j-1]*grid[i][j]);
                    max[i][j]=Math.max(max[i-1][j]*grid[i][j],min[i-1][j]*grid[i][j]);
                    max[i][j]=Math.max(max[i][j],max[i][j-1]*grid[i][j]);
                    max[i][j]=Math.max(max[i][j],min[i][j-1]*grid[i][j]);
                }
                //不能提前求余
                //  min[i][j]%=mod;
                //  max[i][j]%=mod;
                Arrays.deepToString(min);
            }
        }
        return (max[max.length-1][max[0].length-1]<0)?-1:(int)(max[max.length-1][max[0].length-1]%mod);
    }

   //大佬的做法  简洁明了
  /*  public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[][] mindp = new long[n][m];
        long[][] maxdp = new long[n][m];
        long inf = (long) 1e15;
        for (int i = 0; i < n; i++) {
            Arrays.fill(mindp[i], inf);
            Arrays.fill(maxdp[i], -inf);
        }
        mindp[0][0] = maxdp[0][0] = grid[0][0];
        int[][] dirs = new int[][]{
                {1, 0},
                {0, 1}
        };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[] d : dirs) {
                    int x = i + d[0];
                    int y = j + d[1];
                    if (x >= n || y >= m) {
                        continue;
                    }
                    long l = mindp[i][j] * grid[x][y];
                    long r = maxdp[i][j] * grid[x][y];
                    if (grid[x][y] < 0) {
                        long tmp = l;
                        l = r;
                        r = tmp;
                    }
                    mindp[x][y] = Math.min(l, mindp[x][y]);
                    maxdp[x][y] = Math.max(r, maxdp[x][y]);
                }
            }
        }

       // System.out.println(Arrays.deepToString(mindp));
        //System.out.println(Arrays.deepToString(maxdp));

        int mod = (int) (1e9 + 7);
        int ans = maxdp[n - 1][m - 1] < 0 ? -1 : (int) (maxdp[n - 1][m - 1] % mod);
        return ans;
    }*/

    public static void main(String[] args) {

    }
}
