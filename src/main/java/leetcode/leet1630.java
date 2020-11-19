package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leet1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {





        List<Boolean> res=new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
           int right=r[i];
           int left=l[i];
        List<Integer> temp=new ArrayList<>();
         for(int j=left;j<=right;j++){
             temp.add(nums[j]);
         }

         if(check(temp)) res.add(true);
         else res.add(false);
        }



        return res;

    }

    boolean check(List<Integer> list){
       if(list.size()<=2) return true;
        Collections.sort(list); 
       int sub=list.get(1)-list.get(0);
        for (int i = 2; i < list.size(); i++) {
           int t=list.get(i)-list.get(i-1);
           if(t!=sub) return false;
        }
        return true;
    }
}
