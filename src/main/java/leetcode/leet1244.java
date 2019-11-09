package leetcode;

import java.util.*;

public class leet1244 {
    class Leaderboard {
     PriorityQueue<Integer> queue=new PriorityQueue<>(Comparator.reverseOrder());
     Map<Integer,Integer> map=new HashMap<>();
        public Leaderboard() {

        }

         public void addScore(int playerId, int score) {
             System.out.println("test");
             if (map.containsKey(playerId)) {
         int s=map.get(playerId);
         queue.remove(s);
        map.put(playerId,s+score);
        queue.add(s+score);
             }else {
                 map.put(playerId,score);
                 queue.offer(score);
             }
         System.out.println(queue.peek());
        }

        public int top(int K) {
            List<Integer> scores=new ArrayList<>();
            int k=K;
            int res=0;
            while (k-->0){
             int s=queue.poll();
             System.out.println(s);
             scores.add(s);
             res+=s;
            }
            for (Integer score : scores) {
                queue.offer(score);
            }
            return res;
        }

        public void reset(int playerId) {
             int s=map.get(playerId);
            queue.remove(s);
            map.remove(playerId);
        }
    }
}
