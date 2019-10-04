package leetcode;


import java.util.*;

public class leet347 {
   /* public List<Integer> topKFrequent(int[] nums, int k) {
      List<Integer> result=new ArrayList<>();
        Map<Integer,Integer>map=new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

     List<Integer> freq=new ArrayList<>();
      for(int fre:map.values()){
             freq.add(fre);
      }
      Collections.sort(freq, new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
              return -(o1-o2);
          }
      });

      Set<Integer> set=new HashSet<>();
      for(int i=0;i<k;i++){
          set.add(freq.get(i));
      }
      for(int key:map.keySet()){
          if(set.contains(map.get(key)))
              result.add(key);
      }

return result;
    }*/


 //桶排序
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result=new ArrayList<>();
        Map<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer>[]bucket=new ArrayList[nums.length+1];
        for(int key:map.keySet()){
            int freq=map.get(key);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        for(int i=bucket.length-1;k>0;i--){
            if(bucket[i]!=null){
                for(int a:bucket[i]){
                    result.add(a);
                }
                k-=bucket[i].size();
            }
        }
        return result;
    }


    //其实就是吧entry放进优先队列里  PriorityQueue使用堆实现的
    // use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
  /*      public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int n: nums){
                map.put(n, map.getOrDefault(n,0)+1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                    new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                maxHeap.add(entry);
            }

            List<Integer> res = new ArrayList<>();
            while(res.size()<k){
                Map.Entry<Integer, Integer> entry = maxHeap.poll();
                res.add(entry.getKey());
            }
            return res;
        }*/


        //和上面的方法类似  treeMap是用红黑树实现的
    // use treeMap. Use freqncy as the key so we can get all freqencies in order
    /*    public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int n: nums){
                map.put(n, map.getOrDefault(n,0)+1);
            }

            TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
            for(int num : map.keySet()){
                int freq = map.get(num);
                if(!freqMap.containsKey(freq)){
                    freqMap.put(freq, new LinkedList<>());
                }
                freqMap.get(freq).add(num);
            }

            List<Integer> res = new ArrayList<>();
            while(res.size()<k){
                Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
                res.addAll(entry.getValue());
            }
            return res;
        }*/

}
