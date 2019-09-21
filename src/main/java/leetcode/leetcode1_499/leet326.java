package leetcode.leetcode1_499;

public class leet326 {




//循环
/*    public boolean isPowerOfThree(int n) {
      if(n>1)
          while (n%3==0) n/=3;
       return n==1;
    }*/


    //递归
  /*  public boolean isPowerOfThree(int n) {
        return n>0&&(n==1||(n%3==0)&&(isPowerOfThree(n/3)));
    }*/

/*  秀破天际
    public boolean isPowerOfThree(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return ( n>0 &&  1162261467%n==0);
    }*/

  //  log10(n) / log10(3) 换底公式？
 /*   public boolean isPowerOfThree(int n) {
        Integer.toString(n, 3);
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }*/


 /*   public boolean isPowerOfThree(int n) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467));
        return set.contains(n);
    }*/
    public boolean isPowerOfThree(int n) {
        //Integer.toString(n, 3) 以3为基n展开成三进制形式
        return Integer.toString(n, 3).matches("10*");
    }
    public static void main(String[] args) {

        System.out.println(Integer.toString(9, 3).matches("10*"));
    }
    }


