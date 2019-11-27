package leetcode;

public class leet34 {

    //mine 先二分 然后查找
/*    public int[] searchRange(int[] nums, int target) {
     int left=0,right=nums.length-1;
     int index=-1;
     while (left<=right){
         int mid=(left+right)/2;
         if(nums[mid]==target){
             index=mid;
             break;
         }else if(nums[mid]<target){
             left=mid+1;
         }else {
             right=mid-1;
         }
     }
     if(index==-1) return  new int[]{-1,-1};
     left=index;
     right=index;
     while (left>=0&&nums[left]==target){
         left--;
     }
     while (right<nums.length&&nums[right]==target){
         right++;
     }
     return new int[]{left+1,right-1};
    }*/


    //两次二分  这是真的不好想
/*    public int[] searchRange(int[] nums, int target) {
       int []res=new int[]{-1,-1};
       if(nums.length==0) return res;
        int left=0,right=nums.length-1;
       while (left<right){
           int mid=(left+right)/2;
           if(target>nums[mid]) left=mid+1;
           //<=的情况
           else right=mid;
       }
       if(nums[left]!=target) return res;
       res[0]=left;
       right=nums.length-1;
       while (left<right){
           int mid=(left+right)/2+1;
           if(nums[mid]>target) right=mid-1;
           else left=mid;
       }
       res[1]=right;
       return res;
    }*/



    //更牛皮的方法  查找taget+0.5 和taget-0.5
    //不选1的原因应该是可能有多个比他小或大1的数字
  static   public int[] searchRange(int[] nums, int target) {
        double left = target - 0.5, right = target + 0.5;
        int l = bs(nums, left), r = bs(nums, right);
        if(l == r) return new int[]{-1, -1};
        return new int[]{l, r-1};
    }

    static public int bs(int[] nums, double target) {
        int l = 0, h = nums.length-1;
        while(l <= h){
            int m = l + (h - l)/2;
            if(target > nums[m]) l = m+1;
            else h = m-1;
        }
        return l;
    }

    public static void main(String[] args) {
    searchRange(new int[]{1,2,3,4,5},3);
    }
}
