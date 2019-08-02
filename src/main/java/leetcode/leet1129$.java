package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class leet1129$ {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Set<Integer>[][] graph = new Set[n][2];

        //graph[][0] 表示红颜色
        //graph[][1] 表示蓝颜色
        for (int i = 0; i < n; i++) {
            graph[i][0] = new HashSet<>();
            graph[i][1] = new HashSet<>();
        }

        // graph[i][0].add(j);   i表示开始点，j表示结束边
        for (int[] re : red_edges) {
            graph[re[0]][0].add(re[1]);
        }

        for (int[] be : blue_edges) {
            graph[be[0]][1].add(be[1]);
        }

        //初始化结果集
        int[][] res = new int[n][2];
        for (int i = 1; i < n; i++) {
            res[i][0] = res[i][1] = n * 2;
        }

        //添加初始化点，可能是红点或者蓝点（其实就是代表边的意思）
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            //ind表示当前的点，col表示当前点（边）的颜色
            int ind = cur[0], col = cur[1];
          //  1-col表示相反的颜色
            //这里开始遍历ind的临边
            for (Integer next : graph[ind][1 - col]) {
                //就是说这个点没被遍历过的话，用前一个点+1来操作
                //遍历过的点就不要操作了，因为BFS一定是先遍历近的点
                if (res[next][1 - col] == n * 2) {
                    res[next][1 - col] = res[ind][col] + 1;
                    q.offer(new int[]{next, 1 - col});
                }
            }
        }

        int[] ans = new int[n];
        //将答案求出
        //到这里可以发现，每个点要么就是蓝边，要么就是红边
        for (int i = 0; i < n; i++) {
            int min = Math.min(res[i][0], res[i][1]);
            ans[i] = min == n * 2 ? -1 : min;
        }

        return ans;

    }

    //自己重写一遍
  /*  public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Set<Integer>[][] G=new HashSet [n][2];
        for (int i = 0; i < G.length; i++) {
            G[i][0]=new HashSet<>();
            G[i][1]=new HashSet<>();
        }

        for(int []re:red_edges){
            G[re[0]][0].add(re[1]);
        }
        for(int []be:blue_edges){
            G[be[0]][1].add(be[1]);
        }
   int[][]result=new int[n][2];
        for (int i = 1; i < result.length; i++) {
            result[i][0]=result[i][1]=n*2;
        }

        Queue< int[]> queue=new LinkedList<>();
       queue.add(new int[]{0,0});
       queue.add(new int[]{0,1});
   while (!queue.isEmpty()){
       int cur[]=queue.poll();
       int index=cur[0],color=cur[1];

       for(int next:G[index][1-color]){
           if(result[next][1-color]==2*n){
               result [next][1-color]=result[index][color]+1;
               queue.offer(new int[]{next,1-color});
           }
       }

   }
        int []res=new int[n];
        for (int i = 1; i < result.length; i++) {
            res[i]=Math.min(result[i][0],result[i][1]);
            if(res[i]==2*n) res[i]=-1;
        }
return  res;
    }*/

}
