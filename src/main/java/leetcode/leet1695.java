package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leet1695 {

    //mine 其实map是没必要的哦  因为窗口内不可能存在重复，而下一个主语要
/*    public int maximumUniqueSubarray(int[] nums) {
        int left = 0, right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            while (map.getOrDefault(nums[i], 0) > 0) {
                map.put(nums[left], map.get(nums[left]) - 1);
                sum -= nums[left];
                left++;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
            res = Math.max(res, sum);

        }
        return res;
    }*/

  //改成set
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, sum = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!set.isEmpty()&&set.contains(nums[i])) {
                sum -= nums[start];
                set.remove(nums[start]);
                start++;
            }
            set.add(nums[i]);
            sum += nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }


}
