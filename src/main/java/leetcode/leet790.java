package leetcode;

public class leet790 {



    //dfs+memo可以过
/*    public int numTilings(int N) {
      meme=new Integer[N+1][N+1];
return dfs(0,0,N);
    }

   Integer [][]meme;
    int mod=(int)1e9+7;

    int dfs(int one, int two, int N) {
        if (one == two && one == N) return 1;

        if (one >= N || two >= N) return 0;

       if(meme[one][two]!=null) return meme[one][two];
        long val=0;
        if (one == two) {

            val=((long)dfs(one + 1, two + 1, N) + dfs(one + 2, two + 1, N) )%mod
                    + dfs(one + 1, two + 2, N)+dfs(one+2,two+2,N);
        } else {
            if (one > two) {
         val=((long)dfs(one+1,two+2,N)+dfs(one+2,two+3,N))%mod
                 +dfs(one+2,two+2,N);
            } else {
          val=((long)dfs(one+2,two+1,N)+dfs(one+3,two+2,N))%mod
                  +dfs(one+2,two+2,N);
            }
        }
       return meme[one][two]=(int)(val%mod);

    }*/


    public int numTilings(int N) {
        int mod=(int)1e9+7;
      long []dp=new long[]{1,0,0,0};

     while (N-->0){
      long []tdp=new long[]{0,0,0,0};
     tdp[0]=(dp[0]+dp[3])%mod;
     tdp[1]=(dp[0]+dp[2])%mod;
     tdp[2]=(dp[0]+dp[1])%mod;
     tdp[3]=(dp[1]+dp[2]+dp[0])%mod;
     dp=tdp;
     }
    return (int)dp[0];
    }
}
