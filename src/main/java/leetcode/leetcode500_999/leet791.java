package leetcode.leetcode500_999;

import java.util.HashMap;
import java.util.Map;

public class leet791 {
    //mine
    public String customSortString(String S, String T) {
        StringBuilder sb=new StringBuilder();
     Map<Character,Integer> mapT=new HashMap<>();
     for(Character c:T.toCharArray()){
         mapT.put(c,mapT.getOrDefault(c,0)+1);
     }

    for(Character c:S.toCharArray()){
        int i=mapT.getOrDefault(c,0);
        while (i-->0){
            sb.append(c);
        }
        mapT.remove(c);
    }
    for(Character c:mapT.keySet()){
        int i=mapT.getOrDefault(c,0);
        while (i-->0){
            sb.append(c);
        }
    }
return sb.toString();
    }
    //用数组代替map
   /* public String customSortString(String S, String T) {

        int[] count = new int[26];
        for (char c : T.toCharArray()) { ++count[c - 'a']; }  // count each char in T.
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            while (count[c - 'a']-- > 0) { sb.append(c); }    // sort chars both in T and S by the order of S.
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) { sb.append(c); }   // group chars in T but not in S.
        }
        return sb.toString();
    }*/
}
