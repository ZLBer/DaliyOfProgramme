package leetcode.leetcode1_499;

import java.util.*;

public class leet210 {

    //mine   拓扑排序  BFS
 /*   public int[] findOrder(int numCourses, int[][] prerequisites) {
          int [] count=new int[numCourses];
          Map<Integer, List<Integer>> map=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();
        for (int[] prerequisite : prerequisites) {
            count[prerequisite[0]]++;
          List<Integer> list=  map.computeIfAbsent(prerequisite[1],(k)->new ArrayList<>());
               list.add(prerequisite[0]);
        }

        for (int i = 0; i < count.length; i++) {
            if(count[i]==0) queue.add(i);
        }
        int []result=new int[numCourses];
        int index=0;
        while (!queue.isEmpty()){
           int in=queue.poll();
           result[index++]=in;
             List<Integer> list=map.get(in);
             if(list!=null){
                 for(int a:list){
                     if((--count[a])==0)queue.offer(a);
                 }
             }

        }

        return index==numCourses?result:new int[0];
    }*/



 //同样的想法 换成list却快了很多
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incLinkCounts = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        initialiseGraph(incLinkCounts, adjs, prerequisites);
       // return solveByBFS(incLinkCounts, adjs);
      return solveByDFS(adjs);
    }
    private void initialiseGraph(int[] incLinkCounts, List<List<Integer>> adjs, int[][] prerequisites){
        int n = incLinkCounts.length;
        while (n-- > 0) adjs.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            incLinkCounts[edge[0]]++;
            adjs.get(edge[1]).add(edge[0]);
        }
    }

    private int[] solveByBFS(int[] incLinkCounts, List<List<Integer>> adjs){
        int[] order = new int[incLinkCounts.length];
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < incLinkCounts.length; i++) {
            if (incLinkCounts[i] == 0) toVisit.offer(i);
        }
        int visited = 0;
        while (!toVisit.isEmpty()) {
            int from = toVisit.poll();
            order[visited++] = from;
            for (int to : adjs.get(from)) {
                incLinkCounts[to]--;
                if (incLinkCounts[to] == 0) toVisit.offer(to);
            }
        }
        return visited == incLinkCounts.length ? order : new int[0];
    }


    private int[] solveByDFS(List<List<Integer>> adjs) {
        BitSet visited = new BitSet(adjs.size());
        BitSet onStack = new BitSet(adjs.size());
        Deque<Integer> order = new ArrayDeque<>();
     /*   for (int i = adjs.size() - 1; i >= 0; i--) {
            if (visited.get(i) == false && hasOrder(i, adjs, visited, onStack, order) == false) return new int[0];
        }*/
        for (int i = 0; i <adjs.size(); i++) {
            if (visited.get(i) == false && hasOrder(i, adjs, visited, onStack, order) == false) return new int[0];
        }
        int[] orderArray = new int[adjs.size()];
        for (int i = 0; !order.isEmpty(); i++) orderArray[i] = order.pop();
        return orderArray;
    }

    //判断子树是否有回路
    private boolean hasOrder(int from, List<List<Integer>> adjs, BitSet visited, BitSet onStack, Deque<Integer> order) {
        visited.set(from);
        onStack.set(from);
        for (int to : adjs.get(from)) {
            if (visited.get(to) == false) {
                if (hasOrder(to, adjs, visited, onStack, order) == false) return false;
                //判断是否有回路
            } else if (onStack.get(to) == true) {
                return false;
            }
        }
        //清除指定from
        onStack.clear(from);
        //放入你序列中
        order.push(from);
        return true;
    }
    public static void main(String[] args) {
      leet210 l=new leet210();
      l.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}});
      BitSet bitSet=new BitSet();
      bitSet.set(1);
        System.out.println(Integer.toBinaryString(1<<31));
        System.out.println(bitSet.get(1));
    }
}
