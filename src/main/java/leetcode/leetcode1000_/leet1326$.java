package leetcode.leetcode1000_;

import java.util.Arrays;
import java.util.Comparator;

public class leet1326$ {
    //贪心法
    public int minTaps(int n, int[] ranges) {
        int[][] rg = new int[n + 1][2];
        for (int i = 0; i <= n; ++i)
            rg[i] = new int[]{i - ranges[i], i + ranges[i]};
        Arrays.sort(rg, Comparator.comparing(r -> r[0]));
        int ans = 0;
        for (int i = 0, start = 0, end = 0; start < n && i <= n; start = end, ++ans) {  //更新start 并把结果+1
            while (i <= n && rg[i][0] <= start) //表示这一段可以吧start 覆盖
                end = Math.max(end, rg[i++][1]); //找到最大的end
            if (end <= start)  //若无法更新，则无法覆盖
                return -1;
        }
        return ans;
    }


    //自己写一遍
   /* public int minTaps(int n, int[] ranges) {
      int[][]rgs=new int[n+1][2];
        for (int i = 0; i < ranges.length; i++) {
            rgs[i]=new int[]{i-ranges[i],i+ranges[i]};
        }
        Arrays.sort(rgs,(int []a,int []b)->a[0]-b[0]);

        int ans=0;
        for(int i=0,start=0,end=0;i<=n&&start<n;start=end,ans++){
            while (i<=n&&rgs[i][0]<=start){
                end=Math.maxSum(end,rgs[i++][1]);
            }
            if(start>=end)
                return -1;
        }
        return ans;
    }*/

   //dp
 /*   public int minTaps(int n, int[] A) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 2);
        dp[0] = 0;//0 初始为0
        for (int i = 0; i <= n; ++i)
            for (int j = Math.maxSum(i - A[i] + 1, 0); j <= Math.min(i + A[i], n); ++j)
                dp[j] = Math.min(dp[j], dp[Math.maxSum(0, i - A[i])] + 1);
        return dp[n]  < n + 2 ? dp[n] : -1;
    }*/
}
