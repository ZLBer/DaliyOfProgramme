package leetcode;

import java.util.*;

public class leet1488 {
    //mine 改了不少次
    public int[] avoidFlood(int[] rains) {
        Map<Integer,Integer> full=new HashMap<>();
        TreeSet<Integer> take=new TreeSet<>();
        int []res=new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
          if(rains[i]==0){
       take.add(i);
          }else {
         res[i]=-1;
        if(!full.colentainsKey(rains[i])){
            full.put(rains[i],i);
        }else {
            //if(take.isEmpty()) return new int[]{};
          //  int index=full.remove(rains[i]);
            Integer pre=take.ceiling(full.get(rains[i]));
            if(pre==null) return new int[]{};
            take.remove(pre);
            res[pre]=rains[i];

            full.put(rains[i],i);

        }
          }
        }
        for (Integer integer : take) {
            res[integer]=1;
        }
        return res;
    }
}
