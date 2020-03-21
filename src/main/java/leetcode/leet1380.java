package leetcode;

import java.util.*;

public class leet1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result=new ArrayList<>();
      int[]dp=new int[matrix.length];
      //行中最小
      for (int i = 0; i < matrix.length; i++) {
          int min=matrix[i][0];
          dp[i]=0;
          for(int j=1;j<matrix[0].length;j++){
              if(matrix[i][j]<min){
                  min=matrix[i][j];
                  dp[i]=j;
              }
          }
        }
        for (int i = 0; i < dp.length; i++) {
            int number=matrix[i][dp[i]];
            int column=dp[i];
            boolean flag=false;
            for(int j=0;j<matrix.length;j++){
                if(matrix[j][column]>number){
                    flag=true;
                    break;
                }
            }
            if(!flag) result.add(number);
        }
        return result;
    }


    //分别求min max 然后比较
/*    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] mi = new int[m], mx = new int[n];
        Arrays.fill(mi, Integer.MAX_VALUE);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                mi[i] = Math.min(matrix[i][j], mi[i]);
                mx[j] = Math.max(matrix[i][j], mx[j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (mi[i] == mx[j])
                    res.add(mi[i]);
        return res;
    }*/

    //用set
 /*   public List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> minSet = new HashSet<>(), maxSet = new HashSet<>();
        for (int[] row : matrix) {
            int mi = row[0];
            for (int cell : row)
                mi = Math.min(mi, cell);
            minSet.add(mi);
        }
        for (int j = 0; j < matrix[0].length; ++j) {
            int mx = matrix[0][j];
            for (int i = 0; i < matrix.length; ++i)
                mx = Math.max(matrix[i][j], mx);
            if (minSet.contains(mx))
                maxSet.add(mx);
        }
        return new ArrayList<>(maxSet);
    }*/
}
