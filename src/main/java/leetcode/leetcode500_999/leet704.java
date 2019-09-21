package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/3/4.
 */
public class leet704 {

    public int search(int[] nums, int target) {

        int low=0;
        int high=nums.length-1;
        while (low<=high){
   int middle=(low+high)/2;
   if(nums[middle]==target) return middle;
   else if(nums[middle]>target)  high=middle-1;
   else low=middle+1;
        }

        return -1;
    }


}
