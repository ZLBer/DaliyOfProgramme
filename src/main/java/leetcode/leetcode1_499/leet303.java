package leetcode.leetcode1_499;

public class leet303 {
  /*  class NumArray {
     int []array;
        public NumArray(int[] nums) {
           array=nums;
        }

        public int sumRange(int i, int j) {
         int sum=0;
            while (i<=j){
                 sum+=array[i++];
         }
            return sum;
        }
    }*/


    class NumArray {
        int [] preSum;
        public NumArray(int[] nums) {
            preSum=new int[nums.length+1];
              int sum=0;
              preSum[0]=0;
            for(int i=0;i<nums.length;i++){
               sum+=nums[i];
               preSum[i+1]=sum;
            }
        }

        public int sumRange(int i, int j) {
            return preSum[j+1]-preSum[i];
        }
    }
}
