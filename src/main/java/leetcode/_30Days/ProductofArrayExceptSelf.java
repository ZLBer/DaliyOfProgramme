package leetcode._30Days;

public class ProductofArrayExceptSelf {

    //mine 辣鸡的做法
 /*   public int[] productExceptSelf(int[] nums) {
        int product=1;
        int count0=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) count0++;
            else product*=nums[i];
        }

        if(count0>=2){
            for(int i=0;i<nums.length;i++) {
                nums[i]=0;
            }
        }
        else {
            for(int i=0;i<nums.length;i++) {
              if(nums[i]==0){
                  nums[i]=product;;
              }else if(count0==1){
                  nums[i]=0;
              }else {
                  nums[i]=product/nums[i];
              }
            }
        }

        return nums;
    }*/


    //分左右两部分 nice
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i]=res[i-1]*nums[i];
        }

        int right=1;
        for (int i = nums.length - 1; i > 0; i--) {
            res[i]=res[i-1]*right;
            right*=nums[i];
        }
        res[0]=right;

        return res;
    }
}
