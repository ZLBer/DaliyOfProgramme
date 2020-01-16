package leetcode;

import java.util.Arrays;

public class leet646 {

    //mine  就还是先排序然后再做
/*    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]); //原来自带了排序函数啊
  // sort(pairs);
     int[]dp=new int[pairs.length];
     int res=0;
        for (int i = 0; i < pairs.length; i++) {
           int max=1;
            for(int j=0;j<i;j++){
               if(pairs[i][0]>pairs[j][1]){
                   max=Math.max(max,dp[j]+1);
               }

           }   dp[i]=max;
            res=Math.max(res,dp[i]);
        }
        return res;
    }
    void sort(int [][]pairs){
        for(int i=0;i<pairs.length;i++){
            int minIndex=i;
            for(int j=i+1;j<pairs.length;j++){
               if(pairs[j][0]<pairs[minIndex][0]||pairs[j][0]==pairs[minIndex][0]&&pairs[j][1]<pairs[minIndex][1]){
                   minIndex=j;
               }
            }
          swap(pairs,i,minIndex);
        }
    }
    void swap(int[][]pairs,int i,int j){
        int []temp=pairs[i];
        pairs[i]=pairs[j];
        pairs[j]=temp;
    }*/


    //贪心
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int res=1;
        int pre=pairs[0][1];
        for(int i=1;i<pairs.length;i++) {
            if (pairs[i][0] > pre) {
                res++;
                pre = pairs[i][1];
            }
        }
        return res;
    }
}
