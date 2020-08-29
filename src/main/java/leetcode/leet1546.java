package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet1546 {
    //mine dp+前缀和
/* static    public int maxNonOverlapping(int[] nums, int target) {
        int sum=0;
        Map<Integer, List<Integer>> map=new HashMap<>();
        int []dp=new int[nums.length+1];
        dp[0]=0;
        map.put(0,new ArrayList<>(Arrays.asList(0)));
        for (int i = 0; i < nums.length; i++) {
          sum+=nums[i];

          int exPre=sum-target;//前缀是这个就行
            System.out.println(exPre);
            dp[i+1]=dp[i];
          if(map.containsKey(exPre)){

              for (Integer integer : map.get(exPre)) {
                  dp[i+1]=Math.max(dp[i+1],dp[integer]+1);
              }
          }

            if(!map.containsKey(sum)) map.put(sum,new ArrayList<>());
            map.get(sum).add(i+1);

        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]+" ");
        }
     return dp[dp.length-1];
    }*/

// 可以贪心只保存最近出现的前缀和就行
    static    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int res = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, map.get(sum - target) + 1);
            }
            map.put(sum, res);
        }

        return res;
    }
    public static void main(String[] args) {
        maxNonOverlapping(new int[]{0,0,0},0);
    }
}
