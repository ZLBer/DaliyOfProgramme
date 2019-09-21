package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/2/19.
 */
public class leet458$ {
    //not easy
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
      int pigs=0;
      while (Math.pow(minutesToTest/minutesToDie+1,pigs)<buckets){
          pigs++;
      }
      return pigs;
    }
}
