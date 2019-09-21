package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/4/19.
 */


public class leet935 {


  //mine Time Limit Exceeded
   /*   int res = 0;

    public int knightDialer(int N) {
        int[][] dirs = new int[][]{
                {-1, -2},
                {-2, -1},
                {-2, 1},
                {-1, 2},
                {1, -2},
                {2, -1},
                {2, 1},
                {1, 2}
        };
        boolean[][] board = new boolean[4][3];
        board[3][0] = true;
        board[3][2] = true;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                dfs(i, j, dirs, N - 1, board);

            }
        }

        return res;
    }

    void dfs(int i, int j, int[][] dirs, int remind, boolean[][] board) {
        if (i < 0 || j < 0 || i >= 4 || j >= 3 || board[i][j]) {
            return;
        }
        if (remind == 0) {
            res++;
            return;
        }
        for (int[] dir : dirs) {
            dfs(i + dir[0], j + dir[1], dirs, remind - 1, board);
        }
    }*/


    public static final int MOD = 1000000007;
    public int knightDialer(int N) {
        int[][] graph = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        int cnt = 0;
        //用来记录该位置跳N次的情况
        Integer[][] memo = new Integer[N+1][10];
        for (int i = 0; i <= 9; i++)
            cnt = (cnt + helper(N-1, i, graph, memo)) % MOD;
        return cnt;
    }
    private int helper(int N, int cur, int[][] graph, Integer[][] memo) {
        //不能再进行任何跳跃
        if (N == 0)
            return 1;
        //如果之前有记录
        if (memo[N][cur] != null)
            return memo[N][cur];
        int cnt = 0;
        //递归搜索 从graph找出可以跳转的位置
        for (int nei : graph[cur])
            cnt = (cnt + helper(N-1, nei, graph, memo)) % MOD;
        memo[N][cur] = cnt;
        return cnt;
    }
}
