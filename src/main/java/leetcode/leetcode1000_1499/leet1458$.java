package leetcode.leetcode1000_1499;

public class leet1458$ {
    public int maxDotProduct(int[] nums1, int[] nums2) {
    int m=nums1.length,n=nums2.length;
    int [][]dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j]=nums1[i]*nums2[j]; //只包含这两个
               if(i>0&&j>0) dp[i][j]+=Math.max(0,dp[i-1][j-1]);//只要前面是正数 就可以加
                if(i>0) dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
                if(j>0)dp[i][j]=Math.max(dp[i][j],dp[i][j-1]);
            }
        }
 /*       for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
            
        }*/
        return dp[m-1][n-1];
    }
}
