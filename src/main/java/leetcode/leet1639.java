package leetcode;

public class leet1639 {


    //终于能自己想出个hard题的dp思路了
    public int numWays(String[] words, String target) {
        int mod = (int)1e9+7;
     long [][]dp=new long[target.length()+1][words[0].length()+1];


     //统计字母个数
   int [][]letters=new int[words[0].length()][26];
        for (int i = 0; i < words[0].length(); i++) {
            for (int j = 0; j < words.length; j++) {
                letters[i][words[j].charAt(i)-'a']++;
            }
        }
//        for (int i = 0; i < letters.length; i++) {
//            for (int j = 0; j < letters[0].length; j++) {
//                System.out.print(letters[i][j]+" ");
//            }
//            System.out.println();
//        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i]=1;
        }
    for(int i=0;i<target.length();i++){
        char t=target.charAt(i);
        for(int j=i;j<words[0].length();j++){

          if(letters[j][t-'a']>0){
              dp[i+1][j+1]=(dp[i+1][j]+dp[i][j]*letters[j][t-'a'])%mod;
          }else {
              dp[i+1][j+1]=dp[i+1][j];
          }
            System.out.print(dp[i][j]+" ");
        }
        System.out.println();
    }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }
    return (int)(dp[target.length()][words[0].length()]%mod);
    }





    public static void main(String[] args) {
        System.out.println((int)10e9+7);
        System.out.println((int)1e9+7);
    }

}
