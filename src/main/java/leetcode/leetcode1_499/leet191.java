package leetcode.leetcode1_499;

public class leet191 {
 /*   public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }*/

    public int hammingWeight(int n) {
       int count=0;
       while (n>0){
           if((n&1)==1)
               count++;
           n=n>>>1;
       }
       return count;
    }
}
