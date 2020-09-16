package leetcode.leetcode500_999;

import java.util.LinkedList;
import java.util.Queue;

public class leet785 {
/*  //mine
    public boolean isBipartite(int[][] graph) {
          Set<Integer> A=new HashSet<>();
          Set<Integer> B=new HashSet<>();

           A.add(0);
          boolean[]visited=new boolean[graph.length];
        for (int j = 0; j < visited.length; j++) {
           if(!visited[j]){
               Queue<Integer> queue=new LinkedList<>();
               queue.add(j);
               while (!queue.isEmpty()){
                   int index=queue.poll();
                   visited[index]=true;
                   if(A.contains(index)){ //在A里
                       for (int i : graph[index]) {
                           if(A.contains(i) ) return false;
                           else {
                               if(!visited[i]) {
                                   queue.add(i);
                                   B.add(i);
                               }}
                       }
                   }else {
                       for (int i : graph[index]) {
                           if(B.contains(i)) return false;
                           else {
                               if(!visited[i]) {
                                   queue.add(i);
                                   A.add(i);
                               }
                           }
                       }
                   }
               }
           }
        }     

         return true;

    }
*/




    //思路是一样的，但可以不用set，用一个数组即可，既可以标记访问，又可以标记分组
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        for (int i = 0; i < n; ++i) {
            if (color[i] == UNCOLORED) {
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(i);
                color[i] = RED;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int cNei = color[node] == RED ? GREEN : RED;
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == UNCOLORED) {
                            queue.offer(neighbor);
                            color[neighbor] = cNei;
                        } else if (color[neighbor] != cNei) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
