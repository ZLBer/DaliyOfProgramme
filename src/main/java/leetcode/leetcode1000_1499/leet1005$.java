package leetcode.leetcode1000_1499;

import java.util.Arrays;

/**
 * Created by libin on 2019/3/21.
 */
public class leet1005$ {
    // genius
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
    for(int i=0;i<A.length && K>0 && A[i]<0;i++,K--){
        A[i]=-A[i];
    }
    int sum=0;
        int min=Integer.MAX_VALUE;
         for(int a:A){
   sum+=a;
   min=Math.min(min,a);
         }
         return sum-K%2*min*2;
    }


    //用优先级队列做
    //发现每次都是把最小的元素取反
 /*   public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int x: A) pq.add(x);
        while( K--  > 0) pq.add(-pq.poll());

        int sum  = 0;
        for(int i = 0; i < A.length; i++){
            sum += pq.poll();
        }
        return sum;
    }*/
}
