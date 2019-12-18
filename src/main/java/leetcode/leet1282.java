package leetcode;

import java.util.*;

public class leet1282 {
    //mine  hashmap
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

   //相同的思想  但是更简单的实现
/*    public List<List<Integer>> groupThePeople(int[] gz) {
        List<List<Integer>> res = new ArrayList();
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < gz.length; ++i) {
            List<Integer> list = groups.computeIfAbsent(gz[i], k -> new ArrayList());
            list.add(i);
            if (list.size() == gz[i]) {
                res.add(list);
                groups.put(gz[i], new ArrayList());
            }
        }
        return res;
    }*/
}
