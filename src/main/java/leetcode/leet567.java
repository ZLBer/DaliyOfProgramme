package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leet567 {

    //mine 典型的滑动窗口
    //改了好一会  要考虑多点情况
    public boolean checkInclusion(String s1, String s2) {
      int []count=new int[26];
      Set<Character> set=new HashSet<>();
      for(char c:s1.toCharArray()){
          count[c-'a']++;
          set.add(c);
      }
      int left=0,right=0;
      while (right<s2.length()){

           char c=s2.charAt(right);

           count[c - 'a']--;


               while (left<=right&&count[c-'a']<0){
                count[s2.charAt(left++)-'a']++;
               }

           right++;
           if(right-left==s1.length()) return true;
      }

      return false;

    }

    //可以进行优化
    //因为s1的长度是固定的 所以滑动窗口固定下就好了
/*    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        //验证一开始的s1长度符不符合条件
        if (allZero(count)) return true;


        //固定长度 依次往下检测
        //左边的加上  右边的减去
        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }*/
}
