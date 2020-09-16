package leetcode.leetcode1000_1499;

import java.util.*;

public class leet1207 {

    //mine 先排序后set
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        int index = 1;
        int count = 1;
        while (index < arr.length) {
            if (arr[index] == arr[index - 1]) {
                index++;
                count++;
            } else {
                if (set.contains(count)) return false;
                set.add(count);
                count = 1;
                index++;
            }
        }
        if (set.contains(count)) return false;
        return true;
    }

    //map 和set
   /* public boolean uniqueOccurrences(int[] arr) {
       Map<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
             map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Set<Integer> set=new HashSet<>(map.values());
        return set.size()==map.size();
    }*/
}
