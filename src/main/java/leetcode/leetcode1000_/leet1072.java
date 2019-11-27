package leetcode.leetcode1000_;

import java.util.HashMap;
import java.util.Map;

public class leet1072 {
    //深度递归  TLE
   /* public int maxEqualRowsAfterFlips(int[][] matrix) {
        int[]sum=new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
             for(int j=0;j<matrix[0].length;j++){
                 sum[i]+=matrix[i][j];
             }
        }
     dfs(sum,matrix,0);
return max;
    }
   int max=Integer.MIN_VALUE;
     void dfs(int []sum,int [][]matrix,int i){
         if(i>=matrix[0].length) return;
         int count=0;

         //不反转递归
         for(int j=0;j<matrix.length;j++) {
             if(sum[j]==0||sum[j]==matrix[0].length) count++;
         }
         max=Math.max(max,count);
         dfs(sum,matrix,i+1);

       //反转递归
         count=0;
          for(int j=0;j<matrix.length;j++){
              if(matrix[j][i]==0) sum[j]++;
              else sum[j]--;
              if(sum[j]==0||sum[j]==matrix[0].length) count++;
          }

          max=Math.max(max,count);
          dfs(sum,matrix,i+1);
          //恢复
         for(int j=0;j<matrix.length;j++){
             if(matrix[j][i]==0) sum[j]--;
             else sum[j]++;
         }
    }*/
    public int maxEqualRowsAfterFlips(int[][] matrix) {
         Map<String,Integer> map=new HashMap<>();
         for(int [] row:matrix){
             StringBuilder stringBuilder=new StringBuilder();
             StringBuilder stringBuilder1=new StringBuilder();
             for(int r:row){
                 stringBuilder.append(r);
                 stringBuilder1.append(1-r);
             }
             map.put(stringBuilder.toString(),map.getOrDefault(stringBuilder.toString(),0)+1);
             map.put(stringBuilder1.toString(),map.getOrDefault(stringBuilder1.toString(),0)+1);
         }
         int max=Integer.MIN_VALUE;
         for(int v:map.values()){
            max=Math.max(max,v);
         }
         return max;
    }
}
