package leetcode;

import java.util.Arrays;
import java.util.List;

public class leet1595$ {


    //错误的dp
/*    public int connectTwoGroups(List<List<Integer>> cost) {
    int m=cost.size(),n=cost.get(0).size();
        int [][]dp=new int[m][n];

       dp[0][0]=cost.get(0).get(0);
        for (int i = 1; i < dp.length; i++) {
        dp[i][0]=dp[i-1][0]+cost.get(i).get(0);

        }
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=dp[0][i-1]+cost.get(0).get(i);
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
              int a=dp[i-1][j-1]+cost.get(i).get(j);
              int b=dp[i-1][j]+getRowMIN(i,j,cost);
              int c=dp[i][j-1]+getColMIN(j,i,cost);
              dp[i][j]=Math.min(Math.min(a,b),c);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
       return dp[m-1][n-1];
    }

    int getRowMIN(int row,int end,List<List<Integer>> cost){
        int res=Integer.MAX_VALUE;
        for (int i = 0; i <= end; i++) {
           res=Math.min(cost.get(row).get(i),res);
        }
        return res;
    }

    int getColMIN(int col,int end,List<List<Integer>> cost){
        int res=Integer.MAX_VALUE;
        for(int i=0;i<=end;i++){
            res=Math.min(cost.get(i).get(col),res);
        }
        return res;
    }*/

     //状态dp
/*
     public int connectTwoGroups(List<List<Integer>> cost) {
         int m=cost.size(),n=cost.get(0).size();
         int [][]costMatrix=new int[m][1<<n];
        for(int i=0;i<m;i++){
            for(int j=1;j<(1<<n);j++){

                int sum=0;
              for(int k=0;;k++){
                int b=(1<<k);
                 if((j&b)==b){
                   sum+=cost.get(i).get(k);
                 }
               if(b>=j) break;;
              }
            costMatrix[i][j]=sum;
            }
        }
   */
/*      for (int i = 0; i < costMatrix.length; i++) {
             for (int j = 0; j < costMatrix[0].length; j++) {
                 System.out.print(costMatrix[i][j]+" ");
             }
             System.out.println();
         }*//*


         int [][]dp=new int[m][1<<n];

         for(int i=1;i<m;i++) {
             Arrays.fill(dp[i],Integer.MAX_VALUE);
             for (int j = 1; j < (1 << n); j++) {
              for(int k=1;k<(1<<n);k++){
                dp[i][j|k]=Math.min(dp[i][j|k],dp[i-1][k]+costMatrix[i][j]);
              }
             }
         }

         dp[0]=costMatrix[0];

        return dp[m-1][(1<<n)-1];
    }
*/


    //进一步优化 ，不太理解
/*
    public int connectTwoGroups(List<List<Integer>> cost) {
        int n = cost.size(), m = cost.get(0).size();
        int[][] costSum = new int[n][1 << m];// costSum[i][j]记录cost.get(i)这个点取另一组点所有取法的可能性对应的费用
        for (int i = 0; i < n; i++) {// 遍历每个点
            for (int j = 1; j < 1 << m; j++) {// 遍历每个点对应的所有取法
                for (int k = 0; k < m; k++) {
                    if (((1 << k) & j) != 0) {
                        // 表示取到第k列
                        costSum[i][j] += cost.get(i).get(k);
                    }
                }
            }
        }

        int[][] dp = new int[n][1 << m];// dp[i][j] 表示第一组点取到前i个点，另一组点的取法为j的情况下最小费用
        for (int i = 1; i < n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0] = costSum[0];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 1 << m; j++) {
                // 找到第i行取法j所有取到的第k列中，最小的那一列，加上dp[i - 1][j]，保证前i行能按取法j取到所有的点
                for (int k = 0; k < m; k++) {
                    if (((1 << k) & j) != 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + cost.get(i).get(k));
                    }
                }

                // (1 << m) - 1 得到一个1111111... 在异或运算相当于1变0，0变1，也就是取法j中所有没取到的点
                int restPoint = j ^ ((1 << m) - 1);
                //System.out.println(j+"  "+restPoint);
                // x = (x - 1) & restPoint子集枚举  只对1枚举
                for (int x = restPoint; x > 0; x = (x - 1) & restPoint) {
                    //System.out.println(x);
                    // j | x 表示取到 取法j 和 取法x的并集
                    // dp[i][j | x] 的值 要么取法j | x之前就计算过的费用值; 要么是上一行按取法j，本行按取法x得到的费用值
                    dp[i][j | x] = Math.min(dp[i][j | x], dp[i - 1][j] + costSum[i][x]);
                }
            }
        }

        return dp[n - 1][(1 << m) - 1];
    }
*/




    //dp+memo
    public int connectTwoGroups(List<List<Integer>> cost) {
        int l = cost.size(), r = cost.get(0).size();
        int[] right = new int[r];
        Arrays.fill(right, Integer.MAX_VALUE);
        for (int j = 0; j < r; j++) {
            for (int i = 0; i < l; i++) {
                right[j] = Math.min(right[j], cost.get(i).get(j));
            }
        }
        return helper(cost, 0, right, 0, new int[l + 1][(1<<r)]);
    }
    private int helper(List<List<Integer>> cost, int i, int[] right, int mask, int[][] dp) {
        if (dp[i][mask] > 0) return dp[i][mask];

        int res = 0;
        if (i < cost.size()) {
            res = Integer.MAX_VALUE;
            //对i行的每一列j进行填充
            for (int j = 0; j < cost.get(0).size(); j++) {
                res = Math.min(res, cost.get(i).get(j) + helper(cost, i + 1, right, mask | (1 << j), dp));
            }
        } else {

            //i>=cost.size 如果还有空的 需要补上最小的
            for (int j = 0; j < cost.get(0).size(); j++) {
                if ((mask & (1 << j)) == 0) res += right[j];
            }
        }
        return dp[i][mask] = res;
    }
}
