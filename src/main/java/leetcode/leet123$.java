package leetcode;

public class leet123$ {
    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--29/
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int K = 2;
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
    }


/*    public int maxProfit(int[] prices) {
         if(prices.length==0) return 0;
   int [][]dp=new int[3][prices.length];
   for(int k=1;k<=2;k++){
       int min=prices[0];
       for(int i=1;i<prices.length;i++){
           min=Math.min(min,prices[i]-dp[k-1][i]);
           dp[k][i]=Math.max(dp[k][i-1],prices[i]-min);
       }
   }
   return dp[2][prices.length-1];
    }*/

   /* public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int K = 2;
        int[][] dp = new int[prices.length][K + 1];
        int min[] = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            min[i] = prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k <= K; k++) {
                min[k] = Math.min(prices[i] - dp[i][k - 1], min[k]);
                dp[i][k] = Math.max(dp[i - 1][k], prices[i] - min[k]);
            }
        }
        return dp[prices.length - 1][K];
    }*/




/*    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
       int []dp=new int[3];
      int []min=new int[3];
      for(int i=1;i<=2;i++){
          min[i]=prices[0];
      }
       for(int i=1;i<prices.length;i++){
           for(int k=1;k<=2;k++){
               min[k]=Math.min(min[k],prices[i]-dp[k-1]);
               dp[k]=Math.max(dp[k],prices[i]-min[k]);
           }
       }
       return dp[2];
    }*/
//直接换成常数
/*    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int dp1 = 0;
        int dp2 = 0;
        int min1 = prices[0];
        int min2 = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min1 = Math.min(prices[i] - 0, min1);
            dp1 = Math.max(dp1, prices[i] - min1);

            min2 = Math.min(prices[i] - dp1, min2);
            dp2 = Math.max(dp2, prices[i] - min2);
        }
        return dp2;
    }*/
/*    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int s1=-prices[0],s2=Integer.MIN_VALUE,s3=Integer.MIN_VALUE,s4=Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            s1=Math.max(s1,-prices[i]); //买入价格更低的股票
            s2=Math.max(s2,s1+prices[i]);//卖出当前股票或不操作
            s3=Math.max(s3,s2-prices[i]);//第二次买入或不操作
            s4=Math.max(s4,s3+prices[i]);//第二次卖出，或者不操作
        }
        return Math.max(0,s4);
    }*/
}
