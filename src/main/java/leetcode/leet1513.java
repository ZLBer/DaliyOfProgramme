package leetcode;

public class leet1513 {
    public int numSub(String s) {
       int left=0;
       long res=0;
       int mod=1000_000_007;
        for (int i = 0; i < s.length(); i++) {
         if(s.charAt(i)=='1') continue;
         else {
          long l=i-left;
         res=(res+((l+1)*l)/2)%mod;
         left=i+1;
         }
        }
        long l=s.length()-left;
        res=(res+((l+1)*l)/2)%mod;
        return (int)res;
    }
}
