package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet1704 {

    public boolean halvesAreAlike(String s) {
   Map<Character,Integer> map=new HashMap<>();
   map.put('a',0);
        map.put('e',0);
        map.put('i',0);
        map.put('o',0);
        map.put('u',0);
        map.put('A',0);
        map.put('E',0);
        map.put('I',0);
        map.put('O',0);
        map.put('U',0);
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
           if(!map.containsKey(c)) continue;
            if(i<s.length()/2){
             count++;
            }else {
             count--;
            }

        }


        return count==0;
    }



    public static void main(String[] args) {

    }
}
