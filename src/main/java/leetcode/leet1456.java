package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leet1456 {

    //mine 类似滑动窗口
    public int maxVowels(String s, int k) {
     int left=0,right=k-1;
     Set<Character> set=new HashSet<>();
     set.addAll(Arrays.asList('a','e','i','o','u'));
     int count=0;
     for(int i=left;i<=right;i++){
      if(set.contains(s.charAt(i))) count++;
     }
    int res=count;

     while (right+1<s.length()){
      if(set.contains(s.charAt(right+1))) count++;
      if(set.contains(s.charAt(left))) count--;
      right++;
      left++;
     res=Math.max(res,count);
     }
     return res;
    }
}
