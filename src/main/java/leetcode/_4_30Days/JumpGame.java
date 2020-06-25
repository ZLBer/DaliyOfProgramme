package leetcode._4_30Days;

public class JumpGame {

    //TLE
/*    public boolean canJump(int[] nums) {
     Queue<Integer> queue=new LinkedList<>();
     queue.add(0);
     if(nums.length==1) return true;
     Set<Integer> set=new HashSet<>();
     set.add(0);
     while (!queue.isEmpty()){
       int size=queue.size();
       while (size-->0){
        int index=queue.poll();
        for(int i=index+1;i<=index+nums[index];i++){
             if(i>=nums.length-1) return true;

             if(!set.contains(i)){
                 set.add(i);
                 queue.add(i);
             }
        }
       }

     }

     return false;
    }*/

    //贪心
    public boolean canJump(int[] nums) {
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            if(i>max) return false;
            max=Math.max(max,i+nums[i]);
        }
        return true;
    }
}
