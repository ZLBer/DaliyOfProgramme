package leetcode;

public class leet1437 {
    //mine 搞不懂这个题有啥意思
    public boolean kLengthApart(int[] nums, int k) {
      int countZero=k;
      int i=0;
      while (i<nums.length&&nums[i]!=1) i++;
        for (; i < nums.length; i++) {
            if(nums[i]==1){
               if(countZero<k) return false;
                countZero=0;
            }
          else countZero++;
        }
        return true;
    }
}
