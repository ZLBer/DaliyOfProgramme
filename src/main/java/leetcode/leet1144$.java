package leetcode;

public class leet1144$ {
    //only decreasing it by 1.!!!
//    public int movesToMakeZigzag(int[] nums) {
//        int result=0;
//        int sum=0;
//        int pre=nums[0];
//        //当奇数为峰时
//        for (int i = 1; i < nums.length; i++) {
//            if(i%2==1){
//                if(nums[i]<=pre) {
//                    sum+=(pre-nums[i]+1);
//                    pre=pre+1;
//                }else{
//                    pre=nums[i];
//                }
//
//            }else {
//                if(nums[i]>=pre){
//                    sum+=(nums[i]-pre+1);
//                    pre=pre-1;
//                }  else{
//                    pre=nums[i];
//                }
//            }
//        }
//        //当偶数为峰时
//        pre=nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if(i%2==1){
//                if(nums[i]>=pre) {
//                    result+=(nums[i]-pre+1);
//                    pre=pre-1;
//                } else {
//                    pre=nums[i];
//                }
//            }else {
//                if(nums[i]<=pre){
//                    result+=(pre-nums[i]+1);
//                    pre=pre+1;
//                } else {
//                    pre=nums[i];
//                }
//            }
//        }
//
//        return Math.min(result,sum);
//    }
    public int movesToMakeZigzag(int[] nums) {
     int []res=new int[2];
     int left=0,right=0;
        for (int i = 0; i < nums.length; i++) {
            //去除边界情况
             left=i>0?nums[i-1]:1001;
             right=i+1<nums.length?nums[i+1]:1001;
             res[i%2]+=Math.max(0,nums[i]-Math.min(left,right)+1);
        }
        return Math.min(res[0],res[1]);
    }
}
