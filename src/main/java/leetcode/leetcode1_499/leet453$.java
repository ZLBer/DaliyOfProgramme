package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/2/25.
 */
public class leet453$ {
  //一个数学问题
    /*
A more natural way to think about this question:
there is a staircase on which every numbers in array stand with corresponding step. '1' is on the 1st step and '5' on the 5th step.

A single move makes n-1 numbers step up, while on the other hand, we can also think a move as the remaining one step down. The relative distance between the numbers are same.

Our goal is to make all numbers on the same step.
Rather than move n-1 numbers up every time, why not just move one number down?

so the problem is simple:

find the min
move other numbers down to min.
number of moves = nums[0]-min + nums[1]-min + .... +nums[n]-min = sum - n * min

just another way to think of the magic equation.
     */
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(241/100%9);
    }
}
