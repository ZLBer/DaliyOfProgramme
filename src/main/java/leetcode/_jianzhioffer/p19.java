package leetcode._jianzhioffer;

public class p19 {

    //不能忽略空串的匹配
 /* static public boolean isMatch(String s, String p) {
      boolean [][]dp=new boolean[s.length()+1][p.length()+1];
   dp[0][0]=true;
     
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                char charJ=p.charAt(j);
                char charI=s.charAt(i);
               if(charJ=='.'){
                 dp[i+1][j+1]=dp[i][j];
               }else if(charJ=='*'){
                  //当作0个
                   if(j>=1){
                      dp[i+1][j+1]|=dp[i+1][j-1];
                  }
                   //当作n个
                  if(i>=0&&j>=1&&(charI==p.charAt(j-1)||p.charAt(j-1)=='.'))
                      dp[i+1][j+1]|=dp[i][j+1];

               }else {
                 if(charJ==charI){
                   dp[i+1][j+1]=dp[i][j];
                 }
               }
            }
        }


        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[dp.length-1][dp[0].length-1];
    }
*/
    public static void main(String[] args) {
        isMatch("a",".*");
    }

  static public boolean isMatch(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) { //0列时只能0行为true
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (B.charAt(j - 1) != '*') {
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }

        return f[n][m];
    }


}
