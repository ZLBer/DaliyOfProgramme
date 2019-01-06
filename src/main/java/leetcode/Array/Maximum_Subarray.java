package leetcode.Array;

/**
 * Created by libin on 2017/10/11.
 */
public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
    int current=nums[0];
        int maxSubArray=current;
    for(int i=1;i<nums.length;i++){
      if(current>0) current+=nums[i];
      else current=nums[i];
      maxSubArray=Math.max(current,maxSubArray);
    }
    return maxSubArray;
    }
}
