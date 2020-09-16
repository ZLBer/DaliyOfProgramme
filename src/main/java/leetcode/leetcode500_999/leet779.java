package leetcode.leetcode500_999;

public class leet779 {

    //mine
    public int kthGrammar(int N, int K) {
      if(K==1) return 0;
        int m=(1<<(N-1))/2;
     return K>m ? ( kthGrammar(N-1,K-m)==1?0:1):kthGrammar(N-1,K);
    }


    //还可以这么超级简化。详细见官方解答
  /*  public int kthGrammar(int N, int K) {
        return Integer.bitCount(K - 1) % 2;
    }*/

}
