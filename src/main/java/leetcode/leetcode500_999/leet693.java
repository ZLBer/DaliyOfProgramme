package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/1/21.
 */
public class leet693 {

    //myself  一直除2
   /* public boolean hasAlternatingBits(int n) {
       int before = n%2;
        n/=2;

      while(n>0){

      if(n%2==before) return false;
      else  before=n%2;
          n/=2;
      }
      return true;
    }
    */


   //难以置信的解法
    boolean hasAlternatingBits2(int n) {
        /*
        n =         1 0 1 0 1 0 1 0
        n >> 1      0 1 0 1 0 1 0 1
        n ^ n>>1    1 1 1 1 1 1 1 1
        n           1 1 1 1 1 1 1 1
        n + 1     1 0 0 0 0 0 0 0 0
        n & (n+1)   0 0 0 0 0 0 0 0
        */

        n = n ^ (n>>1);
        return (n & n+1) == 0;
    }
}
