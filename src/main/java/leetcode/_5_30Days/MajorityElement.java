package leetcode._5_30Days;

public class MajorityElement {
    public int majorityElement(int[] nums) {
   int num=nums[0];
   int count=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==num){
                count++;
            }else {
                count--;
                if(count==0) {
                    num=nums[i];
                    count++;
                }
            }
        }
      return num;
    }
}
