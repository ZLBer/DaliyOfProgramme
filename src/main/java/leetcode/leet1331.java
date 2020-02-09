package leetcode;

import java.util.*;

public class leet1331 {
        public int[] arrayRankTransform(int[] arr) {
           int []sort= Arrays.copyOf(arr,arr.length);
            Arrays.sort(sort);
            Map<Integer,Integer> rank=new HashMap<>();
            for(int x:sort) rank.putIfAbsent(x,rank.size()+1);
            for (int i = 0; i < arr.length; i++) {
                arr[i]=rank.get(arr[i]);
            }
            return arr;
        }


        //比较传统的方法 先记录index 然后排序 最后重组
   /* public int[] arrayRankTransform(int[] arr) {
        int[] res = new int[arr.length];
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            temp.add(new int[]{arr[i], i}); // store : [value, index]
        }
        Collections.sort(temp, (a, b) -> a[0] - b[0]);
        int rank = 1;
        for (int i = 0; i < temp.size(); i++) {
            int idx = temp.get(i)[1];
            if (i == 0 || temp.get(i)[0] == temp.get(i - 1)[0]) {
                res[idx] = rank;
            } else {
                res[idx] = ++rank;
            }
        }
        return res;
    }
*/
}
