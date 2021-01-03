package leetcode;

import java.util.Arrays;

public class leet473 {
    //贪心不太行啊
/*    public boolean makesquare(int[] nums) {
        if (nums.length == 0) return false;
        int sum = Arrays.stream(nums).sum();
        int per = sum / 4;
        if (per * 4 != sum) return false;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < 4; i++) {
            priorityQueue.add(0);
        }
        for (int i = nums.length-1; i >=0; i--) {
            int min = priorityQueue.poll();
            priorityQueue.add(min + nums[i]);
        }
        int pre = priorityQueue.peek();
        while (!priorityQueue.isEmpty()) {
            if (pre != priorityQueue.poll()) return false;
        }
        return true;
    }*/
    public boolean makesquare(int[] nums) {
        boolean []visted=new boolean[nums.length];
        if (nums.length == 0) return false;
        int sum = Arrays.stream(nums).sum();
        int per = sum / 4;
        if (per * 4 != sum) return false;
  return dfs(0,per,0,1,nums,visted);
    }

    boolean dfs(int sum,int taget,int index,int step,int []nums,boolean[]visited){
       if(sum==taget) {
         if(step==4) return true;
        else   return dfs(0,taget,0,step+1,nums,visited);
       }
       if(index>=nums.length||sum>taget) return false;

       for(int i=index;i<nums.length;i++){
           if(visited[i]) continue;
           visited[i]=true;
         if(dfs(sum+nums[i],taget,i+1,step,nums,visited)){
             return true;
         }
         visited[i]=false;
       }
       return false;
    }




}
