package leetcode.leetcode500_999;

import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by libin on 2019/1/21.
 * 2 3 5 7 11 13 17 19 23 29 31
 */
public class leet762 {
    //mine  基本方法
    public int countPrimeSetBits(int L, int R) {
       int count=0;
        int [] prime =new int []{2,3,5,7,11,13,17,19,23,29,31};
     for(int i=L;i<=R;i++) {
         int count1=countOne(i);
         boolean flag=false;
         for (int j = 0; j < prime.length; j++) {
           if(count1==prime[j]){
               flag=true;break;
           }
         }
         if(flag==true) count++;

     }
     return count;
    }


    int countOne(int n){
    int count=0;
        while (n>0){
            if(n%2==1)
                count++;
            n/=2;
        }
        return count;
    }

    //0b10100010100010101100 is the bit wise representation of 665772.
  //  Here 2nd,3rd,5th,7th,11th,13th,17th,19th,23rd and 29th bits are 1 and rest are 0s.
 /*   public int countPrimeSetBits(int L, int R) {
        int count = 0;
        while (L <= R)
            //确定该位数是不是质数
            count += 665772 >> Integer.bitCount(L++) & 1;
        return count;
    }
*/
//用java stream
  /*  public int countPrimeSetBits(int L, int R) {
        return IntStream.range(L, R+1).map(i -> 665772 >> Integer.bitCount(i) & 1).sum();
    }*/
}
