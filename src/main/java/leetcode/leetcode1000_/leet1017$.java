package leetcode.leetcode1000_;

/**
 * Created by libin on 2019/4/1.
 */
public class leet1017$
{
    //Recursive
//    public String baseNeg2(int N) {
//        if (N == 0 || N == 1) return Integer.toString(N);
//        return baseNeg2(-(N >> 1)) + Integer.toString(N & 1);
//    }

   // Iterative

  static   public String baseNeg2(int N) {
        String res = "";
        while (N != 0) {
            res = Integer.toString(N & 1) + res;
        //    System.out.println(N);
           // System.out.println(res);
            N = -(N >> 1);

        }
        return res == ""  ? "0" : res;
    }

    public static void main(String[] args) {
    baseNeg2(2);
        System.out.println(-1>>1);
    }
}
