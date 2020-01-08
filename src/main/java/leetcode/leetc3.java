package leetcode;

import java.util.*;

public class leetc3 {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer >queue=new LinkedList<>();
        queue.add(id);
        int step=-1;
        Set<Integer> visited=new HashSet<>();
        Map<String,Integer> map=new HashMap<>();
        visited.add(id);
        while (!queue.isEmpty()){
           step++;
           if(step==level){
             while (!queue.isEmpty()){
                for(String s: watchedVideos.get(queue.poll())){
                    map.put(s,map.getOrDefault(s,0)+1);
                }
             }
             break;
           }
           int size=queue.size();
           while (size-->0){
               int tid=queue.poll();

              for(int i:friends[tid]){
                  if(!visited.contains(i)) {
                      queue.add(i); visited.add(i);
                  }
              }
           }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                //按照value值，从大到小排序
                if(o1.getValue()==o2.getValue()){
                    return o1.getKey().compareTo(o2.getKey());
                }
               return -o2.getValue() + o1.getValue();
            }
        });

        List<String> res=new ArrayList<>();
        for (Map.Entry<String,Integer> s : list)
        {
           res.add(s.getKey());
        }
        return res;
    }
}
