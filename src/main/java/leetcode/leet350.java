package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by libin on 2019/2/28.
 */
public class leet350 {
    public int[] intersect(int[] nums1, int[] nums2) {

        LinkedList<Integer>  result=new LinkedList<>();
         HashMap<Integer,Integer>  map= new HashMap<>();
     for(int i=0;i<nums1.length;i++) map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        System.out.println(map.size());
    for(int i=0;i<nums2.length;i++){
        Integer count=map.get(nums2[i]);
        System.out.println(count+"----");
        if(count==null) continue;
        else if(count==1){ result.add(nums2[i]); map.remove(nums2[i]);  }
        else{ result.add(nums2[i]);  map.put(nums2[i],count-1);}

    }
        System.out.println(result.size());
     int res[]=new int[result.size()];
        for(int i=0;i<res.length;i++){
            res[i]=result.get(i);
        }
    return res;

    }


   //先排序，后用双指针遍历
   /* public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pnt1 = 0;
        int pnt2 = 0;
        ArrayList<Integer> myList = new ArrayList<Integer>();
        while ((pnt1 < nums1.length) && (pnt2 < nums2.length)) {
            if (nums1[pnt1] < nums2[pnt2]) {
                pnt1++;
            } else {
                if (nums1[pnt1] > nums2[pnt2]) {
                    pnt2++;
                } else {
                    myList.add(nums1[pnt1]);
                    pnt1++;
                    pnt2++;
                }
            }
        }
        int[] res = new int[myList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = (Integer) myList.get(i);
        }
        return res;
    }*/
}
