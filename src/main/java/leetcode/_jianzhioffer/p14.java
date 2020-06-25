package leetcode._jianzhioffer;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class p14 {
    //mine 找规律呗
/*   public int cuttingRope(int n) {

        long res=1;
        int m=0;
        while (n>4){
       res*=3;
       res%=mod;
       m++;
       n-=3;
      }
     if(m>=1){
         return (int)((res*n)%mod);
     }
     else {
         switch (n){
             case 4:return 4;
             case 3:return 2;
             case 2:return 1;
     }
    }
     return 0;}*/



    //dp 这种数字大了为啥就不对呢？？
    //答：还是溢出的问题 改成bigInteger就行了
    int mod=1000000007;
      public int cuttingRope(int n) {
       return   helper(n,true).mod(BigInteger.valueOf(mod)).intValue();
     }
      Map<Integer, BigInteger> map=new HashMap<>();
     BigInteger helper(int n,boolean first){
        if(!first){
            if(n<=3) return BigInteger.valueOf(n);
        }else {
           if(n==2) return BigInteger.valueOf(1);
           if(n==3) return BigInteger.valueOf(2);
        }


     if(map.containsKey(n)){
         return map.get(n);
     }
         BigInteger max=BigInteger.ONE;
         for(int i=1;i<=n/2;i++){
      max=max.max(helper(i,false).multiply(helper(n-i,false)));
      }
       map.put(n,max);
     return map.get(n);
     }






}
