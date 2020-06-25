package leetcode._4_30Days;

public class MoveZeroes {
    //mine  没保持相对顺序
 /*   public void moveZeroes(int[] nums) {
        int index=nums.length-1;
        for (int i = 0; i <=index; i++) {
            if(nums[i]==0){
                swap(i,index--,nums);
                i--;
            }
        }
    }
*/
    void swap(int i,int j,int []nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


//mine  反过来移动不为0的就行了
    public void moveZeroes(int[] nums) {
        int index=0;
        for (int i = 0; i <nums.length; i++) {
            if(nums[i]!=0){
                swap(i,index++,nums);
            }
        }
    }
}
