package leetcode;

public class leet1524 {
/*    public int numOfSubarrays(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if((arr[i]&1)==1) arr[i]=1;
            else arr[i]=0;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+" ");
        }
        int res=0;
        int mod=1000_000_007;
        for (int i = 0; i < arr.length; i++) {
            int test=0;
            for (int j = i; j < arr.length; j++) {
                 test+=arr[j];
                 if((test&1)==1) res=(res+1)%mod;
            }
        }
        return res;
    }*/
//mine 有dp的味道了
    public int numOfSubarrays(int[] arr) {
        int left=0,right=0;
        int res=0;
        int mod=1000_000_007;
        for (int i = 0; i < arr.length; i++) {
            if((arr[i]&1)==1) { //奇数
               int  tleft=right+1; //偶数序列变奇数并且+1
                int tright=left; //技术序列变快
                right=tright;
                left=tleft;

            }else {  //偶数
            int  tleft=left; //奇数序列不变
             int tright=right+1; //偶数序列+1
                right=tright;
                left=tleft;
            }
            res=(res+left)%mod;
        }
        return res;
    }

    //前缀和 基本思路:奇数-偶数=奇数 ，偶数-奇数=奇数
  /*  public int numOfSubarrays(int[] arr) {
        int mod=1000_000_007;
        long even = 1,odd = 0;
        long ans = 0,all = 0;
        for(int p : arr){
            all += p;
            if(all % 2==1) {
                ans = (ans + even) % mod;
                odd ++;
            }
            else{
                ans = (ans + odd) % mod;
                even ++;
            }
        }
        return (int)ans;
    }*/
}
