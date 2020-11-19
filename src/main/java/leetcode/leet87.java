package leetcode;

public class leet87 {
    //错误的答案都能过158个用例 hhh
/*    public boolean isScramble(String s1, String s2) {
      if(s1.length()==1)return false;
       boolean[][]dp= new boolean[s1.length()][s1.length()];
        for (int i = 0; i < s1.length(); i++) {
          for(int j=1;j+i<=s1.length();j++){
              String ss1= s1.substring(i,j+i),ss2=s2.substring(i,i+j);
              if(ss1.equals(ss2)||ss1.equals(new StringBuilder(ss2).reverse().toString())) dp[i][i+j-1]=true;
          }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
return helper(0,dp);
    }

    boolean helper(int index,boolean [][]dp){
  if(index>=dp.length) return true;
        for(int i=index+1;i<dp.length;i++){
           if(dp[index][i]) {
              if(helper(i+1,dp)) return true;
           }
        }
        return false;
    }*/

  /*  public boolean isScramble(String s1, String s2) {
     if(s1.equals(s2)) return true;

     //需要剪枝  不剪枝过不了
        int []le1=new int[26],le2=new int[26];
        for (int i = 0; i < s1.length(); i++) {
            le1[s1.charAt(i)-'a']++;
            le2[s2.charAt(i)-'a']++;
        }

        for (int i = 0; i < le1.length; i++) {
            if(le1[i]!=le2[i]) return false;
        }

        

     for (int i=1;i<s1.length();i++){
       if(isScramble(s1.substring(0,i),s2.substring(0,i))&&isScramble(s1.substring(i),s2.substring(i))){
          return true;
        }
      if(isScramble(s1.substring(i),s2.substring(0,s1.length()-i))&&isScramble(s1.substring(0,i),s2.substring(s1.length()-i))){
              return true;
      }

     }
     return false;
    }*/



  //dp 三维
  public boolean isScramble(String s1, String s2) {
      boolean[][][]dp=new boolean[s1.length()][s2.length()][s1.length()+1];

      for(int len=1;len<=s1.length();len++){
          for(int i=0;i+len<=s1.length();i++){
              for(int j=0;j+len<=s2.length();j++){

                  if(len==1){
                      dp[i][j][len]=(s1.charAt(i)==s2.charAt(j));
                  }else {
                      for(int k=1;k<len;k++){
                          dp[i][j][len]=dp[i][j][len]||(dp[i][j][k]&&dp[i+k][j+k][len-k])
                                  ||(dp[i][j+len-k][k]&&dp[i+k][j][len-k]);
                      }
                  }
              }
          }
      }
      return  dp[0][0][s1.length()];
  }
}
