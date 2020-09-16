package leetcode.leetcode1000_1499;

public class leet1130$ {

    //类似于求矩阵最大连乘积
    public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        int[][] max = new int[arr.length][arr.length];

        //找出i-length的最大值
        for(int i = 0; i < arr.length; i ++) {
            int localMax = 0;
            for(int j = i; j < arr.length; j ++) {
                if(arr[j] > localMax) {
                    localMax = arr[j];
                }
                max[i][j] = localMax;
            }
        }
        //从区间长度为1开始，一直到length
        for(int len = 1; len < arr.length; len ++) {
           //left从0开始  right=left+len
            for(int left = 0; left + len < arr.length; left ++) {
                int right = left + len;
                //初始化成最大值
                dp[left][right] = Integer.MAX_VALUE;
                //长度为1表示只有两个叶子节点
                if(len == 1) {
                    dp[left][right] = arr[left]*arr[right];
                } else {
                    //否则，就依次遍历；可以看题目中的例子帮助理解
                    for(int k = left; k < right; k ++) {
                        dp[left][right] = Math.min(dp[left][right], dp[left][k] + dp[k+1][right] + max[left][k]*max[k+1][right]);
                    }
                }
            }
        }
        return dp[0][arr.length-1];
    }


    //自己写一遍 帮助记忆

 /*   public int mctFromLeafValues(int[] arr) {
        int max[][]=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            int tempMax=arr[i];
            for(int j=i;j<arr.length;j++){
                if(arr[j]>tempMax){
                    tempMax=arr[j];
                }
                max[i][j]=tempMax;
            }
        }

        int dp[][]=new int[arr.length][arr.length];

        for(int len=1;len<arr.length;len++){
            for(int left=0;left+len<arr.length;left++){
                int right=left+len;
               dp[left][right]=Integer.MAX_VALUE;
                if(len==1){
                    dp[left][right]=arr[left]*arr[right];
                }
                else {
                    for(int k=left;k<right;k++){
                        dp[left][right]=Math.min(dp[left][right],dp[left][k]+dp[k+1][right]+max[left][k]*max[k+1][right]);
                    }
                }
            }
        }
   return dp[0][dp.length-1];
    }*/


 //非dp解法  甚至比dp更难理解
/*    public int mctFromLeafValues(int[] A) {
        int res = 0, n = A.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : A) {
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }*/


}
