package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2019/3/6.
 */
public class leet40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if(i>start&&nums[i]==nums[i-1]) continue;
            tempList.add(nums[i]);
            dfs(result,tempList,nums,i+1,target);
            tempList.remove(tempList.size()-1);
        }
    }
}
