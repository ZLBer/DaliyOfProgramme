package leetcode;

import java.util.Arrays;

/**
 * Created by libin on 2019/1/14.
 */
public class leet908 {
    //利用系统函数排序
 /*   public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);

        return Math.max(0,A[A.length-1]-A[0]-2*K);
    }*/

    //自己排序
    public int smallestRangeI(int[] A, int K) {
        int mx = A[0], mn = A[0];
        for (int a : A) {
            mx = Math.max(mx, a);
            mn = Math.min(mn, a);
        }
        return Math.max(0, mx - mn - 2 * K);
    }
}
