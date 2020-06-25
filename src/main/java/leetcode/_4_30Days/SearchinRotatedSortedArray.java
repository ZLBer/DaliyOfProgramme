package leetcode._4_30Days;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int left=0,right=nums.length-1;
        while (left<right){
            int mid=(left+right)/2;

            if(nums[left]<=nums[mid]){
                if(target>=nums[left]&&target<=nums[mid]){
                    right=mid;
                }else {
                    left=mid+1;
                }
            }else {
                if(target>=nums[mid]&&target<=nums[right]){
                    left=mid;
                }else {
                    right=mid-1;
                }
            }
        }
        return nums[left]==target?left:-1;
    }
}
