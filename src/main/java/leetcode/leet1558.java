package leetcode;

public class leet1558 {
  /*  public int minOperations(int[] nums) {
        int max=0;
        int count=0;
        for (int i = 0; i < nums.length; i++) {
           max=Math.max(max,nums[i]);
           if(nums[i]>0) count++;
        }

        int res=count;
        int s=(int)(Math.log(max)/Math.log(2.0));

        res+=s;
        System.out.println(res);
        for (int i = 0; i < nums.length; i++) {
          int a=(int)(Math.log(nums[i])/Math.log(2.0)); //求次方
          res+=(nums[i]-(1<<a));
        }
        return res;

    }*/

  
  //mine  思想是一样的
 /*   public int minOperations(int[] nums) {
        int res=0;
        int max=0;
        for (int i = 0; i < nums.length; i++) {
           int one=0,twp=0;
            while (nums[i]>0){
            if(nums[i]%2==1){
              nums[i]--;
              one++;
            }else {
               nums[i]/=2;
               twp++;
            }

            }
            max=Math.max(max,twp);
            res+=one;
        }
        res+=max;
        return res;
    }*/

    
    //考虑二进制1的个数
    public int minOperations(int[] nums) {
        int res=0;
        int max=0;
        //统计1的个数
        for (int num : nums) {
            max=Math.max(num,max);
           while (num>0){
            if((num&1)==1) res++;
            num=num>>1;
           }
        }

       while (max>1){
           res++;
           max=max>>1;
       }
       return res;
    }
}
