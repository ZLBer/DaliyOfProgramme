package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leet1657 {
    //contest
    public boolean closeStrings(String word1, String word2) {
       if(word1.length()!=word2.length())return false;

      int []count1=new int[26],count2=new int[26];
      Set<Integer> set=new HashSet<>();
      Set<Integer> set1=new HashSet<>();
        for (int i = 0; i < word1.length(); i++) {
            set.add(word1.charAt(i)-'a');
            set1.add(word2.charAt(i)-'a');
            count1[word1.charAt(i)-'a']++;
            count2[word2.charAt(i)-'a']++;
        }
      Map<Integer,Integer> map=new HashMap<>();
        for (int i : count1) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        //检测频次
        for (int i=0 ;i<count2.length; i++) {
            int c=count2[i];
            int val=map.getOrDefault(c,0);
            if(val==0) return false;
           map.put(c,val-1);
        }
      //检测存不存在彼此的字母
        for (int i = 0; i < count2.length; i++) {
            if(count2[i]>0&&!set.contains(i))return false;
            if(count1[i]>0&&!set1.contains(i))return false;
        }
   

       return true;
    }
}
