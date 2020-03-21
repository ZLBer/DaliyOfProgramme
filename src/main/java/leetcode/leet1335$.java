package leetcode;

public class leet1335$ {
    //dfs+memo  看了提示之后写的
   /* public int minDifficulty(int[] jobDifficulty, int d) {
   int res= dfs(jobDifficulty,0,d,new int[jobDifficulty.length][d+1]);
    return res;
    }

    int  dfs(int []jobDifficulty,int i,int d,int [][]dp){
      if(i==jobDifficulty.length){
          if(d==0)
          return 0;
          else return Integer.MIN_VALUE;
      }
      if(dp[i][d]!=0) return dp[i][d];
      if(d==1) return maxSum(jobDifficulty,i,jobDifficulty.length-1);
      int maxSum=0;
      int res= Integer.MAX_VALUE;
      for(int index=i;index<jobDifficulty.length;index++){
         maxSum=Math.maxSum(maxSum,jobDifficulty[index]);
        int temp=dfs(jobDifficulty,index+1,d-1,dp);
        if(temp!= Integer.MIN_VALUE)
           res=Math.min(res,maxSum+temp);
      }
      dp[i][d]=res;
      return res;
    }

    int maxSum(int []arr,int from,int to){
        int maxSum=0;
        for(int i=from;i<=to;i++){
            maxSum=Math.maxSum(arr[i],maxSum);
        }
        return maxSum;
    }*/


    //dfs+memo
    static int inf = Integer.MAX_VALUE;
    public static int function(int[] jobDifficulty, int n, int i, int d, int[][] dp) {
        if(d == 0 && i == n) return 0; //遍历完
        if(d == 0 || i == n) return inf; //有一个参数没结束 所以返回inf
        if(dp[i][d] != -1) return dp[i][d]; //有记录 直接返回
        int currMax = jobDifficulty[i];
        int min = inf;
        for(int j = i; j < n; j++) {
            currMax = Math.max(jobDifficulty[j], currMax);
            int temp = function(jobDifficulty, n, j + 1, d - 1, dp);
            if(temp != inf) min = Math.min(min, temp + currMax);
        }
        return dp[i][d] = min;
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(d > n) return -1;
        int[][] dp = new int[n][d + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < d + 1; j++) dp[i][j] = -1;
        }
        return function(jobDifficulty, n, 0, d, dp);
    }

    //不用循环 直接遍历  dp还是难啊
   /* public int minDifficulty(int[] jobDifficulty, int d) {

        int n = jobDifficulty.length;
        if(n < d) return -1;
        int[][] dp = new int[d][n];

        dp[0][0] = jobDifficulty[0];
        for(int i = 1; i < n; i++){
            dp[0][i] = Math.maxSum(jobDifficulty[i],dp[0][i-1]);
        }

        for(int i = 1; i < d; i++){//天数
            for(int j = i; j < n; j++){ //任务
                int localMax = jobDifficulty[j];
                dp[i][j] = Integer.MAX_VALUE;
                for(int r = j; r >= i; r--){
                    localMax = Math.maxSum(localMax,jobDifficulty[r]);
                    dp[i][j] =  Math.min(dp[i][j],dp[i-1][r-1] + localMax);
                }
            }
        }

        return dp[d-1][n-1];
    }*/
}
