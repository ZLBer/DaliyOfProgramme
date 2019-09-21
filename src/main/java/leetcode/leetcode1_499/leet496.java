package leetcode.leetcode1_499;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libin on 2017/9/16.
 */
public class leet496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List <Integer>result=new ArrayList<Integer>();
               for(int i=0;i<nums1.length;i++){
                   result.add(-1);
                   for(int j=0;j<nums2.length;j++)
                       if(nums1[i]==nums2[j]){
                           for(;j<nums2.length;j++){
//                               if(nums1[i]<nums2[j]&&nums2[j]>result.get(i)){
//                                   result.set(i,nums2[j]);
//                               }
                               if(nums1[i]<nums2[j]){
                                  result.set(i,nums2[j]);
                                  break;
                             }
                           }
                       }
    }
      Integer[] r=result.toArray(new Integer[nums1.length]);
        int [] s=new int[nums1.length];
        for(int i=0;i<r.length;i++)
            s[i]=r[i].intValue();
return s;
    }
}
