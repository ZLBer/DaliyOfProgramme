package leetcode.leetcode1000_1499;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leet1353 {
    //mine 错误的答案
 /*   public int maxEvents(int[][] events) {

        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1]==b[1]?a[0]-b[0]:a[1]-b[1];
            }
        });
        int start=1;
        int res=0;
        for (int i = 0; i < events.length; i++) {
            if(start<events[i][0]) start=events[i][0];
         if(start<=events[i][1]){
            res++;
            start++;
        }
    }
        return res;

}*/
    // 优先级队列保存end
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (int []a,int [] b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
       int i=0,res=0;
        for(int d=1;d<=100000;d++){
            while (priorityQueue.size()>0&&priorityQueue.peek()<d){
                priorityQueue.poll();
            }
            while (i<events.length&&events[i][0]==d){
                priorityQueue.offer(events[i][1]);
                i++;
            }
            if(priorityQueue.size()>0){
                priorityQueue.poll();
                res++;
            }
        }
        return  res;
    }

//不遍历d
/*    public int maxEvents(int[][] events) {
        Arrays.sort(events, (int []a,int [] b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        int i=0,res=0,d=1;
        while (priorityQueue.size()>0||i<events.length){
            if(priorityQueue.size()==0){
              d=events[i][0];
            }
            while (i<events.length&&events[i][0]==d){
                priorityQueue.offer(events[i][1]);
                i++;
            }
            priorityQueue.poll();
            res++;
            d++;
            while (priorityQueue.size()>0&&priorityQueue.peek()<d){
                priorityQueue.poll();
            }
        }
        return res;
    }*/
}
