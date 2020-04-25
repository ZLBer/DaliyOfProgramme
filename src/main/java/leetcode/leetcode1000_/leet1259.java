package leetcode.leetcode1000_;

public class leet1259 {
    //dp  本质上也是卡特兰
    public int numberOfWays(int num_people) {
     long []dp=new long[num_people/2+1];
     long mod=(long)1e9+7;
     dp[0]=1;
     for(int i=1;i<dp.length;i++){
         for(int j=0;j<i;j++){
             dp[i]=(dp[i]+dp[j]*dp[i-j-1])%mod;
         }
     }
     return (int )dp[dp.length-1];
    }

    //卡特兰数
   /* public int numberOfWays(int n) {
        long[] inv = new long[n / 2 + 2];
        inv[1] = 1;
        long mod = (long)1e9 + 7, res = 1;
        for (int i = 2; i < n / 2 + 2; ++i) {
            inv[i] = mod - mod / i * inv[(int)mod % i] % mod;
        }
        for (int i = 1; i <= n / 2; ++i) {
            res = res * (i + n / 2) % mod;
            res = res * inv[i] % mod;
        }
        return (int)(res * inv[n / 2 + 1] % mod);
    }*/
}
