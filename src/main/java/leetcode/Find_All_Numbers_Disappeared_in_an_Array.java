package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libin on 2017/9/24.
 */
public class Find_All_Numbers_Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<Integer>();
        for(int i=1;i<=nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i==nums[j]) break;
                if(j==nums.length-1) result.add(i);
            }
        }
        return result;

    }
}
