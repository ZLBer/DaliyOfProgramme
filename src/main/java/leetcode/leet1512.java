package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet1512 {
    public int numIdenticalPairs(int[] nums) {
      Map<Integer,Integer> map=new HashMap<>();
      int res=0;
      for (int i = 0; i < nums.length; i++) {
            int v=map.getOrDefault(nums[i],0);
            res+=v;
            map.put(nums[i],v);
        }
     return res;
    }
}
