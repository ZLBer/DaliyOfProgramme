package leetcode;

/**
 * Created by libin on 2019/1/1.
 */
public class leet26 {
  static   public int removeDuplicates(int[] nums) {

        int i=0;
        for(int j=0;j<nums.length;)

            if(nums[j]==nums[i]) j++;
        else {

            nums[++i]=nums[j++];
            }

        return i+1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int []{0,0,1,1,1,2,2,3,3,4}));
    }
}
