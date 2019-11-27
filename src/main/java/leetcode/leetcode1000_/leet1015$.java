package leetcode.leetcode1000_;

/**
 * Created by libin on 2019/3/29.
 */
public class leet1015$ {
    //    public int smallestRepunitDivByK(int K) {
//        Integer ls[]={1,11,111,1111,11111,111111,1111111,11111111,111111111,1111111111};
//
//        for(int i=0;i<ls.length;i++){
//            if(ls[i]%K==0) return i+1;
//        }
//
//        return -1;
//    }
//}
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) return -1;
        int r = 0;
        for (int N = 1; N <= K; ++N) {
            r = (r * 10 + 1) % K;
            if (r == 0) return N;
        }
        return -1;
    }
}
