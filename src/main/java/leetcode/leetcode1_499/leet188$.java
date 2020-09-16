package leetcode.leetcode1_499;

public class leet188$ {
    //MLE
/*    public int maxProfit(int K, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        //dp表示这一天一定要卖出去
        int[][] dp = new int[prices.length][K + 1];
        for (int k = 1; k <= K; k++) {
            for (int i = 1; i < prices.length; i++) {
                int min = Integer.MAX_VALUE;
                //找出第 0 天到第 i 天 prices[buy] - dp[buy][k - 1] 的最小值
                for (int buy = 0; buy <= i; buy++) {
                    min = Math.min(prices[buy] - dp[buy][k - 1], min);
                }
                //比较不操作和选择一天买入的哪个值更大
                dp[i][k] = Math.max(dp[i - 1][k], prices[i] - min);
            }
        }
        return dp[prices.length - 1][K];
    }*/


/*    public int maxProfit(int K, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        if(K>=prices.length/2) return quickSolve(prices);
        int[] dp = new int[K + 1];
        int min[] = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            min[i] = prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k <= K; k++) {
                min[k] = Math.min(prices[i] - dp[k - 1], min[k]);
                dp[k] = Math.max(dp[k], prices[i] - min[k]);
            }
        }
        return dp[K];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }*/

  //简洁明了  老外的思维就是
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
