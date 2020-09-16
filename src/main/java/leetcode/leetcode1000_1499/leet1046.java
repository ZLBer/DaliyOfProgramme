package leetcode.leetcode1000_1499;


import java.util.Collections;
import java.util.PriorityQueue;

public class leet1046 {
   /* public int lastStoneWeight(int[] stones) {
        if(stones.length==1) return stones[0];
        Arrays.sort(stones);
       int pre=stones.length-2;
       int temp=stones[stones.length-1];
        while (pre>0){
            if(stones[pre]<=temp||stones[pre-1]<=temp){
                int y=temp;
                int x=stones[pre];
                temp=Math.abs(y-x);
                if(temp==0){
                    temp=stones[pre-1];
                    pre-=2;
                }
                else {
                    pre--;
                }

            }
            else {
                int y=stones[pre];
                int x=stones[pre-1];
                pre-=2;
            }
        }
        if(pre<0) return temp;
       else return Math.abs(stones[pre]-temp);
    }*/
   public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
for(int i:stones){
    pq.offer(i);
}
while (pq.size()>1){
    int y=pq.poll();
    int x=pq.poll();
    if(x==y) continue;
    else pq.offer(y-x);
}
return pq.size()==0?0:pq.peek();

   }
}
