package leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by libin on 2019/4/22.
 */
public class leet1029 {


    //mine 递归 Time Limit Exceeded
 /*   int min=Integer.MAX_VALUE;
    public int twoCitySchedCost(int[][] costs) {
   dfs(costs,0,0,costs.length/2,costs.length/2);
      return min;
    }

  void dfs(int [][] costs,int depth,int sum,int a,int b){
      if(a==0&&b==0){
          min=Math.min(min,sum);
          return;
      }


        //去A
        if(a>0){
            dfs(costs,depth+1,sum+costs[depth][0],a-1,b);
        }
       //去B
        if(b>0){
            dfs(costs,depth+1,sum+costs[depth][1],a,b-1);
        }
  }*/




//Example: [30, 100], [40, 90], [50, 50], [70, 50].
//Savings: 70, 50, 0, -20.
//sorting  -20，0，50，70
    //负数表示去B省力，整数表示去A省力，但是负数不一定要去B，整数不一定要去A，所以将他们排序，最小的N个去B，最大的N的去A
    //若全负数 例如：[70, 50]，[70, 60] 。-20，-10。  第一个去B要比第二个去B省力
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[1] - a[0]) - (b[1] - b[0]);
            }
        });
        int cost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            cost += costs[i][1] + costs[costs.length-i-1][0];
        }
        return cost;
    }


   //DP..难以置信
  /*  public int twoCitySchedCost(int[][] costs) {
        int N = costs.length / 2;
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        }
        for (int j = 1; j <= N; j++) {
            dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
            }
        }
        return dp[N][N];
    }*/
}
