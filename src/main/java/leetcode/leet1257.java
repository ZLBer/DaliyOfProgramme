package leetcode;

import java.util.*;

public class leet1257 {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
    Map<String,String> parent=new HashMap<>();
        for (List<String> region : regions) {
            for (int i = 1; i < region.size(); i++) {
                parent.put(region.get(i),region.get(0));
            }
        }

      //  Map<String ,String>  r1m=new HashMap<>();
        Set<String> r1m=new HashSet<>();
        r1m.add(region1);
        String temp=region1;
        while (parent.containsKey(temp)){
            r1m.add(parent.get(temp));
            temp=parent.get(temp);
        }
     /*   for(Map.Entry<String,String> e: r1m.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }*/
        temp=region2;
        if(r1m.contains(temp)) return temp;
        while (parent.containsKey(temp)){

            temp=parent.get(temp); // System.out.println(temp);
             if(r1m.contains(temp)) return temp;
        }
        return null;
    }
}
