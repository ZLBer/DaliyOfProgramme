package leetcode;

import java.util.Arrays;

public class leet313 {
    //mine
  /*  public int nthSuperUglyNumber(int n, int[] primes) {
        TreeSet<Integer> treeSet=new TreeSet<>();
        int []k=new int[n+1];
        int []index=new int[primes.length];
         k[0]=1;
        int point=0;
        while (point<n){
            int min=Integer.MAX_VALUE;
            int minIndex=0;
            for (int i = 0; i < index.length; i++) {
                if(min>k[index[i]]*primes[i]){
                    min=k[index[i]]*primes[i];
                    minIndex=i;
                }
            }

            index[minIndex]++; //指针增加
            if(min==k[point]) continue; //去重
            k[++point]=min;
        }
   *//*     for (int i = 0; i < k.length; i++) {
            System.out.print(k[i]+" ");
        }*//*
        return k[n-1];
    }*/



    //两次变历不需要去重
/*    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] dp = new int[n];
        dp[0] = 1;

        int k = primes.length;
        int[] index = new int[k];

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (min > dp[index[j]] * primes[j]) {
                    min = dp[index[j]] * primes[j];
                }
                dp[i] = min;
            }
            for (int j = 0; j < k; j++) {
                if (min == dp[index[j]] * primes[j]) {
                    index[j]++;
                }
            }
        }
        return dp[n - 1];
    }*/

//缓存一下计算的值 防止重复计算
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);  //初始化成1

        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;

            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                //skip duplicate and avoid extra multiplication
                if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
                //find next ugly number
                next = Math.min(next, val[j]);
            }
        }

        return ugly[n - 1];
    }
}
