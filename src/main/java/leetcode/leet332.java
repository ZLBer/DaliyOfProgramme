package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class leet332 {


    //mine
  /*  public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>>map=new HashMap<>();
        for (List<String> ticket : tickets) {
            String from=ticket.get(0),to=ticket.get(1);
           if(!map.containsKey(from)){
               map.put(from,new PriorityQueue<String>());
           }
           map.get(from).add(to);
        }
        List<String> list=new ArrayList<>();
        list.add("JFK");
return dfs(map,0,"JFK",tickets.size(),list);
    }
  List<String> dfs( Map<String, PriorityQueue<String>>map,int index,String from,int end,List<String> list){
      if(index>=end){
          return list;
      }
     if(!map.containsKey(from)) return null;


     PriorityQueue<String> priorityQueue=map.get(from);
     PriorityQueue<String> newpriorityQueue=new PriorityQueue<>(priorityQueue);
     while (!newpriorityQueue.isEmpty()) {
          String to=newpriorityQueue.poll();
          priorityQueue.remove(to);
          list.add(to);
          List<String> res=dfs(map,index+1,to,end,list);
          if(res!=null) return res;
          list.remove(list.size()-1);
          priorityQueue.add(to);
      }

     return null;
  }

*/

    //还是人家的好啊
    public List<String> findItinerary(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        List<String> ans = new LinkedList<>();
        if (tickets == null || tickets.size() == 0)
            return ans;
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            PriorityQueue<String> nbr = graph.computeIfAbsent(pair.get(0), k -> new PriorityQueue<>());
            nbr.add(pair.get(1));
        }
        visit(graph, "JFK", ans);
        return ans;
    }
    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void visit(Map<String, PriorityQueue<String>> graph, String src, List<String> ans) {
        PriorityQueue<String> nbr = graph.get(src);
        while (nbr != null && nbr.size() > 0) {
            String dest = nbr.poll();
            visit(graph, dest, ans);
        }
        ans.add(0, src); // 逆序插入
    }


}
