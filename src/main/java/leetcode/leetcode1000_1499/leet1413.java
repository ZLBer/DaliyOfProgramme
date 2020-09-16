package leetcode.leetcode1000_1499;

public class leet1413 {
    public int minStartValue(int[] nums) {
        int sum=0;
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            res=Math.max(res,1-sum);
        }
        return res;

    }
}
