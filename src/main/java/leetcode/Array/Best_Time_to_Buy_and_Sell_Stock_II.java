package leetcode.Array;

/**
 * Created by libin on 2017/10/10.
 */
public class Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int oneMax=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]>=prices[i+1]) continue;
            for(int j=i+1;j<prices.length;j++) {
                oneMax = Math.max(oneMax, prices[j] - prices[i]);
            }
            maxProfit=Math.max(oneMax,maxProfit);
        }
        return maxProfit;
    }
}
