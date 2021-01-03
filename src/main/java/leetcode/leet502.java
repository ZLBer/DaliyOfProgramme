package leetcode;

import java.util.PriorityQueue;

public class leet502 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int []> priorityQueue=new PriorityQueue<>((a,b)->a[1]-b[1]);
        PriorityQueue<int []>priorityQueue1=new PriorityQueue<>((a,b)->b[0]-a[0]);

        for (int i = 0; i < Profits.length; i++) {
            priorityQueue.add(new int[]{Profits[i],Capital[i]});
        }
        while (k-->0){
           while (!priorityQueue.isEmpty()&&priorityQueue.peek()[1]<=W){
               int[] poll = priorityQueue.poll();
               priorityQueue1.add(new int[]{poll[0]});
           }

           if(!priorityQueue1.isEmpty()){
               int[] ints = priorityQueue1.poll();
               W+=ints[0];
           }else {
               break;
           }
        }
        return W;
    }
}
