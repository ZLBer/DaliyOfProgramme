package leetcode.leetcode1_499;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by libin on 2019/2/27.
 */
public class leet219 {
    //mine  蛮力法
 /*   public boolean containsNearbyDuplicate(int[] nums, int k) {
         for(int i=0;i<nums.length;i++){
             int  high=(i+k)<nums.length?i+k:nums.length-1;

             for(int j=i+1;j<=high;j++){
                 if(nums[j]==nums[i]) return true;
             }

         }
         return false;
    }*/

  // 用一个窗口k来衡量  nice nice  nice！！！！
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            //改变窗口
            if(i > k) set.remove(nums[i-k-1]);
            //向set里添加元素 ，如果窗口期内重复，则证明存在两个相同元素
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
