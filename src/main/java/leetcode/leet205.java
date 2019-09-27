package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet205 {
 /*   public boolean isIsomorphic(String s, String t) {
         if(s.length()!=t.length())return false;
     Map<Character,Character> map1=new HashMap<>();
        Map<Character,Character> map2=new HashMap<>();
         for(int i=0;i<s.length();i++){
          char sChar=s.charAt(i);
          char tChar=t.charAt(i);
          if(map1.containsKey(sChar)){
              if(map1.get(sChar)==tChar) continue;
              else return false;
          }
          else {
              map1.put(sChar,tChar);
          }
             if(map2.containsKey(tChar)){
                 if(map2.get(tChar)==sChar) continue;
                 else return false;
             }
             else {
                 map2.put(tChar,sChar);
             }
         }

         return true;
    }*/


    public boolean isIsomorphic(String s, String t) {
   int [] map=new int[512];
        for(int i=0;i<s.length();i++){
            char sChar=s.charAt(i);
            char tChar=t.charAt(i);
            if(map[sChar]!=map[tChar+256]) return false;
            map[sChar]=map[tChar+256]=i; //用来缓存index
        }
        return true;
    }
}
