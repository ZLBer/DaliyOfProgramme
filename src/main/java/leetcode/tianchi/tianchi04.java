package leetcode.tianchi;

import java.util.Arrays;

public class tianchi04 {
    public long MaximumProduct(int[] nums) {
        Arrays.sort(nums);
       long a=((long)nums[0])*nums[1]*nums[nums.length-1];
      long b=((long)nums[nums.length-1])*nums[nums.length-2]*nums[nums.length-3];
      return Math.max(a,b);
    }
}
