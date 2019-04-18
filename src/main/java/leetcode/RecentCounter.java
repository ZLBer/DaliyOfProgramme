package leetcode;

import java.util.*;

/**
 * Created by libin on 2019/4/18.
 */
  public class RecentCounter {
      List<Integer> pingList= new LinkedList<>();
    public RecentCounter() {

    }

    public int ping(int t) {
       pingList.add(t);
     while (t-pingList.get(0)>3000){
    pingList.remove(0);
     }
     return pingList.size();
    }



  /*  //时间复杂度 logN  ，实际效果并不理想
    TreeMap<Integer, Integer> tm;

    public RecentCounter() {
        tm = new TreeMap<>();
    }

    public int ping(int t) {
        tm.put(t, 1 + tm.size());
        //tailMap返回>=fromKey的视图
        return tm.tailMap(t - 3000).size();
    }*/


  //logN 二分搜索  ，实际效果也不是很理想
   /* List<Integer> list;

    public RecentCounter() {
        list = new ArrayList<>();
    }

    public int ping(int t) {
        list.add(t);
        int index = Collections.binarySearch(list, t - 3000); // search the index of t - 3000.
        if (index < 0) { index = -index - 1; } // if t - 3000 is not in list, use the index of the ceiling of t - 3000.
        return list.size() - index;
    }*/
}
