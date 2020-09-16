package leetcode.leetcode1000_1499;

import java.util.*;

public class leet1462$ {


    //不出所料 tle了  每次都要查找
   /*public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
   Map<Integer, Set<Integer>> map=new HashMap<>();

        for (int[] prerequisite : prerequisites) {
           int from=prerequisite[0];
           int to=prerequisite[1];
           if(!map.containsKey(to)) map.put(to,new HashSet<>());
           map.get(to).add(from);
        }

        List<Boolean> res=new ArrayList<>();
        for (int[] query : queries) {
            int from=query[0];
            int to=query[1];
          res.add(dfs(map,from,to));
        }
        return res;
    }

   boolean dfs(Map<Integer, Set<Integer>> map,int origin,int index){
       Set<Integer> set=map.getOrDefault(index, new HashSet<>());
       if(set.contains(origin) ) return true;
       for (Integer from : set) {
           if(dfs(map,origin,from)) return true;
       }
       return false;
   }
*/



   //依旧超时啊  难啊
    /*public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Set<Integer> nullSet=new HashSet<>();

        Map<Integer, Set<Integer>> map=new HashMap<>();
        boolean[]visited=new boolean[n];
        for (int[] prerequisite : prerequisites) {
            int from=prerequisite[0];
            int to=prerequisite[1];
            if(!map.containsKey(from)) map.put(from,new HashSet<>());
            map.get(from).add(to);
            visited[to]=true;
        }

        Queue<Integer> queue=new LinkedList<>();
        Map<Integer, Set<Integer>> pre=new HashMap<>();
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) queue.add(i);
           // visited[i]=false;
        }
        while (!queue.isEmpty()){
           int size=queue.size();
           while (size-->0){
               int from=queue.poll();
               for (Integer to : map.getOrDefault(from, nullSet)) {
                   if(!pre.containsKey(to)) pre.put(to,new HashSet<>());
                   pre.get(to).addAll(pre.getOrDefault(from,nullSet));
                   pre.get(to).add(from);
                 // if(visited[to]) continue;
                   queue.add(to);
                  // visited[to]=true;
               }
           }

        }

        List<Boolean> res=new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
           if(pre.getOrDefault(queries[i][1],nullSet).contains(queries[i][0]))
            res.add(true);
           else  res.add(false);
        }
        return res;

    }*/


    //Floy算法  绝了  只考虑连通性就可以

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] connected = new boolean[n][n];
        for (int[] p : prerequisites)
            connected[p[0]][p[1]] = true; // p[0] -> p[1]
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    connected[i][j] = connected[i][j] || connected[i][k] && connected[k][j];
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries)
            ans.add(connected[q[0]][q[1]]);
        return ans;
    }
}
