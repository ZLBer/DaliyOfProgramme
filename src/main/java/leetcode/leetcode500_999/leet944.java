package leetcode.leetcode500_999;

import leetcode.LQTest.A;

public class leet944 {
    public int minDeletionSize(String[] A) {
        int count=0;
      for(int i=0;i<A[0].length();i++){
          for(int j=1;j<A.length;j++){
              if(A[j].charAt(i)<A[j-1].charAt(i)){
                  count++;
                  break;
              }
          }
      }
return count;

    }
}
