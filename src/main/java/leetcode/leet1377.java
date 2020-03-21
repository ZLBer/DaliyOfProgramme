package leetcode;

import java.util.*;

public class leet1377 {


    //mine dfs 不是很难  就是考虑的情况多了点
    public double frogPosition(int n, int[][] edges, int t, int target) {
        //没有边
        if(edges.length==0){
            return target==1?1:0;
        }
     Map<Integer, List<Integer>> map=new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int from=edges[i][0],to=edges[i][1];
            List<Integer> fromList=map.computeIfAbsent(from,k->new ArrayList<>());
            fromList.add(to);
            List<Integer> toList=map.computeIfAbsent(to,k->new ArrayList<>());
            toList.add(from);
        }
  boolean []visited=new boolean[n+1];
 return   dfs(map,1,target,1,visited,t);
    }

    double dfs( Map<Integer, List<Integer>> map,int here,int taget,double probability ,boolean[]visited,int time){

        if(here==taget){
            if(time==0||(time>0&&check(map, here, visited))) return probability;
            else return 0;
        }
        visited[here]=true;

        //先统计概率
        int count=0;
        List<Integer> neibor=map.get(here);
        for(int index:neibor){
          if(visited[index]) continue;
          count++;
        }
        for (int index : neibor) {
            if(!visited[index]) {
                double p=dfs(map,index,taget,probability*((double) 1/count),visited,time-1);
                if(p>0) return p;
            }
        }
        visited[here]=false;
        return 0;
    }

    //都不可以访问的检测
    boolean check(Map<Integer, List<Integer>> map,int here,boolean[]visited){
        List<Integer> neibor=map.get(here);
        for(int index:neibor){
            if(!visited[index]) return false;
        }
        return true;
    }



   //别人的dfs   由此返现自己很多细节上可以优化
    //map换数组  空间换时间
    //计算概率的优化  不用计算两边 概率不用dfs传下去
    //check可以进一步优化 等等
   /* LinkedList<Integer> adjListArray[];
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (n == 1) return 1.0;
        adjListArray = new LinkedList[n + 1];
        for(int i = 0; i <= n ; i++) adjListArray[i] = new LinkedList<>();
        for (int[] edge : edges) {
            adjListArray[edge[0]].add(edge[1]);
            adjListArray[edge[1]].add(edge[0]);
        }

        return dfs(1, t, target, new boolean[n + 1]);
    }

    private double dfs(int node, int t, int target, boolean[] visited) {
        if (node != 1 && adjListArray[node].size() == 1 || t == 0) {
            if (node == target)
                return 1;
            else return 0;
        }
        visited[node] = true;
        double res = 0.0;
        for (int child : adjListArray[node]) {
            if (visited[child]) continue; // skip visited children
            res += dfs(child, t - 1, target, visited);
        }
        if (node != 1)
            return res * 1.0 / (adjListArray[node].size() - 1);
        else
            return res * 1.0 / (adjListArray[node].size());
    }*/



   /*//bfs
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0] - 1].add(e[1] - 1);
            graph[e[1] - 1].add(e[0] - 1);
        }
        boolean[] visited = new boolean[n]; visited[0] = true;
        double[] prob = new double[n]; prob[0] = 1f;
        Queue<Integer> q = new LinkedList<>(); q.offer(0);
        while (!q.isEmpty() && t-- > 0) {
            for (int size = q.size(); size > 0; size--) {
                int u = q.poll(), nextVerticesCount = 0;
                for (int v : graph[u]) if (!visited[v]) nextVerticesCount++;
                for (int v : graph[u]) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.offer(v);
                        prob[v] = prob[u] / nextVerticesCount;
                    }
                }
                if (nextVerticesCount > 0) prob[u] = 0; //意思就是还有别的点可以访问
            }
        }
        return prob[target - 1];
    }*/
}
