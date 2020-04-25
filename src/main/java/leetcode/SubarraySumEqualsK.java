package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    //滑动窗口失效  只能针对整数的情况
/*
    public int subarraySum(int[] nums, int k) {
 int sum=0,i=0,left=0,res=0;
 while (i<nums.length){
     sum+=nums[i];

     if(sum==k) res++;
     while (left<=i&&sum>=k){
         sum-=(nums[left++]);
         if(sum==k&&left<=i) res++;
     }
  i++;
 }

        while (left<nums.length){
            sum-=(nums[left++]);
            if(sum==k&&left<nums.length) res++;
        }
 return res;
    }
*/

//前n项和
  /*  public int subarraySum(int[] nums, int k) {
  int []presum=new int[nums.length+1];
       presum[0]=0;
        for (int i =0; i < nums.length; i++) {
            presum[i+1]=presum[i]+nums[i];
          //  System.out.println(presum[i+1]);
        }

        int res=0;
        ;
        for(int i=0;i<=nums.length;i++){
            for(int j=i+1;j<=nums.length;j++){
               // System.out.println(presum[j]+" "+presum[i]);
                  if(presum[j]-presum[i]==k) res++;
            }
        }
        return res;
    }*/


    //前n项和+hash
    public int subarraySum(int[] nums,int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
