package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet1577 {
    public int numTriplets(int[] nums1, int[] nums2) {
      Map<Long,Integer> map1=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i+1; j < nums1.length; j++) {
              long mul=((long)nums1[i])*nums1[j];
                map1.put(mul,map1.getOrDefault(mul,0)+1);
            }
        }
        Map<Long,Integer> map2=new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i+1; j < nums2.length; j++) {
                long mul=((long)nums2[i])*nums2[j];
                map2.put(mul,map2.getOrDefault(mul,0)+1);
            }
        }

        int res=0;
        for (int i = 0; i < nums1.length; i++) {
            long mul=((long)nums1[i])*nums1[i];
           res+=map2.getOrDefault(mul,0);
        }

        for (int i = 0; i < nums2.length; i++) {
            long mul=((long)nums2[i])*nums2[i];
            res+=map1.getOrDefault(mul,0);
        }
        return res;
    }
}
