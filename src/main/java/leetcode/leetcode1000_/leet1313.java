package leetcode.leetcode1000_;

import java.util.ArrayList;
import java.util.List;

public class leet1313 {
    public int[] decompressRLElist(int[] nums) {
     List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i+=2) {
            int count=nums[i];
            int num=nums[i+1];
            while (count-->0){
                list.add(num);
            }
        }
        int []res=new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    //用流映射 更慢了..
/*    public int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2)
            for (int j = 0; j < nums[i]; ++j)
                ans.add(nums[i + 1]);
        return ans.stream().mapToInt(i -> i).toArray();
    }*/
}
