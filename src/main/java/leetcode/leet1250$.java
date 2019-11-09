package leetcode;

public class leet1250$ {
    //裴蜀定理
    public boolean isGoodArray(int[] nums) {
        int len = nums.length, res = nums[0];
        for(int i = 1; i < len; i ++){
            res = gcd(res, nums[i]);
        }
        return res == 1;
    }


    //辗转相除法求最大公约数
    public static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }

}
