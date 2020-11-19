package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leet1619 {
    public double trimMean(int[] arr) {
     int len= (int) (arr.length*0.05);
        PriorityQueue<Integer> max=new PriorityQueue<>();
        PriorityQueue<Integer> min=new PriorityQueue<>(Comparator.reverseOrder());
        int sum=0;
        for (int i : arr) {
          sum+=i;
          max.add(i);min.add(i);
          if(max.size()>len) max.poll();
          if(min.size()>len) min.poll();

        }
       int temp=0;
        while (!max.isEmpty()&&!min.isEmpty()){
            temp+=(max.poll()+min.poll());
        }
       return (double)(sum-temp)/(arr.length-len-len);
    }
}
