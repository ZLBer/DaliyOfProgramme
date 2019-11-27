package leetcode.leetcode1000_;

import java.util.Arrays;

/**
 * Created by libin on 2019/4/28.
 */
public class leet1033 {

    //mine  if大法好
/*    public int[] numMovesStones(int a, int b, int c) {
       int [] sort={a,b,c};
       Arrays.sort(sort);
       int max=0,min=0;
       if(sort[1]-sort[0]==1&&sort[2]-sort[1]==1) {
           min=0;max=0;
       }else if(sort[1]-sort[0]==1){
           min=1;max=sort[2]-sort[1]-1;
       }else if(sort[2]-sort[1]==1){
           min=1;
           max=sort[1]-sort[0]-1;
       }else {
           if(sort[2]-2==sort[1]||sort[1]-sort[0]==2){
               min=1;
           }
          else min=2;

           max=(sort[2]-sort[1]-1)+(sort[1]-sort[0]-1);
       }
   return new int[]{min,max};
    }*/

     //更简洁的方法
    public int[] numMovesStones(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        int maxCount = nums[2] - nums[0] - 2;
        int minCount = 2;
        if (nums[2] - nums[1] < 3 || nums[1] - nums[0] < 3) minCount = 1;
        if (nums[2] - nums[1] == 1 && nums[1] - nums[0] == 1) minCount = 0;
        return new int[] { minCount, maxCount };
    }
}
