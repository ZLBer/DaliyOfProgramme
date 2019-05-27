package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leet1049$ {
    //DP
/*   static public int lastStoneWeightII(int[] stones) {
        boolean[] dp = new boolean[1501];
        dp[0] = true;
        int sumA = 0, res = 100;
        for (int a : stones) {
            sumA += a;
            for (int i = 1500; i >= a; --i)
                dp[i] |= dp[i - a];
        }
        for (int i = sumA / 2; i > 0; --i)
            if (dp[i]) return sumA - i - i;
        return 0;
    }*/


//很好理解的一种做法
 //直接用遍历做 把所有的情况都遍历一遍
    public int lastStoneWeightII(int[] stones) {
        Set<Integer> set = new HashSet<>();
        set.add(stones[0]);
        set.add(-stones[0]);
        for(int i=1;i<stones.length;i++){
            Set<Integer> set2 = new HashSet<>();
            for(int item : set){
                set2.add(item + stones[i]);
                set2.add(item - stones[i]);
            }
            set = set2;
        }
        int min = Integer.MAX_VALUE;
        for(int item : set) min = Math.min(Math.abs(item), min);
        return min;
    }
  /*  public static void main(String[] args) {
   lastStoneWeightII(new int[]{2,7,4,1,8,1});
    }*/
}
