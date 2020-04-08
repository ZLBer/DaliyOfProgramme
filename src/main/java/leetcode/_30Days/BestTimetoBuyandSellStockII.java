package leetcode._30Days;

public class BestTimetoBuyandSellStockII {

    //mine
 /*   public int maxProfit(int[] prices) {
   int[]dp=new int[prices.length+1];
   int res=0;
        for (int i = 0; i < prices.length; i++) {
            for(int j=i;j>=0;j--){
                int val=prices[i]-prices[j];
                if(val<0) continue;
                dp[i+1]=Math.max(dp[i+1],dp[j]+val);
            }
            res=Math.max(res,dp[i+1]);
        }
        return res;
    }*/

    //mine 尝试一下别的最近下降点
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int begin=prices[0];
        int end=prices[0];
        int profit=0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                end=prices[i];
            }
            else {
                profit+=(end-begin);
                end=begin=prices[i];
            }
        }

        return profit+(end-begin);
    }
}
