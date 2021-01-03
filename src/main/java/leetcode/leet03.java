package leetcode;

public class leet03 {
    public int waysToSplit(int[] nums) {
      int []preSum=new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1]=preSum[i]+nums[i];
        }

        long res=0;
        int mod=(int)1e9+7;
        for (int i = 0; i < nums.length-2; i++) {
          int left=preSum[i+1];
          int mid=helper(preSum,i+1,left);
          int right =helper2(preSum,i+1);
            System.out.println(mid+" "+right);
    if(mid==-1||mid>=preSum.length-1||mid>right||right==-1) continue;

       if(right==preSum.length-1) right--;
    res+= (right-mid+1);
       res%=mod;
            System.out.println(res);
        }
        System.out.println(res);
       return (int)res;
    }

    int helper2(int []presum,int left){
      int l=left+1,r=presum.length-1;
      int all=presum[presum.length-1];
    int res=-1;
     while (l<=r){
       int mid=(l+r)/2;
      int lsum=presum[mid]-presum[left];
      int rsum=all-presum[mid];
     if(lsum>rsum){
          r=mid-1;
     }else {
         res=mid;
         l=mid+1;
     }
     }

    return res;
    }

    int helper(int []presum,int left,int sum){
      int l=left+1,r=presum.length-1;
      int res=-1;
     while (l<=r){
         int mid=(l+r)/2;
        if(presum[mid]-presum[left]<sum){
           l=mid+1;
        }else {
            res=mid;
            r=mid-1;
        }
     }

   return res;
    }

    public static void main(String[] args) {
        leet03 l=new leet03();
        l.waysToSplit(new int[]{5,10,1,10,4});

    }
}
