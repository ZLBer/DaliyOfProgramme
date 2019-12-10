package leetcode;

import java.util.*;

public class leetc6 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
   Map<Integer, Queue<Integer>> map=new HashMap<>();
List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if(!map.containsKey(groupSizes[i])){
                Queue<Integer> queue=new LinkedList<>();
                map.put(groupSizes[i],queue);
            }
          Queue <Integer>queue= map.get(groupSizes[i]);
            queue.offer(i);


            //出队列
            if(queue.size()>=groupSizes[i]){
               int size=queue.size();
             List<Integer> temp=new ArrayList<>();
               while (size-->0){
         temp.add(queue.poll());
               }
               res.add(temp);
            }
        }
        return res;
    }
}
