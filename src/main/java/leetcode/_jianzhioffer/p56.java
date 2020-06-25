package leetcode._jianzhioffer;

public class p56 {
    public int singleNumber(int[] nums) {
  int []count=new int[32];
        for (int i = 0; i < nums.length; i++) {
            int val=nums[i];
            int index=0;
           while (val>0){
             count[index++]+=val&1;
             val>>=1;
           }
        }
     int res=0;
        for (int i = 0; i < count.length; i++) {
          res|=((count[i]%3)<<i);
        }
       return res;
    }
}
