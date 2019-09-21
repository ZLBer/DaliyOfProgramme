package leetcode.leetcode1_499;

import java.util.*;

public class leet3 {
    //mine
    public int lengthOfLongestSubstring(String s) {
        if("".equals(s)) return 0;
      char[] chars=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        int maxLength=0;
        int begin=0;
        for (int i = 0; i < chars.length; i++) {
            int pre=map.getOrDefault(chars[i],-1);
            if(pre<begin){
                map.put(chars[i],i);
            }
            else {
               maxLength=Math.max(i-begin,maxLength);
               begin=pre+1;
               map.put(chars[i],i);
            }
        }
        return Math.max(chars.length-begin,maxLength);
    }



    //简化版
/*    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }*/


    //只用set 维护两个指针i j
 /*   public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }*/


}
