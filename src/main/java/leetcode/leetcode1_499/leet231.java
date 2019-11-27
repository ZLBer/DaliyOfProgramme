package leetcode.leetcode1_499;

public class leet231 {
 /*   public boolean isPowerOfTwo(int n) {
        if(n==Integer.MIN_VALUE) return false;
     //int count=n&(0xffff);
     return (Integer.bitCount(n)==1);

    }*/

    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return (n&(n-1))==0;
    }


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(
                -2147483648));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    }
}
