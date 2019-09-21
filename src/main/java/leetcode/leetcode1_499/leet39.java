package leetcode.leetcode1_499;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2019/3/6.
 */
public class leet39 {
  //mine  先求不同的子集  求每个自己的和  1.相同--》 添加
    //                                   2.大于目标 --》返回
    //                                   3.小于目标--》 继续dfs
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result= new LinkedList<>();
        dfs(result,new LinkedList<>(),candidates,0,target);
        return result;
    }
    void dfs(List<List<Integer>> result, List<Integer> tempList,int[] nums,int start,int target){
        int temTarget=0;
        for(int a:tempList){
            temTarget+=a;
        }
        if(target==temTarget){
            result.add(new LinkedList<>(tempList));
            return;
        }else if(temTarget>target)
            return;

        for(int i=start;i<nums.length;i++){
            tempList.add(nums[i]);
            dfs(result,tempList,nums,i,target);
            tempList.remove(tempList.size()-1);
        }
    }

   //每次求remain   比前一个少了很多计算  快很多
   /* public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);  // 排序似乎是没有用的
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }*/
//一种排序有用的做法
   /*
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates[0] > target) return res;
        dfs(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates,
                     int target,
                     int start,
                     List<List<Integer>> res,
                     List<Integer> tracker)
    {
        if (target == 0) res.add(new ArrayList<>(tracker));
        else
        {
            for (int i = start; i < candidates.length; i++)
            {
                if (candidates[i] > target) b;
                tracker.add(candidates[i]);
                dfs(candidates, target - candidates[i], i, res, tracker);
                tracker.remove(tracker.size() - 1);
            }
        }
    }
    */
}
