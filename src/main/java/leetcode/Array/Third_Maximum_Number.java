package leetcode.Array;

/**
 * Created by libin on 2017/10/19.
 */
public class Third_Maximum_Number {
    public int thirdMax(int[] nums) {
return solution(nums,0,nums.length-1,3);
    }
    public int solution(int[] nums,int left,int right,int n) {
        if(left>=right) return nums[left];
        int pivot = nums[left];
        int i = left;
        int j = right + 1;
        while (true) {
            do {
                i += 1;
            } while (i<nums.length&&nums[i] > pivot);
            do {
                j -= 1;
            } while (j>-1&&nums[j] < pivot);

        if (i >= j) break;
        swap(nums, i, j);
    }
        nums[left]=nums[j];
    if(n==j-left+1) return pivot;
        if(n>j-left+1)
            return  solution(nums,j+1,right,n-j+left-1);
        else return  solution(nums,left,j-1,n);
    }
    static void swap(int nums[],int i,int j){
        int a=nums[i];
        nums[i]=nums[j];
        nums[j]=a;
    }
}
