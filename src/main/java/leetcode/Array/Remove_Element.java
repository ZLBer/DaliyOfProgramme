package leetcode.Array;

/**
 * Created by libin on 2017/10/8.
 */
public class Remove_Element {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i=0;i<nums.length;i++)
            if(nums[i]==val) count++;
        int begin = 0;
        int end = nums.length-1;
        for (; begin <= end; begin++) {
            if (nums[begin] == val)
                for (; end >= begin; end--) {
                    if (nums[end] != val) {
                        int a = nums[begin];
                        nums[begin] = nums[end];
                        nums[end] = a;
                        break;
                    }
                }
        }
        return 0;
    }
}
