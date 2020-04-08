package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet1716 {
  /*  public int massage(int[] nums) {
    dfs(nums,0,0);
    return max;
    }


    int max=0;
    void dfs(int[]nums,int index,int sum){
        if(index>=nums.length) {
            max=Math.max(sum,max);
        }

        //从第i个开始继续往下找
        for(int i=index;i<nums.length;i++){
            dfs(nums,i+2,sum+nums[i]);
        }
    }*/

    public int massage(int[] nums) {
        return dfs(nums,0);
    }


    Map<Integer,Integer> map=new HashMap<>();
    int dfs(int[]nums,int index){
        if(index>=nums.length) return 0;
        if(index==nums.length-1) return nums[nums.length-1];
        if(map.containsKey(index)) return map.get(index);
        int max=0;
        for(int i=index;i<nums.length;i++){
            max=Math.max(dfs(nums,i+2)+nums[i],max);
        }
        System.out.println(max);
        map.put(index,max);
        return max;
    }


    //真正递归
/*
    public int massage(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
*/


}
