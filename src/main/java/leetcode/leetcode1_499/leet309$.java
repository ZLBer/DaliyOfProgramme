package leetcode.leetcode1_499;

public class leet309$ {
    //很复杂的DP
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
      int[] stateA=new int[prices.length];
      int[] stateB=new int[prices.length];
      int[] stateC=new int[prices.length];
      stateA[0]=-prices[0];
      stateB[0]=Integer.MIN_VALUE;
      stateC[0]=0;
      for(int i=1;i<prices.length;i++){
         stateA[i]=Math.max(stateA[i-1],stateC[i-1]-prices[i]);
         stateB[i]=stateA[i-1]+prices[i];
         stateC[i]=Math.max(stateC[i-1],stateB[i-1]);
      }
      return Math.max(stateB[prices.length-1],stateC[prices.length-1]);
    }


    //  减少空间 只用int[2]
 /*   public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[] s0 = new int[2];
        int[] s1 = new int[2];
        int[] s2 = new int[2];
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; ++i) {
            s0[i % 2] = Math.max(s0[(i - 1) % 2], s2[(i - 1) % 2]);
            s1[i % 2] = Math.max(s1[(i - 1) % 2], s0[(i - 1) % 2] - prices[i]);
            s2[i % 2] = s1[(i - 1) % 2] + prices[i];
        }

        return Math.max(s0[(prices.length - 1) % 2], s2[(prices.length - 1) % 2]);
    }*/
}
