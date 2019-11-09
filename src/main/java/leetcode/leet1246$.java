package leetcode;

public class leet1246$ {
/*   static public int minimumMoves(int[] arr) {
  int n=arr.length;

  int[][]dp=new int[n][n];
  //长度为1
  for(int i=0;i<n;i++) dp[i][i]=1;
  //长度为2
  for(int i=0;i<n-1;i++)dp[i][i+1]=(arr[i]==arr[i+1]?1:2);
//长度为3及以上
  for(int size=3;size<=n;size++){
      for(int left=0,right=left+size-1;right<n;left++,right++){
          //首尾相同，则表示可以和里面的一起删除
          dp[left][right]=Integer.MAX_VALUE;
          if(arr[left]==arr[right]){
              //从这里可以看出为什么要讨论size=1和size=2
            dp[left][right]=dp[left+1][right-1];
          }

          //然后依次遍历
          for(int mid=left;mid<right;mid++){
              dp[left][right]= Math.min(dp[left][right],dp[left][mid]+dp[mid+1][right]);
          }

      }
  }
       System.out.println(dp[0][n-1]);
       for (int i = 0; i < dp.length; i++) {
           for (int j = 0; j < dp[0].length; j++) {
               System.out.print(dp[i][j]+" ");
           }
           System.out.println();
       }
  return dp[0][n-1];
    }*/



//一种紧凑的做法，从下到上开始遍历
    public int minimumMoves(int[] A) {
        int N = A.length;
        //  declare dp array and initialize it with 0s
        int[][] dp = new int[N + 1][N + 1];

        //从长度1开始遍历
        for (int len = 1; len <= N; len++) {
            //i-j表示一个区间
            for (int i = 0, j = len - 1; j < N; i++, j++) {
                //如果长度是1直接设置1
                if (len == 1)
                    dp[i][j] = 1;
                else {

                    //还是要把长度为1和2的情况单独计算，不然之后的dp[i + 1][K - 1] + dp[K + 1][j]无法计算

                    // delete A[i] 初始化为 1+下一个区间
                    dp[i][j] = 1 + dp[i + 1][j];
                    // if current and next element are same, choose min from current and subproblem (i+2,j)
                    if (A[i] == A[i + 1])
                        dp[i][j] = Math.min(1 + dp[i + 2][j], dp[i][j]);
                    // loop over all right elements and suppose Kth element is same as A[i] then
                    // choose minimum from current and two subarray after ignoring ith and A[K]
                    for (int K = i + 2; K <= j; K++)
                        if (A[i] == A[K])
                            dp[i][j] = Math.min(dp[i + 1][K - 1] + dp[K + 1][j], dp[i][j]);
                }
            }
        }
        return dp[0][N - 1];
    }



    //从上到下进行DP
/*    int[][] dp;
    public int minimumMoves(int[] A) {
        int n = A.length;
        dp = new int[n][n];
        return dfs(0, n - 1, A);
    }
    int dfs(int i, int j, int[] A) {
        if (i > j) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        //初始换成1+前一个
        int res = dfs(i, j - 1, A) + 1;
        //前两个数字相同
        if (j > 0 && A[j] == A[j - 1])
            res = Math.min(res, dfs(i, j - 2, A) + 1);
        //遍历
        for (int k = i; k < j - 1; ++k)
            if (A[k] == A[j])
                res = Math.min(res, dfs(i, k - 1, A) + dfs(k + 1, j - 1, A));
        dp[i][j] = res;
        return res;
    }*/


    public static void main(String[] args) {
       // minimumMoves(new int[]{1,3,4,1,5});
    }
}
