package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet1636 {

    public int[] frequencySort(int[] nums) {
       Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<int[]> list=new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(),entry.getValue()});
        }
        Collections.sort(list,(a,b)->a[1]==b[1]?b[0]-a[0]:a[1]-b[1]);

        int i=0;
        for (int[] ints : list) {
            for (int j = 0; j < ints[1]; j++) {
                nums[i++]=ints[0];
            }
        }
        return nums;
    }
}
