package leetcode.leetcode1000_1499;

import java.util.Arrays;

public class leet1473$ {



    //超时了  记忆化dfs
/*   static public int minCost(int[] houses, int[][] cost, int m, int n, int target) {

  dp=new Integer[houses.length][target+1];

  return helper(m,n,0,houses,-1,target,cost);
    }
 static Integer[][]dp;
 static    int helper(int m,int n,int house,int []houses,int pre,int target,int [][]cost){

        if(house>=houses.length){
            if(target==0) return 0;
            else return -1;
        }
       if(target==0){
         int minCost=0;
          for(int i=house;i<houses.length;i++){
              if(houses[i]==0){
               minCost+=cost[i][pre-1];
              }else if(houses[i]==pre){
                   continue;
              }else {
                 return -1;
              }
          }
          return minCost;
      }


if(dp[house][target]!=null) return dp[house][target];


        int minCost=Integer.MAX_VALUE;
      if(houses[house]==0){          //之前没有颜色
          for(int i=1;i<=n;i++){
            if(i!=pre){
                int next=helper(m,n,house+1,houses,i,target-1,cost);
                if(next<0) continue;
             minCost=Math.min(minCost,cost[house][i-1]+next);
            }else {
                int next=helper(m,n,house+1,houses,i,target,cost);
                if(next<0) continue;
              minCost=Math.min(minCost,cost[house][i-1]+next);
            }

          }
      }else {  //之前有颜色
          if(houses[house]==pre){
              minCost=helper(m,n,house+1,houses,pre,target,cost);
          }else {
             minCost=helper(m,n,house+1,houses,houses[house],target-1,cost);
          }
      }
if(minCost==Integer.MAX_VALUE) return -1;
if(minCost==-1) return -1;
dp[house][target]=minCost;
     return minCost;
        }*/

        //直接动态规划
        public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
            int[][][] dp = new int[m][n + 1][target + 1];
            int max_v=100000000;
            for (int[][] ints : dp) {
                for (int[] anInt : ints) Arrays.fill(anInt, max_v);
            }
            if (houses[0] != 0) dp[0][houses[0]][1] = 0;
            else for (int i = 1; i <= n; i++) dp[0][i][1] = cost[0][i - 1];
            for (int i = 1; i < m; i++) {
                //未上过色
                if (houses[i] == 0) {
                    //i号房子颜色为j1，i-1号房子颜色为j2
                    for (int j1 = 1; j1 <= n; j1++) {
                        for (int k = 1; k <= target; k++) {
                            for (int j2 = 1; j2 <= n; j2++) {
                                //颜色相等 则k不用变  不等则用 k-1
                                dp[i][j1][k] = Math.min(dp[i][j1][k], dp[i - 1][j2][j1 == j2 ? k : k - 1] + cost[i][j1 - 1]);
                            }
                        }
                    }
                    //上过色
                } else {
                    int j1 = houses[i]; //和上面相比 j1就是固定了
                    for (int k = 1; k <= target; k++) {
                        for (int j2 = 1; j2 <= n; j2++) {
                            dp[i][j1][k] = Math.min(dp[i][j1][k], dp[i - 1][j2][j1 == j2 ? k : k - 1]);
                        }
                    }
                }
            }
            int res = max_v;
            //遍历找出结果
            for (int i = 1; i <= n; i++) res = Math.min(res, dp[m - 1][i][target]);
            return res == max_v ? -1 : res;
        }
  /*  public static void main(String[] args) {
        minCost(new int[]{0,2,1},new int[][]{
                {1,10},{10,1},{10,1}
        },3,2,2);
    }*/
}
