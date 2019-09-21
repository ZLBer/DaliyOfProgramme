package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/1/3.
 */
public class leet238 {
    static public int[] productExceptSelf(int[] nums) {
        int count0 = 0;
        int produce = 1;
        //遍历找出0的个数，以及算出整体的produce
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count0++;
            //排除两个0的情况
            if (count0 >= 2) return new int[nums.length];
            produce *= nums[i];
        }
        //只有1个0的情况
        if (count0 > 0) {
            int zero = 0;
            //找出0的位置，并计算0位置的数字
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    int produce0 = 1;
                    int j = 0;
                    while (j < i) {
                        produce0 *= nums[j++];
                    }
                    j++;
                    while (j < nums.length) {
                        produce0 *= nums[j++];
                    }
                    nums[i] = produce0;
                    zero = i;
                }
            }
            int j = 0;
            while (j < zero) {
                nums[j++] = 0;
            }
            j++;
            while (j < nums.length) {
                nums[j++] = 0;
            }

        }
        //没有0的情况
        else for (int i = 0; i < nums.length; i++) {
            nums[i] = produce / nums[i];
        }
        return nums;
    }


// 给定任意一个点， res[i]  的值应该等于它的左边： res[0..i-1] 与 右边 ：res[i+1 ... len] 乘
//    所以第一次从左向右，把每一个点的 res[0..i-1] 乘完算出来暂存在 res[i] 上。
//    然后再从右边向左边乘，把右边res[i+1 ... len] 累乘完再乘以res[i], 注意这里res[i]上一次循环己经暂存成了res[0..i-1]的值， 所以现在结果正好等于: res[0..i-1] * res[i+1 ... len]
//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] res = new int[n];
//        res[0] = 1;
//        for (int i = 1; i < n; i++) {
//            res[i] = res[i - 1] * nums[i - 1];
//        }
//        int right = 1;
//        for (int i = n - 1; i >= 0; i--) {
//            res[i] *= right;
//            right *= nums[i];
//        }
//        return res;
//    }
    public static void main(String[] args) {
        int a[] = productExceptSelf(new int[]{9, 0, -2});
        for (int c : a) {
            System.out.println(c);
        }
    }
}
