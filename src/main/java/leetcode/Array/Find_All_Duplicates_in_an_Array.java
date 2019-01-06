package leetcode.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2017/10/18.
 */
public class Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] nums) {
     List<Integer> res=new ArrayList<Integer>();
     for(int i=0;i<nums.length;i++){
        int index=Math.abs(nums[i])-1;
         if(nums[index]<0) {
             res.add(index+1);
         }
       nums[index]=-Math.abs(nums[index]);
     }
return res;
    }
}
