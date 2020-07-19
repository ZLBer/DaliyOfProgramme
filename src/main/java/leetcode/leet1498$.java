package leetcode;

import java.util.Arrays;

public class leet1498$ {
    public int numSubseq(int[] nums, int target) {
      int left=0,right=nums.length-1,res=0;
      int mod=100_000_0007;
        Arrays.sort(nums);
     int []pow=new int[nums.length];
     pow[0]=1;
     for (int i = 1; i < nums.length; i++) {
           pow[i]=pow[i-1]*2%mod;
        }
     while (left<=right){
         if(nums[left]+nums[right]>target){
             right--;
         }
         else {
            res=(res+pow[right-left])%mod;
            left++;
         }
     }
     return res;
    }
}
