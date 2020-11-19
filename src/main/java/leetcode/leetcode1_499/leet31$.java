package leetcode.leetcode1_499;

public class leet31$ {

        public void nextPermutation(int[] nums) {
            int index=-1;
            int len=nums.length-1;
            int i=nums.length-1;
            while (i>0&&nums[i]<nums[i-1]){
                i--;
            }
            int mount=i;
            i--;


                int in=len;
                int pre=nums[i];
               while (in>=mount&&pre>=nums[in]){
                   in--;
               }
              index = in;

            System.out.print(index);

          if(index==-1){
                for( i=0;i<nums.length/2;i++){
                    swap(i,nums.length-1-i,nums);
                }
            }else{

            }

        }

        void swap(int i,int j,int []nums){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }


        //2020/11/10








        public class Solution {






















     // https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-powcai/
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i + 1] <= nums[i]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }
            //反转
            reverse(nums, i + 1);
        }

        private void reverse(int[] nums, int start) {
            int i = start, j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
