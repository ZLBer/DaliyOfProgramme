package leetcode;

public class leet162 {


    //mine 线性时间复杂度
/*    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;

        if(nums[1]<nums[0]) return 0;
        if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
                return i;
            }
        }
        return -1;
    }*/

   //利用ums[j] 和 nums[j+1] 不会相等这一事实
 /*   public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }*/

//果然可以用二分法
//详细解释https://leetcode-cn.com/problems/find-peak-element/solution/xun-zhao-feng-zhi-by-leetcode/
public int findPeakElement(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            r = mid;
        else
            l = mid + 1;
    }
    return l;
}

}
