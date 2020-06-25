package leetcode._4_30Days;

import java.util.*;

public class leet2 {
    public int numWays(int n, int[][] relation, int k) {
Map<Integer, List<Integer>> map=new HashMap<>();
        for (int i = 0; i < relation.length; i++) {
            if(!map.containsKey(relation[i][0])) map.put(relation[i][0],new ArrayList<>());
            map.get(relation[i][0]).add(relation[i][1]);
        }

        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        while (k-->0&&!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
               int people=queue.poll();
               if(!map.containsKey(people)) continue;
               for(int next:map.get(people)){
                  queue.add(next);
               }
            }
        }
        int res=0;
        while (!queue.isEmpty()){
            if(queue.poll()==n-1) res++;
        }
        return res;
    }
}
