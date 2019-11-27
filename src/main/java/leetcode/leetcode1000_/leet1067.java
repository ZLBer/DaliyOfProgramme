package leetcode.leetcode1000_;

public class leet1067 {
    //肯定超时
   static public int digitsCount(int d, int low, int high) {
      int res=0;
      for (int i=low;i<=high;i++){
          int temp=i;
          while (temp>=10){
              if(temp%10==d) res++;
              temp/=10;
          }
          if(temp==d) res++;
      }
      return res;
    }

    public static void main(String[] args) {
        digitsCount(1,1,13);
    }
}
