package leetcode.leetcode1000_;

public class leet1004 {
    //mine 初代
 /*   public int longestOnes(int[] A, int K) {
      int left=0,right=0;


      int index=0;
      int result=0;
      while (index<A.length){
          if (index<A.length&&A[index]==1) {
              right++;
              index++;;
              continue;
          }
          if (index<A.length&&A[index]==0&&K>0){
              K--;
              index++;
              right++;
              continue;
          }
          result=Math.max(right-left,result);
          if(A[left++]==0) K++;

      }
        result=Math.max(right-left+1,result);
        return result;
    }*/
//mine 改进版
    public int longestOnes(int[] A, int K) {
      int start=0,end=0;
     int result=0;
      for(;end<A.length;end++){
          if(A[end]==0) K--;
          while (K<0){
              if(A[start++]==0) K++;
          }
           result=Math.max(result,end-start+1);
      }
      return result;
    }

    //大神简洁的算法
    //窗口固定，只会增大不会所辖
   /* public int longestOnes(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }*/
}
