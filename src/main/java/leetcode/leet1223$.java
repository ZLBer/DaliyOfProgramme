package leetcode;

public class leet1223$ {
/*        final private int MOD = 1000000007;
        //三维DP
        public int dieSimulator(int n, int[] rollMax) {
            //第一维记录掷的次数  第二个是次数的统计  第二个是哪个数组
            int[][][] memo = new int[n+1][16][6];  // state is [remaining_rolls][consecutive_rolls][number]
            int res = 0;
            for (int i = 0; i < 6; i++) {
                res = (res + dfs(n-1, 1, i, rollMax, memo)) % MOD;
            }
            return res;
        }

        private int dfs(int n, int count, int num, int[] rollMax, int[][][] memo) {
            if (n == 0)
                return 1;
            //以前搜索过
            if (memo[n][count][num] > 0)
                return memo[n][count][num];
            int ans = 0;
            for (int i = 0; i < 6; i++) {
                if (i != num) {
                    //投掷n-1次的情况
                    ans = (ans + dfs(n-1, 1, i, rollMax, memo)) % MOD;
                } else if (count < rollMax[i]) {
                    //投掷n-1次的情况
                    ans = (ans + dfs(n-1, count+1, i, rollMax, memo)) % MOD;
                }
            }
            memo[n][count][num] = ans;
            return ans;
        }*/



/*    final private int MOD = 1000000007;
    //三维DP
    public int dieSimulator(int n, int[] rollMax) {
        //第一维记录掷的次数  第二个是次数的统计  第二个是哪个数组
        int[][][] memo = new int[n+1][16][6];  // state is [remaining_rolls][consecutive_rolls][number]

        //传0第一次只会匹配不同的
         return dfs(n, 0, 0, rollMax, memo) % MOD;
    }

    private int dfs(int n, int count, int num, int[] rollMax, int[][][] memo) {
        if (n == 0)
            return 1;
        //以前搜索过
        if (memo[n][count][num] > 0)
            return memo[n][count][num];
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            if (i != num) {
                //投掷n-1次的情况
                ans = (ans + dfs(n-1, 1, i, rollMax, memo)) % MOD;
            } else if (count < rollMax[i]) {
                //投掷n-1次的情况
                ans = (ans + dfs(n-1, count+1, i, rollMax, memo)) % MOD;
            }
        }
        memo[n][count][num] = ans;
        return ans;
    }*/



    public int dieSimulator(int n, int[] rollMax) {
        int mod = (int)1e9 + 7;
        //dp[i][j] represents the number of distinct sequences that can be obtained when rolling i times and ending with j
        //The one more row represents the total sequences when rolling i times
        int[][] dp = new int[n + 1][7];
        //init for the first roll
        for (int i = 0; i < 6; i++) {
            dp[1][i] = 1;
        }
        dp[1][6] = 6;
        for (int i = 2; i <= n; i++) {
            int total = 0;
            for (int j = 0; j < 6; j++) {
                //If there are no constraints, the total sequences ending with j should be the total sequences from preious rolling
                //如果没有越界
                dp[i][j] = dp[i - 1][6];
                //For xx1, only 111 is not allowed, so we only need to remove 1 sequence from previous sum
                //就是说刚超出的情况
                if (i - rollMax[j] == 1) {
                    dp[i][j]--;
                }
                //For axx1, we need to remove the number of a11 (211 + 311 + 411 + 511 + 611) => (..2 + ..3 + ..4 + ..5 + ..6) => (sum - ..1)
               //已经越界许多的情况
                if (i - rollMax[j] >= 2) {
                    //需要减去a不是1的情况，什么意思呢？最多有两个1
                    //  例如最多选两个1，但这个位置我们仍要选择1,aXX1 ,所以需要减去所有a11的情况，但是111是不可能的，所以需要排除
                    /*   * * * * * *
                         1 2 3 4 5 6
                         1 1 1 1 1 1
                         1 1 1 1 1 1
           当前行需要选1：1
           所以需要排除前两行连续的 1,但111不存在
                      * */
                    int reduciton = dp[i - rollMax[j] - 1][6] - dp[i - rollMax[j] - 1][j];
                    //must add one more mod because subtraction may introduce negative numbers
                    dp[i][j] = ((dp[i][j] - reduciton) % mod + mod) % mod;
                }
                //求这一趟的和
                total = (total + dp[i][j]) % mod;
            }
            dp[i][6] = total;
        }
        return dp[n][6];
    }

}
