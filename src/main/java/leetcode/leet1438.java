package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class leet1438 {

    //mine 两个单调栈
   static public int longestSubarray(int[] nums, int limit) {


        Deque<Integer> minDeque=new ArrayDeque<>();
        Deque<Integer> maxDeque=new ArrayDeque<>();
        int from=0;
        int res=0;
        for (int i = 0; i < nums.length; i++) {
           while (!minDeque.isEmpty()&&minDeque.peekLast()>nums[i]){
               minDeque.pollLast();
           }
           minDeque.addLast(nums[i]);

           while (!maxDeque.isEmpty()&&maxDeque.peekLast()<nums[i]){
               maxDeque.pollLast();
           }
           maxDeque.addLast(nums[i]);

            while (maxDeque.peekFirst()-minDeque.peekFirst()>limit){
               if(minDeque.peekFirst()==nums[from]) minDeque.pollFirst();
               if(maxDeque.peekFirst()==nums[from]) maxDeque.pollFirst();
                from++;
            }

            res=Math.max(res,i-from+1);

        }
        return res;
    }


    //Treemap维护
/*    public int longestSubarray(int[] A, int limit) {
        int i = 0, j;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (j = 0; j < A.length; j++) {
            m.put(A[j], 1 + m.getOrDefault(A[j], 0));
            if (m.lastEntry().getKey() - m.firstEntry().getKey() > limit) {
                m.put(A[i], m.get(A[i]) - 1);
                if (m.get(A[i]) == 0)
                    m.remove(A[i]);
                i++;
            }
        }
        return j - i;
    }*/
    public static void main(String[] args) {
        longestSubarray(new int[]{8,2,4,7},4);
    }
}
