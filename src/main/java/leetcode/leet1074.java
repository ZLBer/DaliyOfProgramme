package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class leet1074 {
    //mine
/*    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] dp = new int[matrix[0].length];
            for (int j = i; j < matrix.length; j++) {
             for(int k=0;k<matrix[0].length;k++){
                 dp[k]+=matrix[j][k];
             }

                for(int k=0;k<matrix[0].length;k++){
                    int temp=0;
                    for(int l=k;l<matrix[0].length;l++){
                        temp+=dp[l];
                        if(temp==target) res++;
                    }
                }
            }
        }
        return res;
    }*/



    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[] temp = new int[m];
        int ans=0;
        for (int left = 0;left<n;left++) {
            Arrays.fill(temp,0);
            for (int right=left;right<n;right++) {
                for (int i=0;i<m;i++) {
                    temp[i]+=matrix[i][right];
                }
                ans+= subCount(temp,target);
            }
        }
        return ans;
    }
   // 暂存前n项的和可以减少重复计算
    private int subCount(int[] temp,int target) {
        HashMap<Integer, Integer> prevSum = new HashMap<>();

        int res = 0;
        int currentSum = 0;

        for (int t : temp) {

            currentSum += t;
            if (currentSum == target) {
                res++;
            }
            // currentSum-pre=target=去除前面的几项中间几项的和
            if (prevSum.containsKey(currentSum - target)) {
                res += prevSum.get(currentSum - target);
            }
            //存储前n项
           prevSum.put(currentSum,prevSum.getOrDefault(currentSum,0)+1);
            //  prevSum.merge(currentSum, 1, (a, b) -> a + b); //比上面更快
        }

        return res;
    }
}
