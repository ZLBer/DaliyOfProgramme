package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by libin on 2019/1/28.
 */
public class leet983$ {

    //错误的答案  思路错了直接gg

  /*  static public int mincostTickets(int[] days, int[] costs) {

        int cost = 0;
        //只要多于这些天买周票就省钱
        int week = costs[1] / costs[0] + 1;

        int month = costs[2] / costs[0] + 1;
        int i = 0;
        while (i < days.length) {
            //  System.out.println(i);
            int begin = days[i];
            int end = begin + 29;
            //买月票
            if (i + month - 1 < days.length && days[i + month - 1] <= end) {
                i += month;
                while (i < days.length && days[i] <= end) i++;

                cost += costs[2];
                // System.out.println(cost);

            } else {
                //买月票
                end = begin + 6;
                if (i + week - 1 < days.length && days[i + week - 1] <= end) {
                    //  while (days[i++]<=end) ;
                    while (i < days.length && days[i] <= end) i++;

                    cost += costs[1];
                  //  System.out.println(cost);
                } else {
                    //买天票
                    i++;
                    cost += costs[0];
              //      System.out.println(cost);
                }


            }
        }
        return cost;
    }*/



  //创建虚拟的365天
/* static public int mincostTickets(int[] days, int[] costs) {
      boolean[] dayIncluded = new boolean[366];
      for (int day : days) {
          dayIncluded[day] = true;
      }
      int[] minCost = new int[366];
      minCost[0] = 0;
      for (int day = 1; day <= 365; ++day) {
         //If no trip on day i, then minCost(i) = minCost(i-1).
          if (!dayIncluded[day]) {
              minCost[day] = minCost[day-1];
              continue;
          }
          int min;
          //每一个旅行日都用三种方式比较最小值
          min = minCost[day-1] + costs[0];
          min =Math.min(min, minCost[Math.max(0, day-7)] + costs[1]);
          min = Math.min(min, minCost[Math.max(0, day-30)] + costs[2]);
          minCost[day] = min;
      }

      return minCost[365];

  }*/


  //dp(i)=min(dp(i+1)+costs[0],dp(i+7)+costs[1],dp(i+30)+costs[2])
//相当于从后往前搜索  O(365)
 /*   int[] costs;
    Integer[] memo;
    Set<Integer> dayset;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        dayset = new HashSet();
        for (int d: days) dayset.add(d);

        return dp(1);
    }

    public int dp(int i) {
        if (i > 365)
            return 0;
        if (memo[i] != null)
            return memo[i];

        int ans;
        //这一天旅行
        if (dayset.contains(i)) {
            ans = Math.min(dp(i+1) + costs[0],
                    dp(i+7) + costs[1]);
            ans = Math.min(ans, dp(i+30) + costs[2]);
        } else { //这一天不旅行，则继续往下搜索
            ans = dp(i+1);
        }
  //记录花费
        memo[i] = ans;
        return ans;
    }*/



  //O(N)
    int[] days, costs;
    Integer[] memo;
    int[] durations = new int[]{1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[days.length];

        return dp(0);
    }

    public int dp(int i) {
        if (i >= days.length)
            return 0;
        if (memo[i] != null)
            return memo[i];

        int ans = Integer.MAX_VALUE;
        int j = i;
        for (int k = 0; k < 3; ++k) {
            while (j < days.length && days[j] < days[i] + durations[k])
                j++;
            ans = Math.min(ans, dp(j) + costs[k]);
        }

        memo[i] = ans;
        return ans;
    }
    public static void main(String[] args) {
      //  mincostTickets(new int[]{1, 4, 6, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 27, 28}, new int[]{3, 13, 45});
    }

}
