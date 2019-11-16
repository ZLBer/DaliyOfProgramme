package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leet128$ {
 /*   public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) continue;
            else {

                int left=map.containsKey(nums[i]-1)?map.get(nums[i]-1):0;
                int right=map.containsKey(nums[i]+1)?map.get(nums[i]+1):0;

                int sum=left+right+1;
                max=Math.max(sum,max);
                map.put(nums[i],sum);

                map.put(nums[i]-left,sum);
                map.put(nums[i]+right,sum);
            }
        }
        return max;
    }
*/


    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            int x=nums[i];
            if(!set.contains(x-1)){
                int y=1;
                while (set.contains(x+1)){
                    x++;y++;
                }
                res=Math.max(y,res);

            }
        }
        return res;
    }
}
