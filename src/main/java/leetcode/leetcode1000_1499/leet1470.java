package leetcode.leetcode1000_1499;

public class leet1470 {
    public int[] shuffle(int[] nums, int n) {
     int []res=new int[nums.length];
     int i=0,j=n;
        for (int k = 0; k < res.length; k+=2) {
            res[k]=nums[i++];
            res[k+1]=nums[j++];
        }
       return res;
    }
}
