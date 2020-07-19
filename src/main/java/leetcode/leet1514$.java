package leetcode;

import java.util.*;

public class leet1514$ {
    class Edge {
        int to;
        double succProb;

        public Edge(int to, double succProb) {
            this.to = to;
            this.succProb = succProb;
        }
    }

    //dfs应该是不对的
    /*public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            map.get(from).add(new Edge(to, succProb[i]));
            map.get(to).add(new Edge(from, succProb[i]));
        }
        Double[] dp = new Double[n];
        dfs(start, new boolean[n], map, dp, end);
        return dp[start];
    }

    double dfs(int index, boolean[] isVisited, Map<Integer, List<Edge>> map, Double[] dp, int end) {
        if (index == end) return 1.0;


        isVisited[index] = true;

        double max = 0.0;
        if (dp[index] != null) return dp[index];
        for (Edge edge : map.get(index)) {
            if (!isVisited[edge.to])
                max = Math.max(max, edge.succProb * dfs(edge.to, isVisited, map, dp, end));
        }
        isVisited[index] = false;

        return dp[index] = max;
    }*/



    //迪杰斯特拉 单元最短路径
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparing(a->-a.succProb));
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            map.get(from).add(new Edge(to, succProb[i]));
            map.get(to).add(new Edge(from, succProb[i]));
        }

         boolean[]visited=new boolean[n];
        priorityQueue.add(new Edge(start, 1.0));
        double res = 0;
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (edge.to == end) {
                return edge.succProb;
            }
            visited[edge.to]=true;
            for (Edge edge1 : map.get(edge.to)) {
               if(visited[edge1.to]) continue;
                priorityQueue.add(new Edge(edge1.to, edge.succProb * edge1.succProb));
            }
        }
        return res;
    }


    //迪杰斯特拉 + 剪枝
/*    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparing(a->-a.succProb));
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            map.get(from).add(new Edge(to, succProb[i]));
            map.get(to).add(new Edge(from, succProb[i]));
        }

        double []cost=new double[n];
        cost[start]=1.0;
        priorityQueue.add(new Edge(start, 1.0));
        double res = 0;
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (edge.to == end) {
                return edge.succProb;
            }
            for (Edge edge1 : map.get(edge.to)) {
                if(cost[edge1.to]>=edge.succProb * edge1.succProb) continue; //需要限制入队
                priorityQueue.add(new Edge(edge1.to, edge.succProb * edge1.succProb));
                cost[edge1.to]=edge.succProb * edge1.succProb;
            }
        }
        return res;
    }*/

    //弗洛伊德算法 TLE
 /*   public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[][] probs = new double[n][n];

        for (int i = 0; i < succProb.length; ++i) {
            int a = edges[i][0];
            int b = edges[i][1];
            probs[a][b] = probs[b][a] = succProb[i];
        }

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    probs[i][j] = Math.max(probs[i][j], probs[i][k] * probs[k][j]);
                }
            }
        }

        return probs[start][end];
    }*/
}
