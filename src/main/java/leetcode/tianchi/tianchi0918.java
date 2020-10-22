package leetcode.tianchi;

import java.util.ArrayDeque;
import java.util.Deque;

public class tianchi0918 {

    //错误的方法  因为有负数存在，双指针是不行的
/*    public int shortestSubarray(int[] A, int K) {

        int j=0;
        int sum=0;
        int res=Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
           while (j<A.length&&sum<K){
              sum+=A[j++];
           }
           if(sum>=K) res=Math.min(res,j-i);

           sum-=A[i];
        }
        return res==Integer.MAX_VALUE?-1:res;
    }*/


//单调递增队列
    public int shortestSubarray(int[] A, int K) {
        Deque<Integer> deque=new ArrayDeque<>();
       int []preSum=new int[A.length+1];
       for (int i = 1; i <= A.length; i++) {
         preSum[i]=preSum[i-1]+A[i-1];
        }
       deque.addLast(0);
       int res=Integer.MAX_VALUE;
       for (int i = 1; i <= A.length; i++) {
          while (!deque.isEmpty()&&preSum[i]<=preSum[deque.peekLast()]){
             deque.pollLast();
          }
          while (!deque.isEmpty()&& preSum[i]-preSum[deque.peekFirst()]>=K){
           res=Math.min(res,i-deque.pollFirst());
          }
          deque.addLast(i);
        }
       return res==Integer.MAX_VALUE?-1:res;
    }



/*
  //TreeMap
    public int shortestSubarray(int[] A, int K) {
        int sum = 0, result = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, -1);
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            //寻找合适的
            Map.Entry<Integer, Integer> floorEntry = map.floorEntry(sum - K);
            if (floorEntry != null && i - floorEntry.getValue() < result)
                result = i - floorEntry.getValue();
           //删除没用的key   因为比当前sum大的一定不会再用到了
            //也是相当于维持一个比sum小的不单调队列
            while (map.size() > 0 && map.lastKey() > sum) map.pollLastEntry();
            map.put(sum, i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
*/


}
