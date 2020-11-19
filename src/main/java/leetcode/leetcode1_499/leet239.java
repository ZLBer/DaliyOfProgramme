package leetcode.leetcode1_499;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leet239 {

    //mine  优先级队列
  static   public int[] maxSlidingWindow(int[] nums, int k) {
      if(nums.length==0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int index = 0;
        while (index < k) {
            priorityQueue.add(nums[index]);
            index++;
        }
        res[0] = priorityQueue.peek();
        for (int i = 0; i + k < nums.length; i++) {
            priorityQueue.remove(nums[i]);
            priorityQueue.add(nums[i + k]);
            res[i+1] = priorityQueue.peek();
        }
        return res;
    }

   //双端队列
    //存序号的想法很巧妙
  /*  static   public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0) return new int[0];
        Deque<Integer> deque=new ArrayDeque<>();
        int index=0;
        int []res=new int[nums.length-k+1];
        for (int i = 0; i < nums.length; i++) {
         while (!deque.isEmpty()&&deque.peek()<i-k+1){
              deque.poll();
         }
         while (!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
             deque.pollLast();
            }
          deque.offer(i);
             if(i>=k-1){
               res[index++]=nums[deque.peek()];
            }
        }
        return res;
     }*/


  //动态规划
    //https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetcode-3/
    public static int[] slidingWindowMax( int[] in,  int w) {
        if(in.length==0) return new int[0];
        final int[] max_left = new int[in.length];
        final int[] max_right = new int[in.length];

        max_left[0] = in[0];
        max_right[in.length - 1] = in[in.length - 1];

        for (int i = 1; i < in.length; i++) {
            max_left[i] = (i % w == 0) ? in[i] : Math.max(max_left[i - 1], in[i]);

            final int j = in.length - i - 1;
            max_right[j] = (j % w == 0) ? in[j] : Math.max(max_right[j + 1], in[j]);
        }

        final int[] sliding_max = new int[in.length - w + 1];
        for (int i = 0, j = 0; i + w <= in.length; i++) {
            sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
        }

        return sliding_max;
    }
    public static void main(String[] args) {
        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}
