package leetcode;

import leetcode.LQTest.A;

import java.util.*;
import java.util.stream.IntStream;

public class leet1146 {

    //Memory Limit Exceeded
/*    class SnapshotArray {
        int[] cur;
        List<int[]> catching=new ArrayList<>();
        public SnapshotArray(int length) {
         cur=new int[length];
        }

        public void set(int index, int val) {
          cur[index]=val;
        }

        public int snap() {
            int []snap=new int[cur.length];
            System.arraycopy(cur,0,snap,0,snap.length);
         catching.add(snap);
            return catching.size()-1;
        }

        public int get(int index, int snap_id) {
           int []snap=catching.get(snap_id);
           return snap[index];
        }
    }*/


//mine  HashMap
  /*  class SnapshotArray {
        Map<Integer,Integer> cur;
        List<Map<Integer,Integer>> catching=new ArrayList<>();
        public SnapshotArray(int length) {
            cur=new HashMap<>();
        }

        public void set(int index, int val) {
           cur.put(index,val);
        }

        public int snap() {
         catching.add(cur);
         cur=new HashMap<>(cur);
         return  catching.size()-1;
        }

        public int get(int index, int snap_id) {
            return catching.get(snap_id).getOrDefault(index,0);
        }
    }*/


  //  HashMap不用复制初始化
/*    class SnapshotArray {
    private List<Map<Integer, Integer>> shot;
    private Map<Integer, Integer> diff;

    public SnapshotArray(int length) {
        shot = new ArrayList<>(length);
        diff = new HashMap<>(length);
    }

    public void set(int index, int val) {
        diff.put(index, val);
    }

    public int snap() {
        shot.add(diff);
        diff = new HashMap<>();
        return shot.size() - 1;
    }

    public int get(int index, int snap_id) {
        for (int i = snap_id; i >= 0; --i)
            if (shot.get(i).containsKey(index))
                return shot.get(i).get(index);
        return 0;
    }
}*/

  // TreeMap
class SnapshotArray {
    private int count;
    private List<TreeMap<Integer, Integer>> shot = new ArrayList<>();

    public SnapshotArray(int length) {
        IntStream.range(0, length).forEach(i -> {
            shot.add(new TreeMap<>());
        });
    }

    public void set(int index, int val) {
        shot.get(index).put(count, val);
    }

    public int snap() {
        return count++;
    }

    public int get(int index, int snap_id) {
        Integer key = shot.get(index).floorKey(snap_id);
        return key == null ? 0 : shot.get(index).get(key);
    }
}
}
