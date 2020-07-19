package leetcode;

public class leet920$ {
    public int numMusicPlaylists(int N, int L, int K) {
        long [][]dp=new long[L+1][N+1];
        dp[0][0]=1;
        int mod=1000_000_007;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j]+=dp[i-1][j-1]*(N-j+1);
                dp[i][j]+=dp[i-1][j]*Math.max(0,j-K);
                dp[i][j]%=mod;
            }
        }
        return (int)dp[L][N];
    }
}
