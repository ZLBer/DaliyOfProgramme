package leetcode;

public class leet153 {

    //mine  二分
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[right] >= nums[left]) { //已经构成整体有序
                return nums[left];
            }
           else if (nums[mid] >= nums[left]) { //左边有序，可以删除
                left = mid + 1;
            } else if (nums[right] >= nums[mid]) { //右边有序，可以删除
                right = mid;
            }
        }
        return -1;
    }

    //更简单的方式
/*    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        while (left<right){
            int mid=(left+right)/2;

            if(nums[mid]>nums[right]){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return nums[left];
    }*/
}
