package leetcode._30Days;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            priorityQueue.add(stone);
        }
       while (priorityQueue.size()>1){
           int y=priorityQueue.poll();
           int x=priorityQueue.poll();
           if(x==y) continue;
           else {
               priorityQueue.add(y-x);
           }
       }
       return priorityQueue.isEmpty()?0:priorityQueue.poll();
    }
}
