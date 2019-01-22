package leetcode;

/**
 * Created by libin on 2019/1/22.
 */
public class leet260$ {

    /*
     *
     *
     * @author BNer
     * @date 2019/1/22 17:15
    Once again, we need to use XOR to solve this problem. But this time, we need to do it in two passes:

In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find. Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result. Find
out an arbitrary set bit (for example, the rightmost set bit).

In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, another with the aforementinoed bit unset. Two different numbers we need to find must fall into thte two distrinct groups. XOR numbers in each group, we can find a number in either group.

Complexity:

Time: O (n)

Space: O (1)
     */
    //巧妙至极，这得多熟悉二进制运算
  static   public int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        //负数用补码表示
        //6=0110   反码1001  补码等于反码加一  1010
      System.out.println(diff);
        System.out.println(Integer.toBinaryString(diff));
        // Get its last set bit
      System.out.println(Integer.toBinaryString(-diff));
        diff &= -diff; //一个数和一个数的相反数做与操作得到的是这个数从右往左第一个不为0的数。
        System.out.println(Integer.toBinaryString(diff));
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
      //然后分成两组
        for (int num : nums)
        {
            //固定位为0
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            //固定位为1
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        singleNumber(new int[]{1,2,1,3,2,5});
    }

}
