package leetcode;

public class leet1575 {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {

        memo=new Integer[locations.length][fuel+1];

        return dfs(start,fuel,finish,locations);
    }
    int mod=1000000007;
    Integer [][]memo;
    int dfs(int start,int fuel,int finish,int []locations){
      if(fuel<0) return 0;
    if(memo[start][fuel]!=null) return memo[start][fuel];
      long res=0;
     if(start==finish) res++;
        for (int i = 0; i < locations.length; i++) {
           if(i==start) continue;
           res+= dfs(i,fuel-Math.abs(locations[start]-locations[i]),finish,locations);
           res%=mod;
        }
    return memo[start][fuel]=(int)res;
    }

    //直接dp
   /* public int countRoutes(int[] locations, int start, int finish, int fuel) {
        long[][] dp = new long[locations.length][fuel+1];
        long MOD = (long)(1e9 + 7);
        Arrays.fill(dp[finish],1);
        long ans = 0;
        for(int j = 0; j <= fuel; j++) {
            for(int i = 0; i < locations.length; i++) {
                for(int k = 0; k < locations.length; k++) {
                    if(k == i) continue; //不能是同一个点
                    if(Math.abs(locations[i] - locations[k]) <= j) { //保证fuel够用

                        //更新从k点到i点
                        dp[i][j] = (dp[i][j] + dp[k][j - Math.abs(locations[i] - locations[k])]) % MOD;
                    }
                }
            }
        }
        return (int)dp[start][fuel];
    }*/
}
