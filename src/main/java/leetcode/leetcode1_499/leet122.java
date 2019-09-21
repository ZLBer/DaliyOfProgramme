package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/1/3.
 */
public class leet122 {
//   static public int maxProfit(int[] prices) {
//       if(prices.length<=1) return 0;
//        int profit=0;
//        int buy=0;
//  for (int i=1;i<prices.length;i++){
//if(prices[i]>prices[i-1]) continue;
//else {
//    profit+=(prices[i-1]-prices[buy]);
//    System.out.println(profit);
//    buy=i;
//}
//
//  }
//       profit+=(prices[prices.length-1]-prices[buy]);
//return profit;
//    }
    //额 ，joking

   static public int maxProfit(int[] prices) {
        int totalProfit = 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i] > prices[i-1]) {
                totalProfit = totalProfit + (prices[i] - prices[i-1]);
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    }
}
