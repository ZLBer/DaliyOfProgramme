package leetcode;

import java.util.PriorityQueue;

public class leet1705 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int []>priorityQueue=new PriorityQueue<>((a,b)->a[0]-b[0]);
       int day=0;
       int res=0;
        for ( day = 0; day < apples.length; day++) {
        if(apples[day]!=0)
           priorityQueue.add(new int[]{day+days[day],apples[day]});

        while (!priorityQueue.isEmpty()&&priorityQueue.peek()[0]<=day){
               priorityQueue.poll();
        }

       if(!priorityQueue.isEmpty()) {
           priorityQueue.peek()[1]--;
           res++;
           if (priorityQueue.peek()[1] == 0) {
               priorityQueue.poll();//吃完了
           }
       }
        }

      while (!priorityQueue.isEmpty()){
          int[] poll = priorityQueue.poll();
       if(poll[0]<=day) continue;
        int d=Math.min(poll[0]-day,poll[1]); //可以吃多个 加快遍历
       res+=d;
       day+=d;

      }
      return res;
    }
}
