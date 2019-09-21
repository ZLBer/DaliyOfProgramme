package leetcode.leetcode500_999;

import java.util.Arrays;

/**
 * Created by libin on 2018/12/29.
 */
public class leet611 {
  static   public int triangleNumber(int[] nums) {
        int count=0;
        Arrays.sort(nums);
        for(int m=0;m<nums.length;m++){
          //  System.out.println("m====="+m);
            if (nums[m]==0) continue;
           for(int i=m+1,j=m+2;i<nums.length;){;
               if(j<nums.length&&nums[m]+nums[i]>nums[j]) {
                   j++;
                 //  System.out.println(m + "  " + i + "   " + j);
               }else {
                 count+=j-i-1;
                 i++;
                 //  System.out.println(m+ "  "+i+"   "+j);
               }
           }

            }
return count;

    }

    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2,2,3,4}));
    }
}
