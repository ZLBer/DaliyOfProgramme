package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class leet1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
         Map<String, List<Integer>> map=new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
          String name=keyName[i];
          String[] time=keyTime[i].split(":");
          if(!map.containsKey(name)) map.put(name,new ArrayList<>());
          int minutes=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
          map.get(name).add(minutes);
        }


        TreeSet<String> res=new TreeSet<>();
       // List<String> res=new ArrayList<>();
        for (Map.Entry<String, List<Integer>> stringListEntry : map.entrySet()) {
            List<Integer> values = stringListEntry.getValue();
            Collections.sort(values);
            if(values.size()<3) continue;
            int from=0,end=2;
            while (end<values.size()){
                if(values.get(end)<values.get(from)){
                   from=end;
                   end=from+2;
                   continue;
                }
               if(values.get(end++)-values.get(from++)<=60){
                   res.add(stringListEntry.getKey());
                   break;
               }
            }
        }
      //  Collections.sort(res);
        return new ArrayList<>(res);
    }
}
