package leetcode;

public class leet714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + prices[i] - fee);
        }
        return dp[prices.length - 1][1];
    }


    //贪心真的不好想啊
  /*  public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];  //这里可以看成  我可以继续延续这次交易，即不用增加fee
            }
          //  System.out.println(buy);
        }
        return profit;
    }
*/

    public static void main(String[] args) {
       // maxProfit(new int[]{2,5,6,1,2},2);
    }
}
