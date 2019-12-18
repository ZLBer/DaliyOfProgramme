package leetcode;

public class leet1283 {


    //做了很久   发现是二分搜索
  /*  public int smallestDivisor(int[] nums, int threshold) {

        int res = 1;
        int left = 1, right = 1000000;
        while (left <=right) {
            int mid = (left + right) / 2;
            int temp = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % mid == 0) {
                    temp += (nums[i] / mid);
                } else {
                    temp += (nums[i] / mid);
                    temp++;
                }
            }
            if (temp > threshold) {
                left = mid + 1;
            } else {
                right=mid;
            }
        }
        return left;
    }
*/

    //for循环那里可以优化一下

    public int smallestDivisor(int[] A, int threshold) {
        int left = 1, right = (int)1e6;
        while (left < right) {
            int m = (left + right) / 2, sum = 0;
            for (int i : A)
                //可以合成一种情况
                sum += (i + m - 1) / m;
            if (sum > threshold)
                left = m + 1;
            else
                right = m;
        }
        return left;
    }
}

