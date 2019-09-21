package leetcode.leetcode1_499;

public class leet467 {
/*
    public boolean isPerfectSquare(int num) {
         double sqrt=Math.sqrt(num);

          return  (int)sqrt*sqrt==num;
    }
*/
 // 其实并不是TLE 而实int溢出导致无限循环
/*   static public boolean isPerfectSquare(int num) {
        int left=1,right=num;
        while (left<=right){
            long mid=(left+right)/2;
            if(mid*mid==num) return true;
            else if(mid*mid<num) left=(int)mid+1;
            else right=(int)mid-1;
        }
        return false;
    }
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }*/

   /* This is a math problem：
            1 = 1
            4 = 1 + 3
            9 = 1 + 3 + 5
            16 = 1 + 3 + 5 + 7
            25 = 1 + 3 + 5 + 7 + 9
            36 = 1 + 3 + 5 + 7 + 9 + 11
            ....
    so 1+3+...+(2n-1) = (2n-1 + 1)n/2 = nn*/

  /*  public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }*/


  //e Newton Method

    public boolean isPerfectSquare(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
    public static void main(String[] args) {
     // isPerfectSquare(14);
        System.out.println(16>>>1);
    }

}
