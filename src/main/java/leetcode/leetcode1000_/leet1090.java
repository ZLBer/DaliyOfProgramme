package leetcode.leetcode1000_;

import java.util.HashMap;
import java.util.Map;

public class leet1090 {
    // 看成values为set了
  /*  public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        PriorityQueue<Map.Entry<Integer,Integer>> queue =new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -o1.getKey()+o2.getKey();
            }
        });

        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<values.length;i++){
         map.put(values[i],labels[i]);
        }

       for(Map.Entry<Integer,Integer> entry: map.entrySet()){
           queue.add(entry);
       }
      int result=0;
       Map<Integer,Integer> useLable=new HashMap<>();
       while (num_wanted>0){
         Map.Entry<Integer,Integer> entry=  queue.poll();
           System.out.println(entry.getKey());
        if( useLable.getOrDefault(entry.getValue(),0)<use_limit){
            result+=entry.getKey();
            useLable.put(entry.getValue(),map.getOrDefault(entry.getValue(),0)+1);
            num_wanted--;
        }

       }
       return result;
    }*/

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
    //排序
        for(int i=0;i<values.length;i++){
            //寻找最大
            int max=values[i];
            int maxIndex=i;
            for(int j=i+1;j<values.length;j++){
                if(values[j]>max) {
                    maxIndex=j;
                    max=values[j];
                }
            }
            if(i!=maxIndex){
                //交换value
                int temp=values[i];
                values[i]=values[maxIndex];
                values[maxIndex]=temp;

                //交换lable
                temp=labels[i];
                labels[i]=labels[maxIndex];
                labels[maxIndex]=temp;
            }
        }
        for(int i=0;i<values.length;i++){
            System.out.println(values[i]+"   "+labels[i]);
        }
   Map<Integer,Integer> used=new HashMap<>();
        int result=0;
        for(int i=0;i<values.length&&num_wanted>0;i++){
            if(used.getOrDefault(labels[i],0)<use_limit){
             result+=values[i];
             num_wanted--;
             used.put(labels[i],used.getOrDefault(labels[i],0)+1);
            }
        }
        return result;
    }

}
