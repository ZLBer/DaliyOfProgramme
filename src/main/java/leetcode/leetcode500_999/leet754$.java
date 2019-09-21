package leetcode.leetcode500_999;

public class leet754$ {

    //mine 贪心法宣告失败
//    public int reachNumber(int target) {
//      int n=1;
//      int count=0;
//      if(target<0) target=-target;
//      while (target>=n){
//          target-=n;
//          count++;
//          n++;
//      }
//      count+=target*2;
//      return count;
//    }

    //nice
    public int reachNumber(int target) {
        int sum=0;
        int n=1;
        if(target<0) target=-target;
        while (sum<target){
            sum+=n;
            n++;
        }
        while ((sum-target)%2!=0){
            sum+=n;
            n++;
        }
        return n;
    }

/*    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0)
            target -= ++k;
        return target % 2 == 0 ? k : k + 1 + k%2;
    }*/

}
