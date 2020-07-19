package leetcode;

import java.util.Stack;

public class leet1504 {
    //mine contest
/*    public int numSubmat(int[][] mat) {


        int [][]dp=new int[mat.length+1][mat[0].length+1];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
               if(mat[i][j]==1){
                dp[i+1][j+1]=dp[i][j+1]+1;
               }
            }
        }
        int sum=0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int min=Integer.MAX_VALUE;
                for(int k=j;k>=0;k--){
                 min=Math.min(min,dp[i+1][k+1]);
                sum+=min;
                }
            }
        }
        return sum;
    }*/

    //可以用栈来进一步减小复杂度
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length, height[] = new int[n], res = 0;
        for (int i = 0; i < m; i++) {
            Stack<int[]> st = new Stack<>(); //stack是单调递增栈
            for (int j = 0; j < n; j++) {
                height[j] = mat[i][j] == 0 ? 0 : (height[j] + 1);   // horizontal height of histogram;
                int sum = 0;
                while(!st.isEmpty() && height[st.peek()[0]] >= height[j]) st.pop();
                if (!st.isEmpty()) sum += height[j] * (j - st.peek()[0]) + st.peek()[1];//用自己的高度+前面第一个比自己小的sum
                else sum += height[j] * (j + 1); //表示之前没有比自己矮的
                st.push(new int[]{j, sum});
                res += sum;
            }
        }
        return res;
    }
}
