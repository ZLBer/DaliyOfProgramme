package leetcode;

import java_code.util.*;
import jdk.internal.dynalink.linker.LinkerServices;

import java.util.*;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by libin on 2019/1/18.
 */
public class leetcode884 {
    public String[] uncommonFromSentences(String A, String B) {
        LinkedList<String> results=new LinkedList<>();
        Map<String,Integer> map=new HashMap<>();
         String []a=A.split(" ");
         String []b=B.split(" ");
         for(String c:a){
             map.put(c,map.getOrDefault(c,0)+1);
         }
         for(String c:b){
           map.put(c,map.getOrDefault(c,0)+1);
         }

       for(Map.Entry entry:map.entrySet()){
              if((Integer)entry.getValue()==1) results.add((String)entry.getKey());
       }
       return results.toArray(new String [results.size()]);
    }
}
