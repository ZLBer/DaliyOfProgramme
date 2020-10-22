package leetcode;

public class leet1616 {
    public boolean checkPalindromeFormation(String a, String b) {

        return helper(a,b)||helper(b,a);

    }

    boolean helper(String a,String b){
        int i = 0;
        int len = a.length();
        while (i < len && a.charAt(i) == b.charAt(len - i - 1)) i++;
        if (i >= (len) / 2) return true;
        if (check(b.substring(i, len - i)) || check(a.substring(i, len - i))) return true;
        return false;
    }

    boolean check(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}
