package leetcode._5_30Days;

public class coin_lcci {
    int [] coins=new int[]{25,10,5,1};
    int mod=1000000007;
    int [][]dp;
    public int waysToChange(int n) {
        dp=new int[n+1][4];
return helper(n,0);
    }

    int helper(int n,int index){
        if(n==0) return 1;
        if(dp[n][index]!=0) return dp[n][index];
        long count=0;
        for (int i = index; i < coins.length; i++) {
            if(n-coins[i]>=0) count+=helper(n-coins[i],i);
        }

        count%=mod;
        dp[n][index]=(int)count;
        return (int)count;
    }
}
