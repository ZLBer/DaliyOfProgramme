package leetcode.Array;

import java.util.Arrays;

/**
 * Created by libin on 2017/10/13.
 */
public class Shortest_Unsorted_Continuous_Subarray {
    public int findUnsortedSubarray(int[] nums) {
    int []copy=nums.clone();
    int length=0;
        Arrays.sort(copy);
        int i;
   for(i=0;i<copy.length;i++){
       if(nums[i]==copy[i]) length++;
   else  break;
   }
   for(int j=copy.length-1;j>i;j--){
       if(nums[j]==copy[j]) length++;
   else break;
   }
   return nums.length-length;
    }
}
