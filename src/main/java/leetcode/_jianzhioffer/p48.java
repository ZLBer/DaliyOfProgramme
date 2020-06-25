package leetcode._jianzhioffer;


import java.util.HashSet;
import java.util.Set;

public class p48 {
    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
     Set<Character> set=new HashSet<>();
    int start=0,end=0;
    int res=0;
    while (end<s.length()){
       while (set.contains(s.charAt(end))){
           set.remove(s.charAt(start++));
       }
       set.add(s.charAt(end++));
       res=Math.max(res,end-start);
    }
    return res;
    }
}
