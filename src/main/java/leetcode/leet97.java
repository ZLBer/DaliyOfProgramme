package leetcode;

public class leet97 {

    //直接法  倒是也能过
/*    public boolean isInterleave(String s1, String s2, String s3) {
  return dfs(s1,s2,s3,0,0,0);
    }

    boolean dfs(String s1,String s2,String  s3,int i,int j,int k){
       if(k==s3.length()){
           if(i==s1.length()&&j==s2.length()) return true;
           else return false;
       }

       boolean res=false;
      if(i<s1.length()&&s1.charAt(i)==s3.charAt(k)){
        res=dfs(s1,s2,s3,i+1,j,k+1);
      }

      if(res) return true;
      if(j<s2.length()&&s2.charAt(j)==s3.charAt(k)){
          res=dfs(s1,s2,s3,i,j+1,k+1);
      }

      return res;
    }*/


    //加memo数组

/*    Boolean[][]memo;
    public boolean isInterleave(String s1, String s2, String s3) {
       memo=new Boolean[s1.length()+1][s2.length()+1];
        return dfs(s1,s2,s3,0,0,0);
    }

    boolean dfs(String s1,String s2,String  s3,int i,int j,int k){
        if(k==s3.length()){
            if(i==s1.length()&&j==s2.length()) return true;
            else return false;
        }

        boolean res=false;
        if(memo[i][j]!=null) return memo[i][j];
        if(i<s1.length()&&s1.charAt(i)==s3.charAt(k)){
            res=dfs(s1,s2,s3,i+1,j,k+1);
        }

        if(res) return true;
        if(j<s2.length()&&s2.charAt(j)==s3.charAt(k)){
            res=dfs(s1,s2,s3,i,j+1,k+1);
        }

        return memo[i][j]=res;
    }*/
    //尝试直接dp
    public boolean isInterleave(String s1, String s2, String s3) {
     if(s1.length()+s2.length()!=s3.length()) return false;

      boolean[][]dp=new boolean[s1.length()+1][s2.length()+1];
      dp[0][0]=true;
      for(int i=1;i<=s1.length()&&(s1.charAt(i-1)==s3.charAt(i-1));i++) dp[i][0]=true;
      for(int i=1;i<=s2.length()&&(s2.charAt(i-1)==s3.charAt(i-1));i++) dp[0][i]=true;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
               dp[i][j]=(dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1))||
                       (dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1));
            } 
        }
      return dp[s1.length()][s2.length()];
    }
}
