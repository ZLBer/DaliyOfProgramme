package leetcode;

import java.math.BigInteger;
import java.util.Arrays;

public class leet1175 {



    //  BigInteger
/*    public int numPrimeArrangements(int n) {
int mod=1000000007;
 int count=0;

   for(int i=2;i<=n;i++){
       if(isPerm(i)) count++;
   }
    BigInteger result=BigInteger.valueOf(1);
for(int i=1;i<=count;i++){
    result=result.multiply(BigInteger.valueOf(i));
}
for(int i=1;i<=n-count;i++){
    result=result.multiply(BigInteger.valueOf(i));
}
        return result.mod(BigInteger.valueOf(mod)).intValue();
    }*/

    boolean isPerm(int a){
        for(int i=2;i<=a-1;i++){
            if(a%i==0) return false;
        }
     return true;
    }


    //埃拉托色尼筛选法  筛选某段区间的质数
    public static int countPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, 2, n + 1, true);
        for (int i = 2; i * i <= n; i++)
            if (prime[i])
                for (int j = i * i; j <= n; j += i)
                    prime[j] = false;
        int cnt = 0;
        for (int i = 0; i < prime.length; i++)
            if (prime[i])
                cnt++;

        return cnt;
    }

    public int numPrimeArrangements(int n) {
        int mod=1000000007;
        int count=0;

        for(int i=2;i<=n;i++){
            if(isPerm(i)) count++;
        }
        long result=1;
        for(int i=1;i<=count;i++){
            result=result*i%mod;
        }
        for(int i=1;i<=n-count;i++){
            result=result*i%mod;
        }
        return (int)result;
    }

}
