package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class leet1696 {
    //两重遍历超时
/*    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];

        int lastIndex=nums.length-1;
        for (int i = dp.length - 2; i >= 0; i--) {

            dp[i]=Integer.MIN_VALUE;

           // if(lastIndex-i>=k)

            for (int j = 1; j <= k && i + j < nums.length; j++) {
                   dp[i] = Math.max(dp[i], dp[i + j] + nums[i]);

            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            System.out.print(dp[i]+" ");
//            System.out.println(can[i]+" ");
//        }
        return dp[0];
    }*/

//用最大堆保存最大值
/*    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        priorityQueue.add(new int[]{dp[nums.length - 1], nums.length - 1});
        for (int i = dp.length - 2; i >= 0; i--) {

            //坐标超出范围
            while (priorityQueue.peek()[1] - i > k) {
                priorityQueue.poll();
            }

            dp[i] = nums[i] + priorityQueue.peek()[0];

            priorityQueue.add(new int[]{dp[i], i});
        }

//        for (int i = 0; i < dp.length; i++) {
//            System.out.print(dp[i]+" ");
//            System.out.println(can[i]+" ");
//        }
        return dp[0];
    }*/

    //单调队列也可以做  快于优先队列 O(n)
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = nums[nums.length - 1];

        Deque<int []> dequeue=new LinkedList<>();
        dequeue.addLast(new int[]{dp[nums.length-1],nums.length-1});
        for (int i = dp.length - 2; i >= 0; i--) {

            //坐标超出范围
            while (!dequeue.isEmpty()&&dequeue.peekFirst()[1] - i > k) {
                dequeue.pollFirst();
            }

            dp[i] = nums[i] + dequeue.peekFirst()[0];

            while (!dequeue.isEmpty()&&dequeue.peekLast()[0]<dp[i]){
                dequeue.pollLast();
            }

            dequeue.addLast(new int[]{dp[i], i});
        }

        return dp[0];
    }


}
