package leetcode;

import java.util.Arrays;

public class leet801 {

    //TLE
/*    public int minSwap(int[] A, int[] B) {
      dfs(A,B,1,0);
      return min;
    }
   int min=Integer.MAX_VALUE;
  void dfs(int []A,int []B,int index,int cost){
      if(index>=A.length) {
          min=Math.min(cost,min);
       return;
      }

      //不交换
      if(check(A,B,index)) dfs(A,B,index+1,cost);
      swap(A,B,index);
     if(check(A,B,index)) dfs(A,B,index+1,cost+1);
    swap(A,B,index);
  }

  void swap(int []A,int []B,int index){
      int temo=A[index];
      A[index]=B[index];
      B[index]=temo;
  }
 boolean check(int []A,int []B,int index){
     if(A[index]>A[index-1]&&B[index]>B[index-1]) return true;
     return false;
 }*/



//mine dp
    public int minSwap(int[] A, int[] B) {
   int[][]dp=new int[A.length+1][2];
        for (int[] ints : dp) {
            Arrays.fill(ints,1001);
        }
       dp[0][0]=0;dp[0][1]=1;
        for (int i = 1; i < A.length; i++) {
            //若前后一个未交换，这个也未交换
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i][0]);
                dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + 1);
            }
                if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                    dp[i][1] = Math.min(dp[i - 1][0] + 1, dp[i][1]);
                    dp[i][0] = Math.min(dp[i - 1][1], dp[i][0]);
                }
            }

     return Math.min(dp[A.length-1][0],dp[A.length-1][1]);
    }
//可以直接放弃dp数组，用两个变量即可
//总结出了更细致的规律
  /*  public int minSwap(int[] A, int[] B) {
        int swapRecord = 1, fixRecord = 0;
        for (int i = 1; i < A.length; i++) {

            //这种情况，前面如果交换了，后面必须交换
            if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
                // In this case, the ith manipulation should be same as the i-1th manipulation
                // fixRecord = fixRecord;
                swapRecord++;


              //这总情况下，前面和后面的操作必须相反
            } else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
                // In this case, the ith manipulation should be the opposite of the i-1th manipulation
                int temp = swapRecord;
                swapRecord = fixRecord + 1;
                fixRecord = temp;

                //交换或者不交换都可以，那就取最小的
            } else {
                // Either swap or fix is OK. Let's keep the minimum one
                int min = Math.min(swapRecord, fixRecord);
                swapRecord = min + 1;
                fixRecord = min;
            }
        }
        return Math.min(swapRecord, fixRecord);
    }*/
}
