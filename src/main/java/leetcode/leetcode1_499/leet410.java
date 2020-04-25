package leetcode.leetcode1_499;

public class leet410 {
    //mine  dp 这次真的是自己想的自己写的
/*
   static public int splitArray(int[] nums, int m) {
    long[][]dp=new long[m+1][nums.length+1];
       for (int i = 0; i < nums.length; i++) {
           dp[1][i+1]=dp[1][i]+nums[i];
       }
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= nums.length; j++) {
                long sum=0;
                long min=Integer.MAX_VALUE;
                for(int k=j;k>0;k--){
                    sum+=nums[k-1];
                    min=Math.min(min,Math.max(sum,dp[i-1][k-1]));
                }
                dp[i][j]=min;
            }  
        }

        return (int)dp[m][nums.length];
    }
*/

    //mine  优化一下dp
/*    static public int splitArray(int[] nums, int m) {
        long[][]dp=new long[m+1][nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            dp[1][i+1]=dp[1][i]+nums[i];
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= nums.length; j++) {
                long min=Integer.MAX_VALUE;
                for(int k=j;k>0;k--){
                    min=Math.min(min,Math.max(dp[1][j]-dp[1][k-1],dp[i-1][k-1]));
                }
                dp[i][j]=min;
            }
        }

        return (int)dp[m][nums.length];
    }*/


    //居然可以二分搜索
    public int splitArray(int[] nums, int m) {
        long sum=0;
        long max=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            max=Math.max(nums[i],max);
        }
        long low=max,high=sum;
        while (low<=high){
            long mid=(low+high)/2;

            sum=0;
            int count=1;
            for (int num : nums) {
                if(sum+num>mid){
                    sum=num;
                    count++;
                }else {
                    sum+=num;
                }
            }

            if(count<=m){
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return (int)low;
    }

    public static void main(String[] args) {
      //  splitArray(new int[]{7,2,5,10,8},2);
    }
}
