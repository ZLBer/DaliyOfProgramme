package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leet1383 {
    //mine  tle   52/53  但有很大优化空间
 /*   public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod=1000000000+7;
        int [][] composition=new int[speed.length][2];
        for (int i = 0; i < speed.length; i++) {
            composition[i][0]=speed[i];
            composition[i][1]=efficiency[i];
        }

        //按照效率倒叙排列
        Arrays.sort(composition, Comparator.comparing(a->-a[1]));
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        long maxRes=0;
        for (int i = 0; i < composition.length; i++) {
            priorityQueue.offer(composition[i][0]);
            //首先填满k个
            if(i<k){
                long sumEfficiency=0;
                for(int ef:priorityQueue){
                    sumEfficiency+=ef;
                }
                maxRes=Math.max((sumEfficiency*composition[i][1]),maxRes);
                System.out.println(maxRes);
              }
            //然后开始比较
            else {
               //选最大的k个
                priorityQueue.poll();
                long sumEfficiency=0;
                for(int ef:priorityQueue){
                    sumEfficiency+=ef;
                }
                maxRes=Math.max((sumEfficiency*composition[i][1]),maxRes);
             }
        }
        return (int)(maxRes%mod);
    }*/


    //mine   优化之后
/*    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod=1000000000+7;
        int [][] composition=new int[speed.length][2];
        for (int i = 0; i < speed.length; i++) {
            composition[i][0]=speed[i];
            composition[i][1]=efficiency[i];
        }
        //按照效率倒叙排列
        Arrays.sort(composition, Comparator.comparing(a->-a[1]));
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        long maxRes=0;
        long sumEfficiency=0;
        for (int i = 0; i < composition.length; i++) {
            priorityQueue.offer(composition[i][0]);
            sumEfficiency+=composition[i][0];
            //当不满足k个时
            if(i<k){
                maxRes=Math.max((sumEfficiency*composition[i][1]),maxRes);
            }
           //大于k个时
            else {
                //需要删除一个最小的
                int del=priorityQueue.poll();
                sumEfficiency-=del;
                maxRes=Math.max((sumEfficiency*composition[i][1]),maxRes);
            }
        }
        return (int)(maxRes%mod);
    }*/

    //mine   再优化
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod=1000000000+7;
        int [][] composition=new int[speed.length][2];
        for (int i = 0; i < speed.length; i++) {
            composition[i][0]=speed[i];
            composition[i][1]=efficiency[i];
        }
        //按照效率倒叙排列
        Arrays.sort(composition, (a,b)->b[1]-a[1]); //注意了  这种方式比Comparator.comparing效率高
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        long maxRes=0;
        long sumEfficiency=0;
        for (int i = 0; i < composition.length; i++) {
            priorityQueue.offer(composition[i][0]);
            sumEfficiency+=composition[i][0];
              if(i>=k)  sumEfficiency-=priorityQueue.poll();
                maxRes=Math.max((sumEfficiency*composition[i][1]),maxRes);
        }
        return (int)(maxRes%mod);
    }
}
