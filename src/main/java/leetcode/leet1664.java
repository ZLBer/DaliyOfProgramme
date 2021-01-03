package leetcode;

public class leet1664 {
    //mine
    public int waysToMakeFair(int[] nums) {
     long even=0,odd=0;
     long [][]presum=new long[nums.length+1][2];
        for (int i = 0; i < nums.length; i++) {
            if(i%2==0){
                even+=nums[i];

            }else {
                odd+=nums[i];
            }

          presum[i+1][0]=even;
            presum[i+1][1]=odd;
        }
//        for (int i = 0; i < presum.length; i++) {
//            System.out.println(presum[i][0]+" "+presum[i][1]);
//        }

        int res=0;
        for (int i = 1; i <= nums.length; i++) {
          long teven=presum[i-1][0]+presum[nums.length][1]-presum[i][1];
          long todd=presum[i-1][1]+presum[nums.length][0]-presum[i][0];
        if(teven==todd) res++;
        }
        return res;
    }

    //不用数组额外空间
/*    int waysToMakeFair(int [] nums) {
        int res=0,n=nums.length;
        int sum_odd=0,sum_even=0,left_odd=0,left_even=0,right_odd=0,right_even=0;
        //初始化sum_odd,sum_even
        for(int i=0;i<n;i++){
            if(i%2==1){
                sum_odd+=nums[i];
            }else {
                sum_even+=nums[i];
            }
        }
        for(int i=0;i<n;i++){
            if(i%2==1){
                left_odd+=nums[i];
            }else {
                left_even+=nums[i];
            }
            //计算right_odd,right_even
            right_odd=sum_even-left_even;
            right_even=sum_odd-left_odd;
            //减掉元素本身

            if(i%2==1){
                right_odd-=nums[i];
            }else {
                right_even-=nums[i];
            }
            System.out.println(left_even+" "+left_odd+" "+right_even+" "+right_odd);
            //判等
            if(left_odd+right_odd==left_even+right_even)res++;
        }
        return res;
    }*/
    //不用数组额外空间
 /*   int waysToMakeFair(int [] nums) {
        int res=0,n=nums.length;
        int sum_odd=0,sum_even=0,left_odd=0,left_even=0,right_odd=0,right_even=0;
        //初始化sum_odd,sum_even
        for(int i=0;i<n;i++){
            if(i%2==1){
                sum_odd+=nums[i];
            }else {
                sum_even+=nums[i];
            }
        }
        for(int i=0;i<n;i++){
            right_odd=sum_even-left_even;
            right_even=sum_odd-left_odd;

            if(i%2==1){
                left_odd+=nums[i];
            }else {
                left_even+=nums[i];
            }

            //System.out.println(left_even+" "+left_odd+" "+right_even+" "+right_odd);
            //判等
            if(left_odd+right_odd==left_even+right_even)res++;
        }
        return res;
    }*/
}
