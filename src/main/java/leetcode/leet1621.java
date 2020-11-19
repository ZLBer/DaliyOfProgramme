package leetcode;

public class leet1621 {

    //mine 这样的dp居然超时了？？？
/*    public int numberOfSets(int n, int k) {
        long [][]dp=new long[k+1][n];
        int mod=(int)1e9+7;
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i]=1;
        }

        for(int i=1;i<=k;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i][j-1];
                for(int len=1;len<=j;len++){
                    dp[i][j]+=dp[i-1][j-len];
                    dp[i][j]%=mod;

                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return (int)dp[k][n-1];
    }*/

    //mine  提前把前n项和算好就ok了
    //大概思路就是 dp[i][j]表示i段线段，截至到j位置能表示的情况
    public int numberOfSets(int n, int k) {
        long [][]dp=new long[k+1][n];
        long []sum=new long[n];
        int mod=(int)1e9+7;
        sum[0]=1;
        for (int i = 1; i < dp[0].length; i++) {
            sum[i]=sum[i-1]+1;
        }

        for(int i=1;i<=k;i++){
            long []nsum=new long[n];
            for(int j=1;j<n;j++){
                dp[i][j]=(dp[i][j-1]+sum[j-1])%mod;
                nsum[j]=(nsum[j-1]+dp[i][j])%mod;
            }
            sum=nsum;
        }
        return (int)dp[k][n-1];
    }

   //这个memo 好棒啊  记录这个点占用/不占用的
/*      Integer[][][] memo;
    int n;
    public int numberOfSets(int n, int k) {
        this.n = n;
        this.memo = new Integer[n+1][k+1][2];
        return dp(0, k, 1);
    }
    int dp(int i, int k, int isStart) {
        if (memo[i][k][isStart] != null) return memo[i][k][isStart];
        if (k == 0) return 1; // Found a way to draw k valid segments
        if (i == n) return 0; // Reach end of points

        int ans = dp(i+1, k, isStart); // Skip ith point
        if (isStart == 1)
            ans += dp(i+1, k, 0); // Take ith point as start
        else
            ans += dp(i, k-1, 1); // Take ith point as end

        return memo[i][k][isStart] = ans % 1_000_000_007;
    }*/



//和上面是不一样的  这个比上面的麻烦  是在线段一开始减去k  上面的是在线段末尾减去k，更好一点
 /* static   Integer[][][] memo;
   static int n;
   static public int numberOfSets(int a, int k) {
       n = a;
       memo = new Integer[n+1][k+1][2];
        return helper(0, k, 0);
    }

    static  int helper(int i,int k,int isStart){
        if (memo[i][k][isStart] != null) return memo[i][k][isStart];
        if (k == 0) return n-i; // Found a way to draw k valid segments
        if (i == n-1) return 0; // Reach end of points

        //不做任何动作，保持之前的状态
       long ans=helper(i+1,k,isStart);

       if(isStart==1){
          ans+=helper(i,k,0);
       }else {
          ans+=helper(i+1,k-1,1);
       }
     ans%=(int)1e9+7;
     return memo[i][k][isStart]=(int)ans;
    }

    public static void main(String[] args) {
        numberOfSets(4,2);
    }*/


  //人家的dp妙啊  但也不快哈哈哈
/*    public int numberOfSets(int n, int k) {
        long [][][]dp=new long[k+1][n+1][2];
        dp[0][0][0]=1;
        int mod = (int) 1e9+7;
        for (int i = 0; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j][0]=(dp[i][j-1][0]+dp[i][j-1][1])%mod;
                dp[i][j][1]=dp[i][j-1][1];
                if(i>0){
                    dp[i][j][1]=(dp[i][j][1]+dp[i-1][j-1][1]+dp[i-1][j-1][0])%mod;
                }
            }
        }
        return (int)(dp[k][n-1][0]+dp[k][n-1][1])%mod;
    }*/
}
