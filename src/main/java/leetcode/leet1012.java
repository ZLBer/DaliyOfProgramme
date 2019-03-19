package leetcode;

import org.assertj.core.internal.Integers;

/**
 * Created by libin on 2019/3/19.
 */
public class leet1012 {
    //mine..
   /* public int bitwiseComplement(int N) {
    String s=  Integer.toBinaryString(N);
   int count=0;
   int result=0;
    for(int i=s.length()-1;i>=0;i--){
        char a=s.charAt(i);
        if(a=='0')
              result+=Math.pow(2,count);
        count++;
    }
    return result;
    }*/


    /*
     *  神仙做法
 N + bitwiseComplement(N) = 11....11 = X
Then bitwiseComplement(N) = X - N
     */
    public int bitwiseComplement(int N) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return X - N;
    }

    /*
     *
  N ^ bitwiseComplement(N) = 11....11 = X
bitwiseComplement(N) = N ^ X
     */

  /*  public int bitwiseComplement(int N) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return N ^ X;
    }*/
}
