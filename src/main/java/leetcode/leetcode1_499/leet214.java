package leetcode.leetcode1_499;

public class leet214 {

  /*  //暴力切分比较
    public String shortestPalindrome(String s) {

        String rs=new StringBuilder(s).reverse().toString();

        for(int i=s.length();i>=0;i--){
           String s1=s.substring(0,i);
           String s2=rs.substring(s.length()-i);
           if(s1.equals(s2)){
             return  rs.substring(0,s.length()-i)+s;
           }
        }
      return "";
    }

    //字符串哈希

    public String shortestPalindrome(String s) {
        int n = s.length();
        int base = 131, mod = 1000000007;
        int left = 0, right = 0, mul = 1;
        int best = -1;
        for (int i = 0; i < n; ++i) {
            left = (int) (((long) left * base + s.charAt(i)) % mod);
            right = (int) ((right + (long) mul * s.charAt(i)) % mod);
            if (left == right) {
                best = i;
            }
            mul = (int) ((long) mul * base % mod);
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }
*/



    // KMP 算法 加#是为了匹配到太多
 static   public String shortestPalindrome(String s) {
        String ss = s + '#' + new StringBuilder(s).reverse();
        int max = getLastNext(ss);
        return new StringBuilder(s.substring(max)).reverse() + s;
    }

    //返回 next 数组的最后一个值,因为是前缀和后缀的比较，一定最后一个值的大小
  static   public int getLastNext(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[] next = new int[n + 1];
        next[0] = -1;
        next[1] = 0;
        int k = 0;
        int i = 2;
        while (i <= n) {
            if (k == -1 || c[i - 1] == c[k]) {
                next[i] = k + 1;
                k++;
                i++;
            } else {
                k = next[k];
            }
        }
        return next[n];
    }


    public static void main(String[] args) {
        shortestPalindrome("abb");
    }


}
