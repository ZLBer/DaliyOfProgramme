package leetcode.leetcode1_499;

public class leet33 {

    //mine 利用一边升序的原则
 /*   public int search(int[] nums, int target) {
     int left=0,right=nums.length-1;
     while (left<=right){
         if(left+1==right){
             return nums[left]==target?target:(nums[right]==target?right:-1);
         }
         int mid=(left+right)/2;
         //左边有序
         if(nums[left]<nums[mid]){
             if(target>=nums[left]&&target<=nums[mid]) return bs(nums,left,right,target);
             else left=mid+1;
         }
         //右边有序
         else {
             if(target>=nums[mid]&&target<=nums[right]) return bs(nums,left,right,target);
             else right=mid-1;
         }
     }
       return -1;
    }
    int bs(int []nums,int left,int right,int target){
          while (left<=right){
              int mid=(left+right)/2;
              if(nums[mid]==target){
                  return mid;
              }else if(nums[mid]<target){
                  left=mid+1;
              }else {
                  right=mid-1;
              }
          }
          return -1;
    }*/




    //一种做法 先找到旋转点
/*    class Solution {
        int [] nums;
        int target;

        //找旋转点
        public int find_rotate_index(int left, int right) {
            if (nums[left] < nums[right])
                return 0;

            while (left <= right) {
                int pivot = (left + right) / 2;
                if (nums[pivot] > nums[pivot + 1])
                    return pivot + 1;
                else {
                    if (nums[pivot] < nums[left])
                        right = pivot - 1;
                    else
                        left = pivot + 1;
                }
            }
            return 0;
        }

        //二分搜索
        public int search(int left, int right) {
    *//*
    Binary search
    *//*
            while (left <= right) {
                int pivot = (left + right) / 2;
                if (nums[pivot] == target)
                    return pivot;
                else {
                    if (target < nums[pivot])
                        right = pivot - 1;
                    else
                        left = pivot + 1;
                }
            }
            return -1;
        }
   //主函数
        public int search(int[] nums, int target) {
            this.nums = nums;
            this.target = target;

            int n = nums.length;

            if (n == 0)
                return -1;
            if (n == 1)
                return this.nums[0] == target ? 0 : -1;

            int rotate_index = find_rotate_index(0, n - 1);

            // if target is the smallest element
            if (nums[rotate_index] == target)
                return rotate_index;
            // if array is not rotated, search in the entire array
            if (rotate_index == 0)
                return search(0, n - 1);
            if (target < nums[0])
                // search in the right side
                return search(rotate_index, n - 1);
            // search in the left side
            return search(0, rotate_index);
        }
    }*/




    //和我的思路一样 但不需要分俩个方法
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序,注意此处用小于等于
            if (nums[start] <= nums[mid]) {
                //target在前半部分
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;

    }

    //将三个条件异或 牛p..
    //https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-jian-solution-by-lukelee/
/*    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }*/

    public static void main(String[] args) {
        //三个数异或可以先两个异或
        System.out.println(true^false^false);
    }

}
