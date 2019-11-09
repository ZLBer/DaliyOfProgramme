package leetcode;


import java.util.HashMap;
import java.util.Map;

public class leet560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int res=0;
        for (int i = 0; i < nums.length; i++) {
             sum+=nums[i];
             if(sum==k) res++;
             if(map.containsKey(sum-k)) res+=map.get(sum-k);
             map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
