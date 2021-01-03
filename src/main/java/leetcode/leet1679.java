package leetcode;

import java.util.Arrays;

public class leet1679 {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
      int left=0,right=nums.length-1;
      int res=0;
      while (left<right){
        if(nums[left]+nums[right]==k){
            res++;
            left++;right--;
        }else if(nums[left]+nums[right]>k){
            right--;
        }else {
            left++;
        }
      }
      return res;
    }
}
