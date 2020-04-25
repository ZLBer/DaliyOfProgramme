package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class leet1408 {
    public List<String> stringMatching(String[] words) {
        PriorityQueue<String> priorityQueue=new PriorityQueue<>((a,b)->a.length()-b.length());
        for (String word : words) {
            priorityQueue.add(word);
        }

        List<String> result=new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            String ket=priorityQueue.poll();

            for(String p:priorityQueue){
                if(p.contains(ket)){
                 result.add(ket);
                 break;
                }
            }
        }
        return result;
    }
}
