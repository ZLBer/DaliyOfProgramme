package leetcode;

public class leet41 {
    //mine  但这样用了额外的空间
  /*  public int firstMissingPositive(int[] nums) {
     boolean [] check=new boolean[nums.length];
     if (nums.length==0) return 1;
     int min=1;
        for (int num : nums) {
            if(num<=0||num-1>=nums.length) continue;
            check[num-1]=true;
        }
        for (int i = 0; i < check.length; i++) {
            if(!check[i]) return i+1;
        }
        return nums.length;
    }*/




    //大佬  把每个数字交换到正确的位置
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]>0&&nums[i]<=nums.length&&nums[i]!=nums[nums[i]-1]){
                   swap(nums,i,nums[i]-1);
            }
            
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }
    void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
