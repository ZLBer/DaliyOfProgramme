package leetcode;

public class leet342 {
  /*  public boolean isPowerOfFour(int num) {
       return Integer.toString(num,4).matches("10*");
    }*/
  /*  public boolean isPowerOfFour(int num) {
        return  Math.log10(num)/Math.log10(4)%1==0;
    }*/


    public boolean isPowerOfFour(int num) {

        //4的n次方有个特征   二进制中只有1位是1 ，且是奇数位置 所以  num&(num-1))
        //(num & 0x55555555) != 0 是为了排除偶数位置
        // ‭01010101010101010101010101010101‬
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
    }

    public static void main(String[] args) {
        int a=0b1;
        System.out.println(a);
        System.out.println((a-1)&a);
    }
}
