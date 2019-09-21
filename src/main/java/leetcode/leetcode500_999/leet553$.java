package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/1/23.
 */
public class leet553$ {
    //一个数学问题
    //X1/X2/X3/../Xn will always be equal to (X1/X2) * Y, no matter how you place parentheses. i.e no matter how you place parentheses,
    // X1 always goes to the numerator and X2 always goes to the denominator. Hence you just need to maximize Y.
    // And Y is maximized when it is equal to X3 *..*Xn. So the answer is always X1/(X2/X3/../Xn) = (X1 *X3 *..*Xn)/X2
   static public String optimalDivision(int[] nums) {
        String ret = "";
        if (nums.length == 0) {
            return ret;
        }
        if (nums.length == 1) {
            ret = Integer.toString(nums[0]);
            return ret;
        }
        if (nums.length == 2) {
            ret = Integer.toString(nums[0]) + "/" + Integer.toString(nums[1]);
            return ret;
        }

        ret = Integer.toString(nums[0]) + "/(" + Integer.toString(nums[1]);
        for (int i=2; i<nums.length; i++) {
            ret += "/" + Integer.toString(nums[i]);
        }
        ret += ")";
       // System.out.println(ret);
        return ret;
    }

    public static void main(String[] args) {
        optimalDivision(new int[]{1000,100,10,2,1000,50});
    }
}
