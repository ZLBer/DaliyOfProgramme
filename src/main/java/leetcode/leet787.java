package leetcode;

import java.util.*;

public class leet787 {


    //mine  DFS  需要剪枝
/*   public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    Map<Integer, List<int[]>> map=new HashMap <>();
        for (int i = 0; i < flights.length; i++) {
            if(!map.containsKey(flights[i][0])) map.put(flights[i][0],new ArrayList<>());
            map.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }

        int p=dfs(src,dst,K+1,0,map);
        return p==Integer.MAX_VALUE?-1:p;
    }
    int minCost= Integer.MAX_VALUE;
    int dfs(int src,int dst,int k,int price, Map<Integer, List<int[]>> map){
        if(k<0) return Integer.MAX_VALUE;
        if(src==dst){
            minCost=price;
            return price;
        }

        int min=Integer.MAX_VALUE;
        if(!map.containsKey(src)) return min;
        for(int[]arr:map.get(src)){
            if(minCost<=price+arr[1]) continue;//剪枝
           min=Math.min(min,dfs(arr[0],dst,k-1,price+arr[1],map));
        }

        return min;

    }*/

  //BFS  根据k作为广度遍历
   public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
       Map<Integer, List<int[]>> map=new HashMap <>();
       for (int i = 0; i < flights.length; i++) {
           if(!map.containsKey(flights[i][0])) map.put(flights[i][0],new ArrayList<>());
           map.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
       }
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        int stops = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size; i++){
                int city = queue.poll();
                if(!map.containsKey(city)) continue;
                for(int []f:map.get(city)){
                    int u = f[0];
                    int v = f[1];
                    if(stops == K && u != dst) continue; // if we are total stops and not destination yet we can skip this!
                    if( cost[u] > cost[city] + v){
                        cost[u] = cost[city] + v;
                        queue.add(u);
                    }
                }
            }
            stops++;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }


    //迪杰斯特拉
   /*public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> map=new HashMap <>();
        for (int i = 0; i < flights.length; i++) {
            if(!map.containsKey(flights[i][0])) map.put(flights[i][0],new ArrayList<>());
            map.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }
        PriorityQueue<int[]>priorityQueue=new PriorityQueue<>((a,b)->a[2]-b[2]);
        priorityQueue.add(new int[]{src,K+1,0});
        while (!priorityQueue.isEmpty()){
            int []top=priorityQueue.poll();
            int city=top[0];
            int k=top[1];
            int price=top[2];
            if(city==dst) return price;
            if(k>0){
                if(!map.containsKey(city)) continue;
                for(int []adi:map.get(city)){
                    priorityQueue.add(new int[]{adi[0],k-1,price+adi[1]});
                }
            }
        }
        return -1;
    }*/

    public static void main(String[] args) {
    }
}
