package leetcode;

import java.util.Arrays;

public class leet1658 {
    //contest
/*    public int minOperations(int[] nums, int x) {
        int[] pre=new int[nums.length+1];
        pre[0]=0;
        Map<Integer,Integer> map=new HashMap<>();
       map.put(0,0);
       long s=0;
        for (int i = 0; i < nums.length; i++) {
            s+=nums[i];
            pre[i+1]=nums[i]+pre[i];
          if(pre[i+1]>x)break;
          map.put(pre[i+1],i+1);

        }
        if(s<x) return  -1;

        int sum=0;

        int res=Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(sum>x) break;
            if(map.containsKey(x-sum)) {

              //  if(map.get(x-sum)>=i) break;
                //System.out.println(i+" "+map.get(x-sum));
               res=Math.min(res,nums.length-i-1+map.get(x-sum));
            }
             sum+=nums[i];
        }

        return res==Integer.MAX_VALUE?-1:res;
    }*/

  //滑动窗口求中间的一段
    public int minOperations(int[] nums, int x) {
        // 使用滑动窗口找中间最长的片段使得sum(片段)=sum(nums)-x
        int maxPart = -1;
        int sum = Arrays.stream(nums).sum();
        int currentSum = 0;
        int left = 0;
        int right = 0;
        while (left < nums.length) {
            // 如果右边未到尽头，不断先向右探测片段，如果大于目标sum-x则左边移动直到结束
            if (right < nums.length) {
                currentSum += nums[right++];
            }
            while (currentSum > sum - x && left < nums.length) {
                currentSum -= nums[left++];
            }
            if (currentSum == sum - x) {
                maxPart = Math.max(maxPart, right - left);
            }
            if (right == nums.length) {
                left++;
            }
        }
        return maxPart == -1 ? -1 : nums.length - maxPart;
    }
}
