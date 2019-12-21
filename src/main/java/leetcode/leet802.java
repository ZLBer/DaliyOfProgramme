package leetcode;

import java.util.*;

public class leet802 {
    //mine  有趣的题目 但是题解释的有点不清楚
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> safe=new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
             if(graph[i].length==0) safe.add(i);
        }
        int []visited=new int[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if(visited[i]==0)
                DFS(graph,visited,i);
        }
        Collections.sort(res);
        return res;
    }


    List<Integer> res=new ArrayList<>();
    //0表示未访问  2表示是安全点
    boolean  DFS(int[][]graph,int []visited,int deep){
      if(visited[deep]==2) return true;
      else if(visited[deep]==1) return false;
        visited[deep]=1;

        if(graph[deep].length==0) {
            visited[deep]=2;
            res.add(deep);
            return true;
        }
        boolean flag=true;
        for (int i = 0; i < graph[deep].length; i++) {
            // 需要所有的点都是安全点
            flag&=DFS(graph,visited,graph[deep][i]);
        }

        if(flag){
            res.add(deep);
            visited[deep]=2;
            return true;
        }
   return false;
    }


    //大概思路还是差不多的 为啥他比我快这么多
    //省去了排序的时间
  /*  public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if(graph == null || graph.length == 0)  return res;

        int nodeCount = graph.length;
        int[] color = new int[nodeCount];

        for(int i = 0;i < nodeCount;i++){
            if(dfs(graph, i, color))    res.add(i);
        }

        return res;
    }
    public boolean dfs(int[][] graph, int start, int[] color){
        if(color[start] != 0)   return color[start] == 1;

        color[start] = 2;
        for(int newNode : graph[start]){
            if(!dfs(graph, newNode, color))    return false;
        }
        color[start] = 1;

        return true;
    }*/
}
