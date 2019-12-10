package leetcode;

public class leetc7 {
    public int smallestDivisor(int[] nums, int threshold) {

        int res = 1;
        int left = 1, right = 1000000;
        while (left <=right) {
            System.out.println(left+"  "+right);
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
            } else if(temp<threshold){
                right = mid;
            }
            else {
                right=mid;
            }
        }
        return left;
    }
}

