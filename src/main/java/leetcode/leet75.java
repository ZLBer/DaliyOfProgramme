package leetcode;

public class leet75 {
   /* public void sortColors(int[] nums) {
        //斗个机灵  作弊
        Arrays.sort(nums);
    }*/
   //典型的双指针问题  首尾各一个指针
    public void sortColors(int[] nums) {
         int left=0,right=nums.length-1;
         int i=0;
        while (i<=right){
            if(nums[i]==0){
                nums[i]=nums[left];
                nums[left++]=0;i++;
            }else if(nums[i]==2){
                nums[i]=nums[right];
                nums[right--]=2;

            }else {
                i++;
            }

        }
    }

}
