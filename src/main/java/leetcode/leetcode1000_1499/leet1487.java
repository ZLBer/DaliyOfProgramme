package leetcode.leetcode1000_1499;

import java.util.HashMap;
import java.util.Map;

public class leet1487 {
    public String[] getFolderNames(String[] names) {

        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i < names.length; i++) {
          if(map.containsKey(names[i])){
             int index=map.get(names[i])+1;
             while (map.containsKey(names[i]+"("+index+")")){
                 index++;
             }
            map.put(names[i],map.get(names[i])+1);
             map.put(names[i]+"("+index+")",0);
             names[i]=names[i]+"("+index+")";
          }else {
              map.put(names[i],0);
          }
        }
        return names;
    }
}
