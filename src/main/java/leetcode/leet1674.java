package leetcode;

public class leet1674 {
    public int minMoves(int[] nums, int limit) {

     int [] sum=new int[2*limit+1];
        for (int i = 0; i < nums.length/2; i++) {
      int a=nums[i],b=nums[nums.length-1-i];
         int left=2,right=2*limit;
        sum[left]+=2;
        sum[right+1]-=2;
       left=1+Math.min(a,b); right=limit+Math.max(a,b);
       sum[left]+=-1;
       sum[right+1]-=-1;
       left=a+b;right=a+b;
       sum[left]+=-1;
       sum[right+1]-=-1;
        }

        int res=Integer.MAX_VALUE;
        int s=0;
        for (int i = 2; i <=2*limit; i++) {
            s+=sum[i];
           if(res>s) res=s;
        }
        return res;
    }
}
