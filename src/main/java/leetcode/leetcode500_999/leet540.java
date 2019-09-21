package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/1/21.
 */
public class leet540 {
 // 但不是题目要求的 logN
  /*  public int singleNonDuplicate(int[] nums) {
       for(int i=1;i<nums.length;i+=2){
           if(nums[i-1]==nums[i]) continue;
           else return nums[i-1];
       }
       return nums[nums.length-1];
    }*/



  //O(N) 的方法  类似于二叉搜索
    public static int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
                   //保证左边有偶数个数字
            int mid = (start + end) / 2;
            if (mid % 2 == 1) mid--;
             //若该数字与后一个数字不成对，则多出的数字一定在前面
            if (nums[mid] != nums[mid + 1]) end = mid;
            //否则就在后半
            else start = mid + 2;
        }
        //最后一定出现在start 位置
        return nums[start];
    }

    public static void main(String[] args) {
        singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8});
    }
}
