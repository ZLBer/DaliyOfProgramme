package leetcode.leetcode1000_1499;

public class leet1420$ {
    //直接dfs
    //发现套路还是老套路  就是题目复杂了看不出改用什么方法了
/*    public int numOfArrays(int n, int m, int k) {
        return dfs(n,m,k,0,0,0,new Integer[n+1][m+1][k+1]);
    }

    int dfs(int n,int m,int k,int i,int curMax,int curCost,Integer [][][]dp){
        if(i==n){
            if(k==curCost) return 1;
            return 0;
        }

        if(dp[i][curMax][curCost]!=null) return dp[i][curMax][curCost];
        int ans=0;
        for(int num=1;num<=m;num++){
            int newCost=curCost;
            int newMax=curMax;
            if(num>curMax){
                newCost++;
                newMax=num;
            }
            if(newCost>k) break;
            ans+=dfs(n,m,k,i+1,newMax,newCost,dp);
            ans%=1000000007;
        }
        return dp[i][curMax][curCost]=ans;
    }*/


// 一种优化
    public int numOfArrays(int n, int m, int k) {
        return dfs(n,m,k,0,0,0,new Integer[n+1][m+1][k+1]);
    }

    int dfs(int n,int m,int k,int i,int curMax,int curCost,Integer [][][]dp){
        if(i==n){
            if(k==curCost) return 1;
            return 0;
        }

        if(dp[i][curMax][curCost]!=null) return dp[i][curMax][curCost];
        int ans=0;

        ans+=(long)curMax*dfs(n,m,k,i+1,curMax,curCost,dp)%1000000007;

        if (curCost + 1 <= k) {
            for (int num = curMax + 1; num <= m; num++) {
                ans += dfs(n, m, k, i + 1, num, curCost + 1, dp);
                ans %= 1000000007;
            }
        }
        return dp[i][curMax][curCost]=ans;


    }

    public static void main(String[] args) {
    }

}
