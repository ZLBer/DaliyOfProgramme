package leetcode.LQTest;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by libin on 2018/3/29.
 */
public class bagBFS {
    int [] weight=new int[]{18,7,25,36};
    int [] value=new int[] {12,10,20,15};
    //    int [] weight=new int[]{3,2,2,1};
//    int [] value=new int[] {20,15,12,10};
    int capacity=36;
    static    int bestWeight;
    int temValue;
    int temWeight;
    Queue<Integer> queue=new LinkedList<>();
    void BFS(int layer){
        queue.add(-1);
      while(layer<weight.length){
         int curWeight= temWeight+weight[layer];
         if(curWeight<=capacity) {
             if(curWeight>bestWeight) bestWeight=curWeight;
             queue.add(curWeight);
         }

         queue.add(temWeight);

         temWeight=queue.poll();
         if(temWeight==-1){
             if(queue.isEmpty()) return;
             queue.add(-1);

             temWeight=queue.poll();
             layer++;
         }
      }
    }

    public static void main(String[] args) {
//        bagBFS t=new bagBFS();
//        t.BFS(0);
//        System.out.println(bestWeight);

                        BigDecimal a=new BigDecimal(2);
                        BigDecimal b=new BigDecimal(3);
                        for(int i=0;i<100;i++){
                            System.out.println(i);
                            a=a.multiply(a).subtract(b.multiply(b));
                            b=a.multiply(b).add(a.multiply(b));
                            System.out.println(a);
                        }


    }
}
