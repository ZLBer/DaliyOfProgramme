package leetcode.leetcode500_999;

import java.util.Arrays;

public class leet645 {
    //mine 毫无技巧可言
/*  static   public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
      int[] result=new int[2];
      int index=0;
        for (int i = 1; i < nums.length; i++) {

            if(nums[i]==nums[i-1]) {
                result[0]=nums[i];
                index=i;
                break;
            }
        }
       for(int j=0;j<index;j++){
           if(j+1!=nums[j]){
               result[1]=j+1;
               return result;
           }

       }
        int i = index;

        for (; i < nums.length; i++) {
            if(nums[i]==i+1) {
                result[1]=i-1;
                break;
            }
        }
        if(i==nums.length) result[1]=nums.length;
        return result;
    }*/

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2]; // duplicate, missing
        //For each number we found, set nums[number-1] to its negative value (<0)
        //把所有的数变负数，如果已经是负数，则说明已经存在了
        for(int i=0; i<nums.length; i++) {
            int idx = Math.abs(nums[i])-1; //since index starts from 0, and the set starts from 1
            if(nums[idx]> 0) nums[idx] = -nums[idx];
            else res[0] = idx+1; //have already been found
        }
        // At this point, only nums[missingNumber-1] > 0
        //经过上面的变换，则只有一个位置是正数
        for(int i=0; i<nums.length; i++) {
            //其实恢复是没有必要的
            if(nums[i] <0) nums[i] = -nums[i]; //restore the original values
            else res[1]=i+1;//since index starts from 0, and the set starts from 1
        }
        return res;
    }


}
