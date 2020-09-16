package leetcode.leetcode500_999;

public class leet576 {


    //记忆化搜索居然超时了？？？ 并没有  数组换成Integer判断null就可以了
  /*  public int findPaths(int m, int n, int N, int i, int j) {
      Integer [][][]dp=new Integer[m][n][N+1];
return helper(dp,m,n,N,i,j);
    }
    int [][] next=new int[][]{
            {0,1},{0,-1},{1,0},{-1,0}
    };
    int mod=100_000_0007;
   int helper(Integer [][][]dp,int m,int n,int N,int i,int j){
     if(i<0||j<0||i>=m||j>=n){
         return 1;
     }
      if(N==0){
          return 0;
      }
     if(dp[i][j][N]!=null) return dp[i][j][N];
       long count=0;
       for (int[] ints : next) {
         int ni=i+ints[0];
         int nj=j+ints[1];

           count+=helper(dp,m,n,N-1,ni,nj);
       }

     return   dp[i][j][N]=(int)(count%mod);
   }*/

      //不递归 且二维数组，也并不快哈
    //还是觉得记忆化dfs好理解点
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) return 0;

        final int MOD = 1000000007;
        int[][] count = new int[m][n];
        count[i][j] = 1;
        int result = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[r][c]) % MOD; //出界更新result，整个count[r][c]都可以
                        }
                        else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD;//未出界，需要更新count，就是这里的temp
                        }
                    }
                }
            }
            count = temp;
        }

        return result;
    }
}
