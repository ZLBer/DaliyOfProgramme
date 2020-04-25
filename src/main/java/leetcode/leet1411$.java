package leetcode;

public class leet1411$ {
    public int numOfWays(int n) {
      long ABA=6;
      long ABC=6;
      int mod=1000000007;
      n--;
      while (n-->0){
      long newABA=ABA*3+ABC*2;
      long newABC=ABA*2+ABC*2;
      ABA=newABA%mod;
      ABC=newABC%mod;
      }
      return (int)(ABC+ABA)%mod;
    }

    //自己写一下dp
/*    public int numOfWays(int n) {
    int [][][][]dp=new int[n+1][4][4][4];
 return dfs(dp,0,0,0,n);
    }

    int []colors=new int[]{1,2,3};
    int mod=1000000007;
    int dfs(int [][][][]dp,int a0,int b0,int c0,int n){
     if(n==0) return 1;

     if(dp[n][a0][b0][c0]!=0) return dp[n][a0][b0][c0];

     long ans=0;
     for(int a:colors){
         if(a==a0) continue; //比较上一个
         for(int b:colors){
             if(b==b0||a==b) continue;
             for(int c:colors){
                 if(c==c0||c==b) continue;
                ans+=dfs(dp,a,b,c,n-1);
                ans%=mod;
             }
         }
     }
    return dp[n][a0][b0][c0]=(int)ans;
    }*/
}
