package leetcode;

public class leet115 {

    //dfs+memo
 /*   public int numDistinct(String s, String t) {

        memo=new Integer[s.length()+1][t.length()+1];
     return helper(0,0,s,t);
    }


    Integer [][]memo;
    int helper(int x,int y,String s,String t){

        if(y>=t.length()) return 1;

        if(x>=s.length()) return 0;

       if(memo[x][y]!=null) return memo[x][y];
        int res=0;
       if(s.charAt(x)==t.charAt(y)) {
          res+=helper(x+1,y+1,s,t);
       }
      res+=helper(x+1,y,s,t);
      return memo[x][y]=res;
    }*/

    //尝试dp
    public int numDistinct(String s, String t) {
    int[][]dp=new int[t.length()+1][s.length()+1];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i]=1;
        }
        for (int i = 0; i < t.length(); i++) {
            char tt=t.charAt(i);
            for (int j = 0; j < s.length(); j++) {
            char  ss=s.charAt(j);

           if(tt==ss){
               dp[i+1][j+1]=dp[i][j];
           }
           dp[i+1][j+1]+=dp[i+1][j];
            }
        }
      return dp[t.length()][s.length()];
    }


}
