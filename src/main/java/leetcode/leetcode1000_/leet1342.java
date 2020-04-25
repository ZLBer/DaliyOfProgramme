package leetcode.leetcode1000_;

public class leet1342 {
    //mine
    public int numberOfSteps (int num) {
      int step=0;
      while (num!=0){
          if(num%2==0) num/=2;
          else num-=1;
          step++;
      }
      return step;
    }


    //用二进制数来做
 /*   int numberOfSteps (int num) {
        if(num==0) return 0;
        int res = 0;
        while(num!=0) {
            res += (num & 1)==1 ? 2 : 1;
            num >>= 1;
        }
        return res - 1;
    }*/
}
