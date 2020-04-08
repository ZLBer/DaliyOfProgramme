package leetcode._30Days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
   Map<String,ArrayList<String>> map=new HashMap<>();
        for (String str : strs) {
            String key=getString(str);
           List<String> list= map.computeIfAbsent(key,(k)->new ArrayList<>());
          list.add(str);
         }
        List<List<String>> res=new ArrayList<>();
        for (ArrayList<String> value : map.values()) {
            res.add(value);
        }
        return res
                ;
    }

    String getString(String str){
        int count[]=new int[26];
        for (char c : str.toCharArray()) {
            count[c-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for (int i : count) {
             sb.append(i);
        }
        return sb.toString();
    }
}
