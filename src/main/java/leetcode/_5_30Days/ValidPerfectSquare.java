package leetcode._5_30Days;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
       int i=0;
       long val=i*i;
       while (val<=num){
          if(val==num) return true;
           i++;
          val=i*i;
       }
       return false;
    }
}
