package leetcode;

public class leet680 {
    //Time Limit Exceeded
/*
    public boolean validPalindrome(String s) {
           String reverseS=new StringBuilder(s).reverse().toString();
           if(s.equals(reverseS)) return true;
           for(int i=0;i<s.length();i++){
            int j=s.length()-1-i;
               System.out.println(s.substring(0,i)+s.substring(i+1));
               System.out.println(reverseS.substring(0,j)+reverseS.substring(j+1));
           if((s.substring(0,i)+s.substring(i+1)).equals(
            reverseS.substring(0,j)+reverseS.substring(j+1)))
               return true;
           }
           return false;
    }
*/


//全部扫描版本
/*    static public boolean validPalindrome(String s) {
        char[] chars=s.toCharArray();
        int []delete =new int[2];
        int begin=0;
        for(;begin<s.length();begin++){
            int end=s.length()-begin-1;
            if(chars[begin]==chars[end]) continue;
            else {
                delete[0]=begin;
                delete[1]=end;
                break;
            }
        }
        if(begin==s.length())return true;
        begin=0;
        int end=s.length()-begin-1;
        for(;begin<s.length();begin++){
            if(begin==delete[0]) continue;
            // 跳过
            if(end==delete[0]) end--;
            if(chars[begin]==chars[end]) end--;
            else {
                break;
            }
        }
        if(begin==s.length()) return true;

        begin=0;
        end=s.length()-begin-1;
        for(;begin<s.length();begin++){

            if(begin==delete[1])continue;
            if(end==delete[1]) end--;

            if(chars[begin]==chars[end]) end--;
            else {
                break;
            }
        }
        if(begin==s.length()) return true;
        return false;

    }*/

    //
    static public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] delete = new int[2];
        int begin = 0;
        int end = s.length() - begin - 1;
        for (; begin < end; begin++) {
            if (chars[begin] == chars[end]) {
                end--;
                continue;
            } else {
                delete[0] = begin;
                delete[1] = end;
                break;
            }
        }
        if (begin == end || begin - 1 == end) return true;

        begin = 0;
        end = s.length() - begin - 1;
        for (; begin < end; begin++) {
            if (begin == delete[0]) continue;
            if (end == delete[0]) end--;
            if (chars[begin] == chars[end]) end--;
            else {
                break;
            }
        }
        if (begin == end || begin - 1 == end) return true;

        begin = 0;
        end = s.length() - begin - 1;
        for (; begin < end; begin++) {
            if (begin == delete[1]) continue;
            if (end == delete[1]) end--;
            if (chars[begin] == chars[end]) end--;
            else {
                break;
            }
        }
        if (begin == end || begin - 1 == end) return true;

        return false;

    }


//和我的想法一样 但是用递归实现，但是简洁了很多！！！
/*    public boolean validPalindrome(String s) {
        int l = -1, r = s.length();
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r+1) || isPalindromic(s, l-1, r);
        return true;
    }

    public boolean isPalindromic(String s, int l, int r) {
        while (++l < --r)
            if (s.charAt(l) != s.charAt(r)) return false;
        return true;
    }*/


    public static void main(String[] args) {
     validPalindrome("cbbcc");
    }
}
