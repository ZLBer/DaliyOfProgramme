package leetcode._30Days;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
/*   static public int findMaxLength(int[] nums) {

    }
    int helper(int []nums,int l,int r,int zero,int one){
       if(zero==one) return r-1+1;
       if(zero>one){
          int left=0,right=0;
           if(nums[l]==0) left=helper(nums,l+1,r,zero-1,one);
           if(nums[r]==0)  right=helper(nums,l,r-1,zero,one-1);
       }else {
           int left=0,right=0;
           if(nums[l]==1) left=helper(nums,l+1,r,zero-1,one);
           if(nums[r]==1)  right=helper(nums,l,r-1,zero,one-1);
       }
    }
    public static void main(String[] args) {
        findMaxLength(new int[]{1,0,1,0});
    }*/


//TLE BIT
/*    public int findMaxLength(int[] nums) {
    int []bit=new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1) update(bit,i+1,1);
        }
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j > 0; j--) {
               int zero=getSum(bit,j+1)-getSum(bit,i);
               int one=j-i+1-zero;
               if(zero==one) {
                res=Math.max(zero*2,res);
                break;
               }
            }
        }
        return res;
    }
    void update(int[] bit, int i, int val) {
        while (i < bit.length) {
            bit[i] += val;
            i += i & (-i);
        }
    }

    int getSum(int[] bit, int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & (-i);
        }
        return sum;
    }*/

//TLE preSum
 /*   public int findMaxLength(int[] nums) {
         int[]preSum=new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1) preSum[i+1]=preSum[i]+1;
            else preSum[i+1]=preSum[i];
        }

        int res=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j > 0; j--) {
                int one=preSum[j+1]-preSum[i];
                int zero=j-i+1-one;
                if(zero==one) {
                    res=Math.max(zero*2,res);
                    break;
                }
            }
        }
        return res;
    }*/


    //学会合理的转化问题是多么重要啊
    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0) nums[i]=-1;
        }
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);

        int sum=0;
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(map.containsKey(sum)){
              res=Math.max(res,i-map.get(sum));
            }else {
                map.put(sum,i);
            }
        }
        return res;
    }
}
