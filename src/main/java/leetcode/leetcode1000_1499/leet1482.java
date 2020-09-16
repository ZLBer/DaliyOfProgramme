package leetcode.leetcode1000_1499;

public class leet1482 {


    //mine  想法直接错了
/*
  static   public int minDays(int[] bloomDay, int m, int k) {
 Map<Integer, List<Integer>> map=new TreeMap<>();
        for (int i = 0; i < bloomDay.length; i++) {
            if(!map.containsKey(bloomDay[i])){
                map.put(bloomDay[i],new ArrayList<>());
            }
            map.get(bloomDay[i]).add(i);
        }


        Queue<Integer> bloomQueue=new PriorityQueue<>();



        for (Integer key : map.keySet()) {
            for (Integer v : map.get(key)) {
                bloomQueue.add(v);
                bloomDay[v]=0; //表示已经开花了
            }
            Queue<Integer> newQueue=new PriorityQueue<>();
            while (bloomQueue.size()>=k){
                int day=bloomQueue.poll();
                if(bloomDay[day]<0) continue;
                if(check(bloomDay,day,k)){
                   m--;
                }else {
                   newQueue.add(day);
                }
            }
            for (Integer integer : bloomQueue) {
               if(bloomDay[integer]==0) newQueue.add(integer);
            }
           bloomQueue=newQueue;

            if(m<=0) return key;
        }
        return -1;
    }

 static    boolean check(int []bloomDay,int begin,int k){
            int i=0;
            for(;i<k;i++){
                if(bloomDay[i+begin]==0) continue;
                else break;
            }
          if(i==k){
              for(i=0;i<k;i++){
                  bloomDay[i+begin]=-1;
              }
          }
       return i==k;     
    }
*/

    //直接二分法硬做
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length, left = 1, right = (int)1e9;
        if (m * k > n) return -1;
        while (left < right) {
            int mid = (left + right) / 2, flow = 0, bouq = 0;
            for (int j = 0; j < n; ++j) {
                if (bloomDay[j] > mid) {
                    flow = 0;
                } else if (++flow >= k) {
                    bouq++;
                    flow = 0;
                }
            }
            if (bouq < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
       // minDays(new int[]{30,49,11,66,54,22,2,57,35},3,3);
    }

}
