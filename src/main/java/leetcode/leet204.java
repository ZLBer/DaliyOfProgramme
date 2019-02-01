package leetcode;

/**
 * Created by libin on 2019/2/1.
 */
public class leet204 {


    //超时
/*    public int countPrimes(int n) {
         int count=0;
         for(int i=2;i<n;i++){
             if(isPrime(i)) count++;
         }

         return count;

    }



    boolean isPrime(int n){
        for(int i=2;i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }*/


    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                //倍数填充
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }



}
