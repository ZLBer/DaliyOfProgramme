package leetcode.leetcode1_499;

public class leet91 {

    //mine  带检验的dp
    public int numDecodings(String s) {
      int []dp=new int[s.length()+1];
      dp[0]=1;
      dp[1]=1;
      //只要第一个是0就不对
      if(s.charAt(0)=='0') return 0;

      for(int i=1;i<s.length();i++){
          //检验本位和前一位
          if(s.charAt(i)!='0')
                 dp[i+1]=dp[i];
         if(s.charAt(i-1)!='0'&&Integer.valueOf(s.substring(i-1,i+1))<27){
             dp[i+1]+=dp[i-1];
         }
         //没有对应的编码 直接返回
         if(dp[i+1]==0)  return 0;
      }
        return  dp[s.length()];
    }



    //看着更清晰一点  并没有上面的快
   /* public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
            if(dp[i]==0) return 0;
        }
        return dp[n];
    }*/

   //从后往前遍历
  /*  public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }*/
}
