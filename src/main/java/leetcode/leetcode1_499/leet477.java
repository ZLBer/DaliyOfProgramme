package leetcode.leetcode1_499;

public class leet477 {

    //mine   时间复杂度N2
  /*  public int totalHammingDistance(int[] nums) {
        int result=0;
        for (int i = 0; i < nums.length; i++) {
            for(int j=i+1;j<nums.length;j++){
             result+=HammingDistance(nums[i],nums[j]);
                System.out.println(result);
            }
        }
        return result;
    }
   int  HammingDistance(int a,int b){
        return Integer.bitCount(a^b);
   }*/

  //这次是做好的做法 遍历32位  对于每一位：0的个数*1的个数即为不同的个数
    public int totalHammingDistance(int[] nums) {
        int count = 0, k = 0, mask = 1;
        for(int i=0; i < 32; i++){
            k = 0;
            for(int n : nums)
                if( (n & mask) != 0) ++k;
            mask <<= 1;
            count += k * (nums.length-k);
        }
        return count;
    }
}
