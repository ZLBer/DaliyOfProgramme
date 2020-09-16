package leetcode.leetcode1000_1499;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class leet1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Queue<Map.Entry> queue=new PriorityQueue<>((a,b)->(int)a.getValue()-(int)b.getValue());
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            queue.add(integerIntegerEntry);
        }


        int count=0;
       while (k>0){
         k-=(int)queue.poll().getValue();
        if(k==0) break;
        else if(k<0){
      count++;
        }
       }
       return queue.size()+count;
    }
}
