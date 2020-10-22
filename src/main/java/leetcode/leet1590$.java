package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet1590$ {

    //主要是要明白求余的含义
    // (prex[i] - prex[j]) % p = prex[n] % p 时，可满足题目条件
    //而上面的式子又可以化简   prex[j] = (prex[i] - prex[n] + p) % p.
    //所以只要求存在prex[j]就可以了
   static public int minSubarray(int[] nums, int p) {
     int []sum=new int[nums.length+1];
     Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
           sum[i+1]=(sum[i]+nums[i])%p;
        }
      long max=sum[sum.length-1];
        if(max%p==0) return 0;
       map.put(0,-1);
       int n=nums.length;
        int res=Integer.MAX_VALUE;
        for (int i = 1; i < sum.length; i++) {
            int pre=(int)(sum[i]-sum[n]+p)%p;
         if(map.containsKey(pre)){
             res=Math.min(res,i-map.get(pre));
       }
         map.put(sum[i],i);
        }
        return res>=n?-1:res;
    }
    public static void main(String[] args) {
        minSubarray(new int[]{3,1,4,2},6);
    }
}
