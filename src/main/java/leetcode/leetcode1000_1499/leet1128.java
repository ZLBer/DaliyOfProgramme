package leetcode.leetcode1000_1499;

import java.util.HashMap;
import java.util.Map;

public class leet1128 {

    public int numEquivDominoPairs(int[][] dominoes) {
      Map<String,Integer> map=new HashMap<>();
       int result=0;
        for(int[] domine:dominoes){
            String key="";
            if(domine[0]<domine[1])
               key=domine[0]+""+domine[1];
            else  key=domine[1]+""+domine[0];

            result+=map.getOrDefault(key, 0);

            map.put(key,map.getOrDefault(key,0+1));

        }

        //可以这样计算result
  /*      for (int v : map.values()) {
            result += v * (v - 1) / 2;
        }*/


        return result;
    }
}
