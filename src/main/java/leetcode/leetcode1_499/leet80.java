package leetcode.leetcode1_499;

public class leet80 {

    //mine  本以为就很简单了
    public int removeDuplicates(int[] nums) {
    int index=2;
        for (int i = 2; i < nums.length; i++) {
            if(index!=i) nums[index]=nums[i];
            if(nums[index]==nums[index-2]){
                continue;
            }else {
                index++;

            }
        }
        return index;
    }


 /*   //别人的更简单版本  思路是一样的
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }*/

    public static void main(String[] args) {
        leet80 l=new leet80();
        l.removeDuplicates(new  int[]{0,0,1,1,1,1,2,3,3});
    }
}
