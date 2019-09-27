package leetcode;

public class leet209 {
/* static    public int minSubArrayLen(int s, int[] nums) {
        int result=Integer.MAX_VALUE;
     for(int i=0;i<nums.length;i++){
         int sum=0;
         for(int j=i;j<nums.length;j++){
          sum+=nums[j];
          if(sum>=s) {
        result=  Math.min(result,j-i+1);
              break;
          }
         }

     }
     return result==Integer.MAX_VALUE?0:result;
    }*/


//双指针
    static   public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0) return 0;
        int result=Integer.MAX_VALUE;
        int i=0,j=0,sum=0;
        while (j<nums.length){
          sum+=nums[j++];
          while (sum>=s){
            result=Math.min(result,j-i);
            sum-=nums[i++];
          }
        }
        return result==Integer.MAX_VALUE?0:result;
    }

    public static void main(String[] args) {
     minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }
}
