package leetcode.leetcode1_499;

public class leet5$ {

    //dp
  /*  public String longestPalindrome(String s) {
      boolean[][]dp=new boolean[s.length()][s.length()];
      String res="";
      for(int i=s.length()-1;i>=0;i--){
          for(int j=i;j<s.length();j++){
              dp[i][j]=(s.charAt(i)==s.charAt(j)&&(j-i<3||dp[i+1][j-1]));
              if(dp[i][j]&&j-i+1>res.length()){
                  res=s.substring(i,j+1);
              }
          }
      }
      return res;
    }*/

    //直接法
/*   public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
       for(int i=0;i<s.length()-1;i++){
           extend(s,i,i);
           extend(s,i,i+1);
       }
       return s.substring(start,start+max);
    }
    int max=0;
    int start=0;
    void extend(String s,int i,int j){
        while (i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
  if(j-i-1>max){
      max=j-i-1;
      start=i+1;
  }
    }*/



    //另一种想法  避免遍历所有情况
//    https://leetcode.com/problems/longest-palindromic-substring/discuss/3060/(AC)-relatively-short-and-very-clear-Java-solution
/*    public String longestPalindrome(String s) {
        String res = "";
        int currLength = 0;
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s,i-currLength-1,i)){
                res = s.substring(i-currLength-1,i+1);
                currLength = currLength+2;
            }
            else if(isPalindrome(s,i-currLength,i)){
                res = s.substring(i-currLength,i+1);
                currLength = currLength+1;
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int begin, int end){
        if(begin<0) return false;
        while(begin<end){
            if(s.charAt(begin++)!=s.charAt(end--)) return false;
        }
        return true;
    }*/





   //2020/10/9 自己写的dp
    public String longestPalindrome(String s) {
        boolean [][]dp=new  boolean[s.length()][s.length()];
        int res=0;
        int []r=new int[2];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length()-i;j++){
                int k=j+i;

                if(i==0){
                    dp[j][k]=true;
                }else if(i==1){
                    if(s.charAt(k)==s.charAt(k-1)){
                        dp[j][k]=true;
                    }
                }else{
                    if(s.charAt(k)==s.charAt(j)){
                        dp[j][k]=dp[j+1][k-1];
                    }
                }

                if(dp[j][k]){
                    r=new int[]{j,k+1};
                }
            }
        }

 /*       for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
        return s.substring(r[0],r[1]);
    }
}
