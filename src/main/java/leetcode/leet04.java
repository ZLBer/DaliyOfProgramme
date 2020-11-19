package leetcode;

public class leet04 {

    int getMaxGridHappiness(int m, int n, int a, int b) {
        // 0- 不放人 1-放内向 2-放外向 3^n
        int cases = (int)Math.pow(3, n);
        int cases_1 = (int)Math.pow(3, n-1);
        int offset[][] =new int[][]{{0, 0, 0},{ 0, -60, -10},{0, -10, 40}};

        int M = cases - 1;
        int dp[][][][]=new int[m*n + 1][a+1][b+1][cases];

        for(int coor = m*n-1; coor >= 0; --coor) {
            int i = coor / n, j = coor % n;
            for(int x = 0; x <= a; ++x) {
                for(int y = 0; y <= b; ++y) {
                    for(int pre = 0; pre < cases; ++pre) { // pre 就是前 n 个格子的状态（三进制）

                        //状态转移成此处的状态
                        int nem = (pre * 3) % cases; // nem 是 pre “左移” 一位, 并去掉首位的状态,比如三进制 2121->三进制 1210.

                      //内向人
                       if(x > 0) {
                           //pre % 3是左边    pre / cases_1是上面
                            int diff = 120 + (j!=0?1:0)*offset[1][pre % 3] + offset[1][pre / cases_1];
                            dp[coor][x][y][pre] = Math.max(dp[coor][x][y][pre], diff + dp[coor + 1][x-1][y][nem + 1]);
                        }

                        //外向人
                        if(y > 0) {
                            int diff = 40 + (j!=0?1:0)*offset[2][pre % 3] + offset[2][pre / cases_1];
                            dp[coor][x][y][pre] = Math.max(dp[coor][x][y][pre], diff + dp[coor + 1][x][y-1][nem + 2]);
                        }

                        //什么都不放
                        dp[coor][x][y][pre] = Math.max(dp[coor][x][y][pre], dp[coor + 1][x][y][nem]);
                    }
                }
            }
        }
        return dp[0][a][b][0];
    }
}
