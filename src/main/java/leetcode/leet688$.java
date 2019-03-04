package leetcode;

/**
 * Created by libin on 2019/3/2.
 */
public class leet688$ {

    //mine  dfs time limited
  /*  int[][] nextIncrese = {
            {-1, -2},
            {-2, -1},
            {-2, 1},
            {-1, 2},
            {1, -2},
            {2, -1},
            {1, 2},
            {2, 1}
    };
    int N = 0;
    int K = 0;
    int count = 0;
    int canSurvive = 0;

    public static void main(String[] args) {

        leet688 le = new leet688();
        le.knightProbability(8,30,6,4);
        System.out.println(le.canSurvive);
    }

    public double knightProbability(int N, int K, int r, int c) {
        if(K==0) return 1;
        this.N = N;
        this.K = K;
        dfs(r, c);
        return canSurvive / Math.pow(8, K);
    }

    void dfs(int x, int y) {
        for (int i = 0; i < nextIncrese.length; i++) {
            int tx = x + nextIncrese[i][0];
            int ty = y + nextIncrese[i][1];
           System.out.println(tx + "     " + ty);
            if (tx >= 0 && tx < N && ty >= 0 && ty < N) {
                count++;
                System.out.println(count);
                if (count == K) {
                    canSurvive++;
                    count--;
                    continue;
                }
                dfs(tx, ty);
                count--;
            }

        }

    }*/


    //  DP
    //big  nice solution
 static    public double knightProbability(int N, int K, int sr, int sc) {
        double[][] dp = new double[N][N];
        int[] dr = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] dc = new int[]{1, -1, 2, -2, 2, -2, 1, -1};

        dp[sr][sc] = 1;
        for (; K > 0; K--) {
            double[][] dp2 = new double[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    for (int k = 0; k < 8; k++) {
                        int cr = r + dr[k];
                        int cc = c + dc[k];
                        if (0 <= cr && cr < N && 0 <= cc && cc < N) {
                            dp2[cr][cc] += dp[r][c] / 8.0;
                        }
                    }
                }
            }
            dp = dp2;
        }
        double ans = 0.0;
        for (double[] row: dp) {
            for (double x: row) ans += x;
        }
        return ans;
    }

    public static void main(String[] args) {
        knightProbability(3,1,0,0);
    }
}
