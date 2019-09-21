package leetcode.leetcode500_999;

import java.util.*;

public class leet954 {
    //mine  用优先级队列做，反正很慢就是了
/*    public boolean canReorderDoubled(int[] A) {
      //  int i=0;
    //    Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((a,b)->(-(a-b)) );
   //     Set<Integer> set=new HashSet<>();
        for(int a:A){
         //   map.put(a,map.getOrDefault(a,0)+1);
            priorityQueue.add(a);
        }

//        for(Integer key:map.keySet()){
//      priorityQueue.add(key);
//        }

        while (!priorityQueue.isEmpty()){
             int a=priorityQueue.poll();
            System.out.println(a);
             if(a<0) {
                 if(priorityQueue.contains(a/2))
                      priorityQueue.remove(a/2);
                 else return false;
             }
             else {
                 if(priorityQueue.contains(a*2))
                     priorityQueue.remove(a*2);
                 else return false;
             }

        }


return true;
    }*/

    // 用treemap实现
    public boolean canReorderDoubled(int[] A) {
          Map<Integer,Integer> map=new TreeMap<>();
          for(int a:A){
              map.put(a,map.getOrDefault(a,0)+1);
          }
          for(Integer key:map.keySet()){
              if(map.get(key)==0) continue;
              int want=key<0?key/2:key*2;
              if(map.getOrDefault(want,0)<map.get(key)){
                  return false;
              }
              map.put(want,map.get(want)-map.get(key));
              map.put(key,0);//此步其实无用，因为此后不会考虑这个点了
          }
          return true;
    }


  //先排序，然后用hashmap做
  /*  public boolean canReorderDoubled(int[] A) {

        int n = A.length;
        if (n % 2 != 0) return false;
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>(); // <num, freq>
        for (int item : A) {
            if (item == 0) continue;
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (A[i] != 0 && map.get(A[i]) > 0) {
                //System.out.println("map: " + map);
                int target = A[i] * 2; // (3). positive, target = 2x
                if (A[i] < 0) { // (2) for negative (-4), the match should be half of it.
                    if (A[i] % 2 != 0) { // A[i] = -7, A[i] / 2 = -3
                        return false;
                    } else {
                        target = A[i] / 2; // negative: target = x
                    }
                }
                if (map.getOrDefault(target, 0) < map.get(A[i])) {
                    return false;
                } else {
                    // (4) once matched, update the map
                    map.put(target, map.get(target)  - map.get(A[i]));
                    map.put(A[i], 0);
                }
            }
        }
        //System.out.println("map: " + map);
        return true;


    }*/
}
