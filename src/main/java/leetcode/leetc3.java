package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetc3 {

    //暴力即可
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int maxCount=0;
        String maxString="";
        for(int length=minSize;length<=maxSize;length++){
            Map<String,Integer> map=new HashMap<>();
           for(int begin=0;begin+length<=s.length();begin++){
               String key=s.substring(begin,begin+length);
               map.put(key,map.getOrDefault(key,0)+1);
           }

           for(Map.Entry<String,Integer> e:map.entrySet()){
               if(e.getValue()>maxCount&&check(e.getKey(),maxLetters)){
                   maxCount=e.getValue();
               }
           }
        }
          return maxCount;
    }
    boolean check(String s,int maxLetters){
        Set<Character> set=new HashSet<>();
        for(char c:s.toCharArray()){
            set.add(c);
        }
        if(set.size()>maxLetters)
            return false;
        else return true;
    }
}
