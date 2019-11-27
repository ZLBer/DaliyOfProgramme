package leetcode.leetcode1000_;

/**
 * Created by libin on 2019/4/7.
 */
public class leet1009 {
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
