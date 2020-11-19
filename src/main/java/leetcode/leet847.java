package leetcode;

import java.util.Arrays;

public class leet847 {
   /* public int shortestPathLength(int[][] graph) {

    int max=(1<<graph.length)-1;
        System.out.println(max);
         Queue<int []> queue= new LinkedList<>();

        boolean[][]visited=new boolean[1<<graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
             queue.add(new int[]{1<<i,i});
             visited[1<<i][i]=true;
        }

        int step=0;
        while (!queue.isEmpty()){
          int size=queue.size();
          while (size-->0){
           int [] p=queue.poll();
              System.out.println(p[0]+" "+p[1]);
              for (int i : graph[p[1]]) {
                  int next=1<<i|p[0];
                 if(next==max) return  step+1;
                 if(!visited[next][i]){
                     visited[next][i]=true;
                    queue.add(new int[]{next,i});
                 }
              }
          }
          step++;
        }
       return -1;
    }
*/

    public int shortestPathLength(int[][] graph) {

  //先求出所有的路径长度
    int [][]dp=new int[graph.length][graph.length];
        for (int[] ints : dp) {
            Arrays.fill(ints,(int)1e9+7);
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                dp[i][graph[i][j]]=1;
            }
        }

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph.length;j++){
                if(i==j) continue;

                for(int k=0;k<graph.length;k++){
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                }
            }
        }

        int [][]dis=new int[1<<graph.length][graph.length];
        for (int i = 0; i < dis.length; i++) {
            Arrays.fill(dis[i],(int)1e9+7);
        }
        for (int i = 0; i < graph.length; i++) {
            dis[1<<i][i]=0;
        }

        int max=(1<<graph.length);
       for(int mask=1;mask<max;mask++){
           for(int cur=0;cur<graph.length;cur++){
               if(((1<<cur)&mask)==0) continue;
               for(int next=0;next<graph.length;next++){
                if(next==cur||((1<<next)&mask)!=0) continue;
                 dis[mask|1<<next][next]=Math.min(dis[mask|1<<next][next],dis[mask][cur]+dp[cur][next]);
                   System.out.println(dis[mask|1<<next][next]);
               }
           }
       }


       int res=Integer.MAX_VALUE;
        for (int i : dis[max - 1]) {
            res=Math.min(res,i);
        }
        return res;

    }
}
