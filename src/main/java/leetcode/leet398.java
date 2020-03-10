package leetcode;

import java.util.Random;

public class leet398 {

    //mine map存index
    /*  class Solution {
   Map<Integer, List<Integer>> map=new HashMap<>();
        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
           //   map.putIfAbsent(nums[i],new ArrayList<>());
            List<Integer> list=  map.computeIfAbsent(nums[i],k->new ArrayList<>());
          //      List<Integer> list=map.get(nums[i]);
                list.add(i);
            }
        }

        public int pick(int target) {
         List<Integer> list=map.get(target);
         int random=new Random().nextInt(list.size());
         return list.get(random);
        }
    }*/


    //当作蓄水池问题
    class Solution {
     int[]nums;
        public Solution(int[] nums) {
         this.nums=nums;
        }

        public int pick(int target) {
            int count=0;
            int res=0;
            Random random=new Random();
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]==target){
                  count++;
                  //count分之一
                  if(random.nextInt()%count==0) res=i;
                }
            }
            return res;
        }
       /* public int pick(int target) {
            int result = -1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != target)
                    continue;
                    //也是count分之一
                if (rnd.nextInt(++count) == 0)
                    result = i;
            }

            return result;
        }*/
    }
}
