package leetcode;

public class leet1191 {


    //mine 要注意溢出问题 以及运算符的运算顺序  强制类型转换的时候要把后面的式子整体加括号！！
    static public int kConcatenationMaxSum(int[] arr, int k) {
        int mod=1000000007;
        long sum=0;
        for(int a:arr){
            sum+=a;
        }
        long kSum=0;
        if(k>2) kSum=sum*(k-2);

        //    System.out.println(kSum);
        //dp[i] means the maximum subarray ending with A[i]
        long []dp1=new long[arr.length+1];
        long max=0;
        for (int i = 0; i < arr.length; i++) {
            if(dp1[i]<=0)
                dp1[i+1]=arr[i];
            else dp1[i+1]=dp1[i]+arr[i];
            max=Math.max(max,dp1[i+1]);
        }
        //  System.out.println(dp1[arr.length]);
        long []dp2=new long[arr.length+1];
        for(int i=arr.length;i>0;i--){
            if(dp2[i]<=0)
                dp2[i-1]=arr[i-1];
            else dp2[i-1]=dp2[i]+arr[i-1];
        }
        //   System.out.println(dp2[0]);
        System.out.println(kSum+" "+dp1[arr.length]+dp2[0]);
        long result=0;
        if(kSum>0) result+=kSum;
        if(dp1[arr.length]>0)  result+=dp1[arr.length];
        if(dp2[0]>0) result+=dp2[0];



        return (int)Math.max(result,max)%mod;
    }

    public static void main(String[] args) {
        int mod=1000000007;
        System.out.println((int)(((long)Integer.MAX_VALUE+1)%mod));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println((73660232790L+2344679+2282284)%mod);
        long kSum=73660232790L;
        long a=2344679;
        long b=2282284;
        long result=0;
        if(kSum>0) result+=kSum;
        if(a>0)  result+=a;
        if(b>0) result+=b;
        System.out.println((int)(Math.max(result,1)%mod));
    }
}
