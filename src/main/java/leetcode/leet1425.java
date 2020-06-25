package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class leet1425 {

    //mine dp超时了？？
/*    public int constrainedSubsetSum(int[] nums, int k) {
      int []dp=new int[nums.length];
      dp[0]=nums[0];
      int max=dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=nums[i];
            for(int j=i-1;j>=0&&j>=(i-k);j--){
               dp[i]=Math.max(dp[i],dp[j]+nums[i]);
             }
            max=Math.max(max,dp[i]);
        }
        return max;
    }*/


    //滑动窗口优化  priorityQueue 超时
/*    public int constrainedSubsetSum(int[] nums, int k) {
        int []dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.add(dp[0]);
        for (int i = 1; i < nums.length; i++) {
             int  maxDp=priorityQueue.peek();
            dp[i]=nums[i]+Math.max(0,maxDp);

            priorityQueue.add(dp[i]);
            if(i-k>=0) priorityQueue.remove(dp[i-k]);

            max=Math.max(max,dp[i]);
        }
        return max;
    }*/

    //滑动窗口优化 双端队列
    public int constrainedSubsetSum(int[] nums, int k) {
        int []dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        Deque<Integer>deque=new ArrayDeque<>();
        deque.addLast(max);
        for (int i = 1; i < nums.length; i++) {
            int  maxDp=deque.getFirst();
            dp[i]=nums[i]+Math.max(0,maxDp);

            while (!deque.isEmpty()&&deque.getLast()<dp[i]){
                deque.removeLast();
            }
            deque.addLast(dp[i]);
            if(i-k>=0&&deque.getFirst()==dp[i-k]) deque.removeFirst();

            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
