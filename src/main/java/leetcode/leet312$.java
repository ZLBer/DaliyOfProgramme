package leetcode;

public class leet312$ {
    public int maxCoins(int[] nums) {
        int []newNum=new int[nums.length+2];
        for (int i = 1; i < newNum.length-1; i++) {
             newNum[i]=nums[i-1];
        }
        newNum[0]=newNum[newNum.length-1]=1;
  return DFS(newNum,0,newNum.length-1,new int[newNum.length][newNum.length]);
    }

    int DFS(int[]nums,int left,int right,int[][]memo){
        if(left+1==right) return 0;
        if(memo[left][right]>0) return memo[left][right];
        int max=0;
        for(int mid=left+1;mid<right;mid++){
        max=Math.max(max,nums[left]*nums[mid]*nums[right]+DFS(nums,left,mid,memo)+DFS(nums,mid,right,memo));
        }
        memo[left][right]=max;
        return max;
    }





    //纯DP
/*    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;
        int[][] dp = new int[n][n];
        //从3个球开始遍历
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }*/
}
