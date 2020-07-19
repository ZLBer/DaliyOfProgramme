package leetcode;

public class leet1493 {

    //mine 滑动窗口
/*    public int longestSubarray(int[] nums) {
       int left=0,right=0;
       boolean set=false;
       int res=0;
      for(;right<nums.length;right++){
         if(nums[right]==1) continue;
         else if(!set){ //没设置过
            set=true;
            continue;
         }
         else { //设置过
            res=Math.max(res,right-left-1);
            while (nums[left]==1){
                left++;
            }
            left++;

         }
      }
      res= Math.max(right-left-1,res);

      return res==nums.length?res-1:res;
    }*/
    //不用减小窗口
    public int longestSubarray(int[] nums) {
        int k=1;
        int i=0;
        int j=0;
        for ( ; j < nums.length; j++) {
            if(nums[j]==0)k--;
           if(k<0&&nums[i++]==0) k++;
        }

        return j-i-1;
    }
}
