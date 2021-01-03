package leetcode;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class leet1691 {
  /*  public int maxHeight(int[][] cuboids) {
        visited=new boolean[cuboids.length];
       this.cuboids=cuboids;
       memo=new Integer[102][102][102];
   dfs(new int[]{101,101,101},0,0);
   return max;
    }
    int max=0;
    boolean []visited;
    int [][]cuboids;
    Integer [][][]memo;
    int dfs(int []pre,int count,int heigh){
//       if(count>=cuboids.length){
//         max=Math.max(heigh,max);
//         return;
//       }

      if(memo[pre[0]][pre[1]][pre[2]]!=null) return memo[pre[0]][pre[1]][pre[2]];

       max=Math.max(max,heigh);
        for (int i = 0; i < cuboids.length; i++) {
          if(visited[i]) continue;
          boolean flag=false;
          int w=cuboids[i][0],l=cuboids[i][1],h=cuboids[i][2];
         if(w<=pre[0]&&l<=pre[1]&&h<=pre[2]) {
             flag=true;
             visited[i]=true;
             int cost=  dfs(new int[]{w,l,h},count+1,heigh+h);
             visited[i]=false;
         }
       if(w<=pre[0]&&h<=pre[1]&&l<=pre[2]) {
                flag=true;
                visited[i]=true;
              int cost=  dfs(new int[]{w,h,l},count+1,heigh+l);
                visited[i]=false;
         }

            if(l<=pre[0]&&w<=pre[1]&&h<=pre[2]) {
                flag=true;
                visited[i]=true;
                int cost=  dfs(new int[]{l,w,h},count+1,heigh+h);
                visited[i]=false;
            }
            if(l<=pre[0]&&h<=pre[1]&&w<=pre[2]) {
                flag=true;
                visited[i]=true;
                int cost= dfs(new int[]{l,h,w},count+1,heigh+w);
                visited[i]=false;
            }
            if(h<=pre[0]&&w<=pre[1]&&l<=pre[2]) {
                flag=true;
                visited[i]=true;
                int cost=   dfs(new int[]{h,w,l},count+1,heigh+l);
                visited[i]=false;
            }
            if(h<=pre[0]&&l<=pre[1]&&w<=pre[2]) {
                flag=true;
                visited[i]=true;
                int cost=  dfs(new int[]{h,l,w},count+1,heigh+w);
                visited[i]=false;
            }

         if(flag==false) count++;//在现有的情况下不能加入 所以剔除
        } 
    }*/

    public int maxHeight(int[][] cuboids) {
        for (int i = 0; i < cuboids.length; i++) {
            Arrays.sort(cuboids[i]);
        }
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return a[2] - b[2];
                } else {
                    return a[1] - b[1];
                }
            } else {
                return a[0] - b[0];
            }
        });
        int[] dp = new int[cuboids.length];
        int res=0;
        for (int i = 0; i < cuboids.length; i++) {
          for(int j=0;j<i;j++){
             if(cuboids[i][0]>=cuboids[j][0]&&cuboids[i][1]>=cuboids[j][1]&&cuboids[i][2]>=cuboids[j][2]){
                dp[i]=Math.max(dp[j],dp[i]);
             }
          }
          dp[i]+=cuboids[i][2];
          res=Math.max(dp[i],res);
        }
        return res;
    }


    static class LocalVariable {
        private Long[] a = new Long[1024*1024];
    }

    // (1)
    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());
    // (2)
    final static ThreadLocal<LocalVariable> localVariable = new ThreadLocal<LocalVariable>();

    public static void main(String[] args) throws InterruptedException {
        // (3)
        for (int i = 0; i < 50; ++i) {
            poolExecutor.execute(new Runnable() {
                public void run() {
                    // (4)
                    localVariable.set(new LocalVariable());
                    // (5)
                    System.out.println("use local varaible");
                    //localVariable.remove();

                }
            });

            Thread.sleep(1000);
        }
        // (6)
        System.out.println("pool execute over");
    }
}
