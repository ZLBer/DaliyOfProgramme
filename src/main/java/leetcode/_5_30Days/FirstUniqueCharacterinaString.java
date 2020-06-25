package leetcode._5_30Days;

public class FirstUniqueCharacterinaString {
    //mine 两次遍历
    public int firstUniqChar(String s) {
        int []count=new int[26];
        int res=0;
        for (int i = s.length()-1; i >= 0; i--) {
       count[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(count[s.charAt(i)-'a']==1) return i;
        }
        return -1;
    }
}
