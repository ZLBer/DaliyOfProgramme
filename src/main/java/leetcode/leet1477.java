package leetcode;

import java.util.Arrays;

public class leet1477 {
/*    public int minSumOfLengths(int[] arr, int target) {
       int []dp=new int[arr.length];
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(0,-1);
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
          if(map.containsKey(sum-target)){
           dp[i]=i-map.get(sum-target);
          }

         if(i>0){
             if(dp[i]==0)dp[i]=dp[i-1];
            else if(dp[i-1]!=0) dp[i]=Math.min(dp[i],dp[i-1]);
         }
          map.put(sum,i);
        }

        int []dp2=new int[arr.length];
        map=new HashMap<>();
        map.put(0,arr.length);
        sum=0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum+=arr[i];
          if(map.containsKey(sum-target)){
              dp2[i]=map.get(sum-target)-i;
          }
            if(i<arr.length-1){
                if(dp2[i]==0)dp2[i]=dp2[i+1];
                else if(dp2[i+1]!=0) dp2[i]=Math.min(dp2[i],dp2[i+1]);
            }
          map.put(sum,i);
        }
       int res=Integer.MAX_VALUE;
        for (int i = 0; i < dp.length-1; i++) {
            if(dp[i]==0||dp2[i+1]==0) continue;
          res=Math.min(res,dp[i]+dp2[i+1]);
        }
*//*        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]+" "+dp2[i]);
        }*//*
        return res==Integer.MAX_VALUE?-1:res;
    }*/


  //和你的想法差不多  但是只需要一个map就可以了
/*
    public int minSumOfLengths(int[] arr, int target) {
        HashMap<Integer,Integer> hmap=new HashMap<>();
        int sum=0,lsize=Integer.MAX_VALUE,result=Integer.MAX_VALUE;
        hmap.put(0,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            hmap.put(sum,i); // stores key as sum upto index i, and value as i.
        }
        sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(hmap.get(sum-target)!=null){
                lsize=Math.min(lsize,i-hmap.get(sum-target));      // stores minimum length of sub-array starting with index<= i with sum target. This ensures non- overlapping property.
            }
            //hmap.get(sum+target) searches for any sub-array starting with index i+1 with sum target.
            if(hmap.get(sum+target)!=null&&lsize<Integer.MAX_VALUE){
                result=Math.min(result,hmap.get(sum+target)-i+lsize); // updates the result only if both left and right sub-array exists.
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
*/


  //滑动窗口
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int best[] = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        int sum = 0, start = 0, ans = Integer.MAX_VALUE, bestSoFar = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            while(sum > target){
                sum -= arr[start];
                start++;
            }
            if(sum == target){  //找到了一个等于target的窗口
                if(start > 0 && best[start - 1] != Integer.MAX_VALUE){
                    ans = Math.min(ans, best[start - 1] + i - start + 1);  // start左边 +start到i的长度
                }
                bestSoFar = Math.min(bestSoFar, i - start + 1);  //最优化best
            }
            best[i] = bestSoFar;  //更新best
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
