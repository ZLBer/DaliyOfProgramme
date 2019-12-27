package leetcode;

import java.util.*;

public class leetc2 {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>(Arrays.asList(nums[0])));
        for (int i = 1; i < nums.length; i++) {
            boolean flat=true;
            int index=-1;
            for (int j = 0; j < ans.size(); j++) {
                List<Integer> an=ans.get(j);
                if(an.size()<k&&an.get(an.size()-1)+1==nums[i]){
                    an.add(nums[i]);
                    flat=false;
                    index=j;
                    break;
                }
            }

            if(flat){
                ans.add(new ArrayList<>(Arrays.asList(nums[i])));
            }else {
                if(ans.get(index).size()==k) {
                    ans.remove(index);
                }
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            if(ans.get(i).size()!=k) return false;
        }
        return true;
    }

}
