package leetcode.leetcode500_999;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by libin on 2019/4/21.
 */
public class leet945 {
    //mine Time Limit Exceeded  用set直接查找
  /*  public int minIncrementForUnique(int[] A) {
        Set<Integer> set=new TreeSet<>();
       int move=0;
       for (int a:A){
         while (set.contains(a)){
             a++;
             move++;
         }
         set.add(a);

       }


        return move;
    }*/



//排序后遍历
/*    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res=0;
        int need=0;
        for(int a:A){
      res+=Math.max(need-a,0);
      need=Math.max(a,need)+1;
        }
        return res;

    }*/
    //用map存贮相同键值的数目，然后一次算一片
    public int minIncrementForUnique(int[] A) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int a : A) count.put(a, count.getOrDefault(a, 0) + 1);
        int res = 0, need = 0;
        for (int x: count.keySet()) {
            int v = count.get(x);
            res += v * Math.max(need - x, 0) + v * (v - 1) / 2;
            need = Math.max(need, x) + v;
        }
        return res;
    }
}
