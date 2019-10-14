package leetcode;

public class leetc3 {
    public int dieSimulator(int n, int[] rollMax) {
       int mod=1000000007;

        long [][]dp=new long[6][n];
        for(int i=0;i<6;i++){
            if(rollMax[i]>0) {
                dp[i][0]=1;
                rollMax[i]--;
            }
        }
        for (int i=1;i<n;i++){
            for (int j = 0; j < rollMax.length; j++) {
                if(rollMax[j]>0) {
                    dp[j][i]=(dp[j][i-1]*6)%mod;
                    rollMax[j]--;
                }
                else {
                    dp[j][i]=(dp[j][i-1]*5)%mod;
                }
            }
        }
        long result=0;
       for(int i=0;i<6;i++){
           result=(result+dp[i][n-1])%mod;
       }
       return (int)result;
    }
}
