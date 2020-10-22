package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class leet1606 {


    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>((a,b)->a[1]-b[1]);
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
       for(int i=0;i<k;i++){
           treeMap.put(i,0);
       }

       int []count=new int[arrival.length];
        for (int i = 0; i < arrival.length; i++) {
            int begin=arrival[i];

            while (!priorityQueue.isEmpty()&&priorityQueue.peek()[1]<=begin){
                int[] poll = priorityQueue.poll();
                treeMap.put(poll[0],poll[1]);
            }

            Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(i % k);

            if(entry==null) entry=treeMap.ceilingEntry(0);

            if(entry==null){
                continue; //无服务器可以处理
            }

            count[entry.getKey()]++;//统计次数

            treeMap.remove(entry.getKey());

            priorityQueue.add(new int[]{entry.getKey(),begin+load[i]});

        }

        int max=0;
        List<Integer> maxIndex=new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if(count[i]>max){
                max=count[i];
                maxIndex=new ArrayList<>();
                maxIndex.add(i);

            }else if(count[i]==max){
                maxIndex.add(i);
            }
        }
        return maxIndex;
    }













}
