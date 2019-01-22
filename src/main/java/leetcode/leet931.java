package leetcode;

import org.apache.kafka.common.metrics.stats.Max;

import java.util.Arrays;

/**
 * Created by libin on 2019/1/21.
 */
public class leet931 {
    //mine 动态规划   占用额外空间
  /*  public int minFallingPathSum(int[][] A) {
          int [][]search=new int[A.length][A[0].length];
          for(int i=0;i<A[0].length;i++){
              search[0][i]=A[0][i];
          }
          for(int i=1;i<A.length;i++){
              for(int j=0;j<A[0].length;j++){
                  int one=101,two=101,three=101;
                  if(j-1>=0) one=search[i-1][j-1];
                  two=search[i-1][j];
                  if(j+1<A[0].length) three=search[i-1][j+1];
                   search[i][j]= Math.min(one,Math.min(three,two))+A[i][j];
              }
          }
   int minResutl=101;
          for(int i=0;i<A[0].length;i++){
              minResutl=Math.min(search[A.length-1][i],minResutl);
          }
return  minResutl;
    }*/

// 动态规划  不用额外空间
    public int minFallingPathSum(int[][] A) {
        int N = A.length;
        //从下往上
        for (int r = N-2; r >= 0; --r) {
            for (int c = 0; c < N; ++c) {
                // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
                int best = A[r+1][c];
                if (c > 0)
                    best = Math.min(best, A[r+1][c-1]);
                if (c+1 < N)
                    best = Math.min(best, A[r+1][c+1]);
                A[r][c] += best;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x: A[0])
            ans = Math.min(ans, x);
        return ans;
    }

// 依旧是动态规划，但是十分简洁clean  但是慢了点
 /*   public int minFallingPathSum(int[][] A) {
        for (int i = 1; i < A.length; ++i)
            for (int j = 0; j < A.length; ++j)
                A[i][j] += Math.min(A[i - 1][j], Math.min(A[i - 1][Math.max(0, j - 1)], A[i - 1][Math.min(A.length - 1, j + 1)]));
        return Arrays.stream(A[A.length - 1]).min().getAsInt();
    }*/



}
