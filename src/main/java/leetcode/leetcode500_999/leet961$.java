package leetcode.leetcode500_999;

import leetcode.LQTest.A;

/**
 * Created by libin on 2019/1/14.
 */
public class leet961$ {
    //错误的解法
//    public int repeatedNTimes(int[] A) {
//        int node=A[0];
//        int count=1;
//      for(int i=1;i<A.length;i++){
//           int a=A[i];
//            if(a==node) count++;
//            else {
//                count--;
//                if(count==0) {
//                    node=a;
//                    count=1;
//                }
//            }
//        }
//        return node;
//    }
    //  、用数组记录个数
    public int repeatedNTimes(int[] A) {
    int[] count = new int[10000];
        for (int a : A)
            if (count[a]++ == 1)
            return a;
        return -1;
}
     //随机选取两个
/*    public int repeatedNTimes(int[] A) {
        int i = 0, j = 0, n = A.length;
        while (i == j || A[i] != A[j]) {
            i = (int)(Math.random() * n);
            j = (int)(Math.random() * n);
        }
        return A[i];
    }*/
}
