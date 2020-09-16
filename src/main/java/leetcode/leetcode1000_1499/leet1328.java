package leetcode.leetcode1000_1499;

public class leet1328 {
    //mine  智商题？
 /*   public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1) return "";
     char []pals =palindrome.toCharArray();
     boolean even=palindrome.length()%2==0;
        for (int i = 0; i < pals.length; i++) {
            if(pals[i]>'a'&&(even||i!=pals.length/2)) {
                pals[i]='a';
                return  new String(pals);
            }
        }

        pals[pals.length-1]++;
        return new String(pals);
    }*/


    //可以更简洁
    public String breakPalindrome(String palindrome) {
        char[] s = palindrome.toCharArray();
        int n = s.length;
     //只要前半段有不是a的就可以替换
        for (int i = 0; i < n / 2; i++) {
            if (s[i] != 'a') {
                s[i] = 'a';
                return String.valueOf(s);
            }
        }
        //全是a的情况
        s[n - 1] = 'b'; //if all 'a'
        return n < 2 ? "" : String.valueOf(s);
    }
}
