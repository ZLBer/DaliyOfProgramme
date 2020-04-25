package leetcode;

public class leet793 {
    public int preimageSizeFZF(int K) {
        long low=0,high=5L*(K+1); // 5L的L不能少
        return (int)(binary(low,high,K+1)-binary(low,high,K));
    }


    //查找最左位置
    long binary(long low,long high,int K){
        while (low<high){
           long mid=low+(high-low)/2;
           long k=numOfTrailingZeros(mid);
           if(k>=K){
               high=mid;
           }else {
                 low=mid+1;
           }
        }
        return low;
    }


    //求一个数的解成结尾有几个0
    private long numOfTrailingZeros(long x) {
        long res = 0;

        for (; x > 0; x /= 5) {
            res += x/5;
        }

        return res;
    }

  //其实只需要返回5就可以
/*
    public int preimageSizeFZF(int K) {
        for (long l = 0, r =  5L * (K + 1); l <= r;) {
            long m = l + (r - l) / 2;
            long k = numOfTrailingZeros(m);

            if (k < K) {
                l = m + 1;
            } else if (k > K) {
                r = m - 1;
            } else {
                return 5;
            }
        }

        return 0;
    }*/
}


