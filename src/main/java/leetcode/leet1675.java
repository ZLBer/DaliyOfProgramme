package leetcode;

import java.util.TreeSet;

public class leet1675 {


    public int minimumDeviation(int[] nums) {
      TreeSet<Integer> set=new TreeSet<>();

        for (int num : nums) {
            set.add(num%2==0?num:num*2);
        }

      int dis=set.last()-set.first();
      while (dis>0&&set.last()%2==0){
          int max=set.last();
          set.remove(max);
          set.add(max/2);
          dis=Math.min(dis,set.last()-set.first());
      }
      return dis;

    }
}
