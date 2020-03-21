package leetcode;

import java.util.Arrays;

public class leet910 {
    //mine 失败的做法
   /* public int smallestRangeII(int[] A, int K) {
        int sum=0;
        for (int i = 0; i < A.length; i++) {
            sum+=A[i];
        }
        int avg=sum/A.length;
        int min=Integer.MAX_VALUE,maxSum=Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if(A[i]<=avg){
                A[i]+=K;
            }else {
                A[i]-=K;
            }
            min=Math.min(min,A[i]);
            maxSum=Math.maxSum(maxSum,A[i]);
        }
        return maxSum-min;
    }*/


   //mine 肯定超时啊..一点剪枝也没有呕    48 / 68
/*
  static   public int smallestRangeII(int[] A, int K) {
        dfs(A,0,Integer.MIN_VALUE,Integer.MAX_VALUE,K);
        return res;
    }
   static int res=Integer.MAX_VALUE;
   static void  dfs(int[]A,int deep,int maxSum,int min,int K){
        if(deep>=A.length){
            res= Math.min(res,maxSum-min);
            return ;
        }
        int   tmax=Math.maxSum(maxSum,A[deep]+K);
       int  tmin= Math.min(min,A[deep]+K);
        dfs(A,deep+1,tmax,tmin,K);
        tmax=Math.maxSum(maxSum,A[deep]-K);
        tmin= Math.min(min,A[deep]-K);
        dfs(A,deep+1,tmax,tmin,K);
    }
*/



    //可以去看一下这个图，很清晰 https://leetcode-cn.com/problems/smallest-range-ii/solution/shi-yong-tu-jie-by-setul/
    public int smallestRangeII(int[] A, int K) {
        int N = A.length;
        Arrays.sort(A);
        int ans = A[N-1] - A[0];

        for (int i = 0; i < A.length - 1; ++i) {
            int a = A[i], b = A[i+1];
            //比较两个上端点
            int high = Math.max(A[N-1] - K, a + K);
            //比较两个下端点
            int low = Math.min(A[0] + K, b - K);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }


    //这个 把-k看成0，k看成2k
   /* public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length, mx = A[n - 1], mn = A[0], res = mx - mn;
        for (int i = 0; i < n - 1; ++i) {
            mx = Math.maxSum(A[n-1], A[i] + 2 * K);
            mn = Math.min(A[i + 1], A[0] + 2 * K);
            res = Math.min(res, mx - mn);
        }
        return res;
    }*/

    public static void main(String[] args) {
      //  smallestRangeII(new int[]{1,3,6},3);
    }
}