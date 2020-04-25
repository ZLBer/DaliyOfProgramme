package leetcode;

public class leet552 {

    //mine 超级繁琐
 /*static    public int checkRecord(int n) {
    node []dp=new node[3];
 int mod=1000000007;
    if(n==1) return 3;
    if(n==2) return 8;
    dp[0]=new node(3,2,1,0,0);
    dp[1]=new node(2,0,2,0,0);
    dp[2]=new node(3,2,1,1,0);

        for (int i = 3; i <= n; i++) {
           node nextP=new node(dp[0].all+dp[1].all+dp[2].all,dp[0].noA+dp[2].noA,dp[0].containsA+dp[1].containsA+dp[2].containsA,0,0);//以p结尾
            node nextA=new node(dp[0].noA+dp[2].noA,0,dp[0].noA+dp[2].noA,0,0);
            node nextL=new node(dp[0].all+dp[1].all+dp[2].all-dp[2].LLandContainsA-dp[2].LLandNoA+mod,dp[0].noA+dp[2].noA-dp[2].LLandNoA+mod,dp[0].containsA+dp[1].containsA+dp[2].containsA-dp[2].LLandContainsA,dp[2].noA-dp[2].LLandNoA+mod,dp[2].containsA-dp[2].LLandContainsA+mod);
        dp[0]=nextP;dp[1]=nextA;dp[2]=nextL;
        }
        return (int)(((dp[0].all+dp[1].all)%mod+dp[2].all)%mod);
    }

   static class node{
        long all;
        long noA;
        long containsA;
        long LLandNoA;
        long LLandContainsA;
          int mod=1000000007;
        public node(long all, long noA, long containsA, long LLandNoA, long LLandContainsA) {
            this.all = all%mod;
            this.noA = noA%mod;
            this.containsA = containsA%mod;
            this.LLandNoA = LLandNoA%mod;
            this.LLandContainsA = LLandContainsA%mod;
        }
    }
*/

//mine 试图化简
/*    static    public int checkRecord(int n) {
        node []dp=new node[3];
        int mod=1000000007;
        if(n==1) return 3;
        if(n==2) return 8;
        dp[0]=new node(3,2,1,0,0);
        dp[1]=new node(2,0,2,0,0);
        dp[2]=new node(3,2,1,1,0);

        for (int i = 3; i <= n; i++) {
            node nextP=new node(0,dp[0].noA+dp[2].noA,dp[0].containsA+dp[1].containsA+dp[2].containsA,0,0);//以p结尾
            node nextA=new node(0,0,dp[0].noA+dp[2].noA,0,0);
            node nextL=new node(0,dp[0].noA+dp[2].noA-dp[2].LLandNoA+mod,dp[0].containsA+dp[1].containsA+dp[2].containsA-dp[2].LLandContainsA+mod,dp[2].noA-dp[2].LLandNoA+mod,dp[2].containsA-dp[2].LLandContainsA+mod);
            dp[0]=nextP;dp[1]=nextA;dp[2]=nextL;
        }
        return (int)(((dp[0].containsA+dp[0].noA)%mod+(dp[1].containsA+dp[1].noA)%mod+(dp[2].noA+dp[2].containsA)%mod)%mod);
    }

    static class node{
        long all;
        long noA;
        long containsA;
        long LLandNoA;
        long LLandContainsA;
        int mod=1000000007;
        public node(long all, long noA, long containsA, long LLandNoA, long LLandContainsA) {
            this.all = all%mod;
            this.noA = noA%mod;
            this.containsA = containsA%mod;
            this.LLandNoA = LLandNoA%mod;
            this.LLandContainsA = LLandContainsA%mod;
        }
    }*/


    // 可以简化
    /*
     *
a 不含A的LL结尾;
b 不含A的L结尾, 且倒数第二位不为L;
c 不含A的非L结尾;
d 含A的LL结尾;
e 含A的L结尾，且倒数第二位不为L;
f 含A的非L结尾;
     */
    public int checkRecord(int n) {
      long a=0,b=1,c=1,d=0,e=0,f=1;
      for(int i=1;i<=n;i++){
          long ta=b;
          long tb=c;
          long tc=(a+b+c)%1000000007;
          long td=e;
          long te=f;
          long tf=(d+e+f+tc)%1000000009;
          a=ta;b=tb;c=tc;d=td;e=te;f=tf;
      }
      return (int)f;
    }

   /* public static void main(String[] args) {
        checkRecord(4);
    }*/
}
