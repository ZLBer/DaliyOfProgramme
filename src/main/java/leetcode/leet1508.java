package leetcode;

import java.util.PriorityQueue;

public class leet1508 {
    class Pair{
       int sum;
       int index;


        public  Pair(int sum,int index){
          this.sum=sum;
          this.index=index;
       }
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Pair> priorityQueue=new PriorityQueue<>((a,b)->a.sum-b.sum);
        for (int i = 0; i < nums.length; i++) {
           priorityQueue.add(new Pair(nums[i],i));
        }

        int mod=1000_000_007;
      int res=0;
        for(int i=1;i<=right;i++){
        Pair pair=priorityQueue.poll();

        if(i>=left) res=(res+pair.sum)%mod;

         if(pair.index<nums.length-1){
            pair.index++;
           pair.sum+=nums[pair.index];
             priorityQueue.add(pair);
         }


        }
        return res;
    }
}
