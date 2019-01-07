package leetcode;

/**
 * Created by libin on 2017/9/17.
 */
public class leet136 {
    public int singleNumber(int[] nums) {
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]&&i!=j)
                    break;
                if(j==nums.length-1) return nums[i];
            }
            return 0;
    }
}
