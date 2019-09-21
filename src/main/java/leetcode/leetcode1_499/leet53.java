package leetcode.leetcode1_499;

/**
 * Created by libin on 2019/3/6.
 */
public class leet53 {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int b = 0;
        //用b保存千面的最大字段和
        for (int i = 0; i < nums.length; i++) {
            //若b大于0 则可继续累加
            if (b > 0) b += nums[i];
            else b = nums[i]; //否则b重新赋值
            if (b > sum) //是否替换sum
                sum = b;
        }
        return sum;
    }

}
