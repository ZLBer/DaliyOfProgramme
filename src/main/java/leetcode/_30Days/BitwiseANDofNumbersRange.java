package leetcode._30Days;

public class BitwiseANDofNumbersRange {

    //mine
/*  static   public int rangeBitwiseAnd(int m, int n) {
     int sum=m;
        for (int i = m+1; i>=0&&i <= n; i++) {
            sum&=i;
            System.out.println(sum);
            if(sum==0) return 0;
        }
        return sum;
    }*/



    //找相同前缀
    public int rangeBitwiseAnd(int m, int n) {
      int i=0;
      while (m!=n){
          m>>=1;
          n>>=1;
          i++;
      }
      return m<<i;
    }
    public static void main(String[] args) {
    //  rangeBitwiseAnd(2147483646,2147483647);
       // System.out.println(2147483646&2147483647);
      //  System.out.println(Integer.toBinaryString(2147483646));
      //  System.out.println(Integer.toBinaryString(2147483647));
    }
}
