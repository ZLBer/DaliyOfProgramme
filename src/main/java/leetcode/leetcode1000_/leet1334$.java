package leetcode.leetcode1000_;

import java.util.Arrays;

public class leet1334$ {


    //mine  错误的做法  错误的例子见： https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/discuss/490555/The-Reason-of-DFS-Not-Working-(Explain-Graph-and-Example)
 /*   public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      Map<Integer, List<int []>> neibors=new HashMap<>();


        for (int i = 0; i < n; i++) {
            neibors.put(i,new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            neibors.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            neibors.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
        }

        int res=0;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
           int temp=DFS(i,distanceThreshold,new HashSet<>(),neibors);
            System.out.println(temp);
           if(temp<=min){
               min=temp;
               res=i;
           }
        }
        return res;

    }
    int DFS(int point, int distance, Set<Integer> visited, Map<Integer, List<int []>> neibors){
        if(distance<0||visited.contains(point)) return 0;
        int sum=1; //该点可行
        visited.add(point);
        //继续下一轮
       for(int []neibor:neibors.get(point)){
          sum+=DFS(neibor[0],distance-neibor[1],visited,neibors);
       }
       return sum;
    }*/




    //dijkstra  单源最短路径
  /*  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, Map<Integer, Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            g.put(i, new HashMap<>());
        }
        for (int[] e : edges) {
            g.get(e[0]).put(e[1], e[2]);
            g.get(e[1]).put(e[0], e[2]);
        }
        int min = n + 1;
        int res = -1;
        for (int i = 0; i < n; i++) {
            Queue<int[]> q = new PriorityQueue<>((a, b)->(b[1] - a[1]));
            q.add(new int[]{i, distanceThreshold});
            Set<Integer> visited = new HashSet<>();
            int count = 0;
            while (!q.isEmpty()) {
                int[] city = q.poll();
                if (!visited.contains(city[0])) {
                    visited.add(city[0]);
                    count++;
                } else {
                    continue;
                }
                Map<Integer, Integer> m = g.get(city[0]);
                for (int neighbor : m.keySet()) {
                    if (!visited.contains(neighbor) && city[1] >= m.get(neighbor)) {
                        q.add(new int[]{neighbor, city[1] - m.get(neighbor)});
                    }
                }
            }
            if (count - 1 <= min) {
                min = count - 1;
                res = i;
            }
        }
        return res;
    }
*/

    //Floyd Algorithm
/*    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        int res = 0, smallest = n;
        for (int[] row : dis)
            Arrays.fill(row, 10001);
        for (int[] e : edges)
            dis[e[0]][e[1]] = dis[e[1]][e[0]] = e[2];
        for (int i = 0; i < n; ++i)
            dis[i][i] = 0;
        for (int k = 0; k < n; ++k)
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; ++j)
                if (dis[i][j] <= distanceThreshold)
                    ++count;
            if (count <= smallest) {
                res = i;
                smallest = count;
            }
        }
        return res;
    }*/

    //自己重写迪杰斯特拉算法
  /*  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int []>> neibors=new HashMap<>();
        for (int i = 0; i < n; i++) {
            neibors.put(i,new ArrayList<>()); }
        for (int i = 0; i < edges.length; i++) {
            neibors.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
            neibors.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
        }
        int res=0;
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            Set<Integer> visited=new HashSet<>();
            PriorityQueue<int[]> priorityQueue=new PriorityQueue<>((int []a,int[] b)->b[1]-a[1]);
            priorityQueue.add(new int[]{i,distanceThreshold});
            int count=0;
            while (!priorityQueue.isEmpty()){
                int []city=priorityQueue.poll();
                if(visited.contains(city[0])){
                    continue;
                }else {
                    visited.add(city[0]);
                     count++;
                     for(int []c:neibors.get(city[0])){
                         if(city[1]-c[1]>=0){
                            priorityQueue.add(new int[]{c[0],city[1]-c[1]});
                         }
                     }
                }
            }

            if(count<=smallest){
                smallest=count;
                res=i;
            }
        }
return res;
    }*/

    //自己重写floyd算法
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][]floyd=new int[n][n];
        for(int []row:floyd){
            Arrays.fill(row,10001);
        }
        for (int i = 0; i < edges.length; i++) {
            floyd[edges[i][0]][edges[i][1]]=floyd[edges[i][1]][edges[i][0]]=edges[i][2];
        }
        for(int i=0;i<n;i++){
            floyd[i][i]=0;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    floyd[i][j]=Math.min(floyd[i][j],floyd[i][k]+floyd[k][j]);
                }
            }
        }
        int smallest=Integer.MAX_VALUE;
        int res=0;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
             if(floyd[i][j]<=distanceThreshold) count++;
            }
            if(count<=smallest){
                smallest=count;
                res=i;
            }
        }
        return res;

    }

}
