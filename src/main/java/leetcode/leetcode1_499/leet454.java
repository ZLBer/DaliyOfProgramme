package leetcode.leetcode1_499;

import java.util.HashMap;
import java.util.Map;

public class leet454 {

    //TLE 46/48
/*    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < C.length; j++) {
                for (int k = 0; k < D.length; k++) {
                  int sum=B[i]+C[j]+D[k];
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
        }


        int res=0;
        for (int i = 0; i < A.length; i++) {
            int need=0-A[i];
            res+=map.getOrDefault(need,0);
        }
        return res;
    }*/

    //mine 这样就可以过了  O（n2）
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < C.length; j++) {
                    int sum=B[i]+C[j];
                    map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }


        int res=0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int need=0-A[i]-D[j];
                res+=map.getOrDefault(need,0);
            }
        }
        return res;
    }
}
