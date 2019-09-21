package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/1/2.
 */
public class leet746 {
    public int minCostClimbingStairs(int[] cost) {
        for(int i=2;i<cost.length;i++){
            cost[i]+=Math.min(cost[i-1],cost[i-2]);
        }
        return Math.min(cost[cost.length-1],cost[cost.length-2]);
    }
    //
//    public int minCostClimbingStairs(int[] cost) {
//        int f1 = 0, f2 = 0;
//        for (int i = cost.length - 1; i >= 0; --i) {
//            int f0 = cost[i] + Math.min(f1, f2);
//            f2 = f1;
//            f1 = f0;
//        }
//        return Math.min(f1, f2);
//    }
}
