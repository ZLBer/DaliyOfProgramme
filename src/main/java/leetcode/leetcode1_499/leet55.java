package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/3/3.
 */
public class leet55 {
    //mine  强行遍历
    public boolean canJump(int[] nums) {
      boolean []canArrived=new boolean[nums.length];
    canArrived[0]=true;

     for(int i=0;i<nums.length;i++){
      if(canArrived[i]){
          for(int j=i+1;j<=i+nums[i]&&j<nums.length;j++){
              canArrived[j]=true;
          }
      }
     }

     return canArrived[nums.length-1];
    }

    //贪心法
  //nice solution！！！！niub！！
 /*   public boolean canJump(int[] A) {
        int max = 0;
        for(int i=0;i<A.length;i++){
            if(i>max) {return false;}
            max = Math.max(A[i]+i,max);
        }
        return true;
    }*/
 //回溯法   Time Limit Exceeded
   /* public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }*/


   //DP

   /* enum Index {
        GOOD, BAD, UNKNOWN
    }

    public class Solution {
        Index[] memo;

        public boolean canJumpFromPosition(int position, int[] nums) {
            if (memo[position] != Index.UNKNOWN) {
                return memo[position] == Index.GOOD ? true : false;
            }

            int furthestJump = Math.min(position + nums[position], nums.length - 1);
            for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
                if (canJumpFromPosition(nextPosition, nums)) {
                    memo[position] = Index.GOOD;
                    return true;
                }
            }

            memo[position] = Index.BAD;
            return false;
        }

        public boolean canJump(int[] nums) {
            memo = new Index[nums.length];
            for (int i = 0; i < memo.length; i++) {
                memo[i] = Index.UNKNOWN;
            }
            memo[memo.length - 1] = Index.GOOD;
            return canJumpFromPosition(0, nums);
        }
    }*/
}
