package leetcode._jianzhioffer;

public class p64 {
    //短路特性
    public int sumNums(int n) {
      boolean x=n>1&&(n+=sumNums(n-1))>0;
      return n;
    }
}
