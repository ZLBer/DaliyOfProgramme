package leetcode;

/**
 * Created by libin on 2019/1/22.
 */
public class leet647$ {
  /*  public int countSubstrings(String s) {
       int count=2;
       for(int i=1;i<s.length()-1;i++){
           count++;
           for(int j=1;j<=i;j++){
               if(s.charAt(i-1)==s.charAt(i+j)) count++;
           }
       }

return count;
    }*/

   // 考虑不同的回文中心，然后从中心扩大，求以某个中心来获得的回文个数。
/*    int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length//自己的算法掉了这个长度
        }

        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }*/

  //// TODO: 2019/1/22  并不能理解DP，待理解
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if(dp[i][j]) ++res;
            }
        }
        return res;
    }

}
