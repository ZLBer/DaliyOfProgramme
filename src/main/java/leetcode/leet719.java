package leetcode;

import java.util.Arrays;

public class leet719 {

    //这种逆向的二分你咋总是不会呢
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

      int low=0,high=nums[nums.length-1]-nums[0];
      while (low<high){
        int mid=(low+high)/2;
        int left=0;
        int count=0;
        for(int right=0;right<nums.length;right++){
           while (nums[right]-nums[left]>mid) left++;
           count+=(right-left);
        }
        if(count>=k){
            high=mid;
        }else {
            low=mid+1;
        }
      }
      return low;
    }
}
