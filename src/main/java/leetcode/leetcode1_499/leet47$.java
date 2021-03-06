package leetcode.leetcode1_499;

import java.util.*;

/**
 * Created by libin on 2019/3/6.
 */
public class leet47$ {




    //2020/9/18
   //剪枝规律很重要  而这个规律不好找
/*    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean []used=new boolean[nums.length];
        Arrays.sort(nums);
        helper(0,nums,used,new ArrayList<>());
        return res;
    }

    void helper(int index,int []nums,boolean []used,List<Integer>list){
        if(index>=nums.length){
            res.add(new ArrayList<>(list));
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]||(i>0&&nums[i]==nums[i-1]&&used[i-1])) continue;
            used[i]=true;
            list.add(nums[i]);
            helper(index+1,nums,used,list);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }*/





    /*
Consider the following example:
i= 0, 1, 2, 3, 4
A= 1, 1, 1, 2, 2

In the for loop, at i = 0, we will form permutations of form [1] + permutations({1,1,2,2}).
At i = 1, !used[0] means that we're on to next iteration and we don't need to consider [1] + permutations({1,1,2,2}) again. Similar for at i = 2, !used[1] means that we've already considered similar permutations.

However, not that used[0] could be true, and that can happen for a permutations of {1,1,2,2}.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                //when a number has the same value with its previous, we can use this number only if his previous is used
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }




}
