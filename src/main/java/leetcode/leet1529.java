package leetcode;

public class leet1529 {
    //mine
/*    public int minFlips(String target) {
       int i=0;
        while (i<target.length()&&target.charAt(i)=='0'){
            i++;
        }
       int res=0;
       if(i==0) {
           i++;
           res++;
       }
        for (; i < target.length(); i++) {
          if(target.charAt(i)!=target.charAt(i-1)) res++;
        }
        return res;
    }*/

  //只需要看第一个是0 or 1 即可
    public int minFlips(String s) {
        int ans = 0;
        int n = s.length();
        if (s.charAt(0) == '1') ++ans;
        for (int i = 0; i < n-1; ++i) {
            if (s.charAt(i) != s.charAt(i+1)) {
                ++ans;
            }
        }
        return ans;
    }
}
