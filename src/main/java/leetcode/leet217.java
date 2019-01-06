package leetcode;

import java.util.Arrays;

/**
 * Created by libin on 2018/12/31.
 */
public class leet217 {
    static public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);
        for(int ind = 1; ind < nums.length; ind++) {
            if(nums[ind] == nums[ind - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,1}));
    }
}
