package leetcode.leetcode1_499;

import java.util.Arrays;

/**
 * Created by libin on 2019/3/7.
 */
public class leet322$ {
    // DP好难啊啊啊啊啊啊啊啊啊啊
    //自己的垃圾DP   用了二维矩阵
/*   static public int coinChange(int[] coins, int amount) {
      int dp[][]=new int[coins.length+1][amount+1];
      dp[0][0]=0;
      for(int i=1;i<amount+1;i++){
          dp[0][i]=amount+1;
      }


      for(int i=1;i<coins.length+1;i++){
          for(int j=1;j<amount+1;j++){
              dp[i][j]=dp[i-1][j];
              if(j>=coins[i-1]){
                  dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
              }
          }

      }
      return dp[coins.length][amount]==(amount+1)?-1:dp[coins.length][amount];
    }*/
  //看看人家的DP！！！ 太巧妙了！！！ 一维数组就可以，且跳过
  /* static public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }

        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
*/
    //DP
   /*     public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
*/


   //2020/03/08 这种题已经可以拿起来就做了   证明了刷题是有用的
    public int coinChange(int[] coins, int amount) {
     int[]dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
     for(int i=1;i<=amount;i++){
         for (int coin : coins) {
             if(i-coin>=0&&dp[i-coin]!= Integer.MAX_VALUE) {
                 dp[i]=Math.min(dp[i],dp[i-coin]+1);
             }
         }
     }
     return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
    public static void main(String[] args) {

        //coinChange(new  int[]{1,2,5},11);
    }

}
