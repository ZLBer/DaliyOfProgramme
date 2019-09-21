package leetcode.leetcode1_499;

/**
 * Created by libin on 2017/9/17.
 */
public class leet485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int begin=0;
        int length=0;
        for(int i=0;i<nums.length;i++) {
            if (nums[i] == 0) {
                if (i - begin + 1 > length) length = i - begin ;
                begin = i+1;
            }
            if(nums[i] == 1&&i==nums.length- 1){
                if (i - begin + 1 > length) length = i - begin+1 ;
                begin = i+1;
            }

        }
            return length;
    }
}
