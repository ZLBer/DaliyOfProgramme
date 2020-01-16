package leetcode;

import java.util.*;

public class leet491 {
    //mine  最初始的版本 判断+set去重
   /* public List<List<Integer>> findSubsequences(int[] nums) {
        DFS(nums,0,new ArrayList<>());
        return new ArrayList<>(res);

    }
    Set<List<Integer>> res=new HashSet<>();
    void DFS(int[]nums,int deep,List<Integer> list){

        if(list.size()>=2)
            res.add(new ArrayList<>(list));
        if(deep>=nums.length){
            return;
        }
         //什么都不加
         DFS(nums,deep+1,list);


        //是否可以加
        if(list.isEmpty()||nums[deep]>=list.get(list.size()-1)) {
            list.add(nums[deep]);
            DFS(nums, deep + 1, list);
           //记得回溯
            list.remove(list.size() - 1);
        }
    }*/



   //  前缀一定不相同  所以不会有重复的
    public List<List<Integer>> findSubsequences(int[] nums) {
        DFS(nums,0,new LinkedList<>());
        return res;

    }
    List<List<Integer>> res=new ArrayList<>();
    void DFS(int[]nums,int deep,LinkedList<Integer> list){
      if(list.size()>1) res.add(new LinkedList<>(list));
     Set<Integer> set=new HashSet<>();
      for(int i=deep;i<nums.length;i++){
          //这一轮不允许用重复的
          if(set.contains(nums[i])) continue;
          if(list.isEmpty()||nums[i]>=list.getLast()){
              set.add(nums[i]);
              list.add(nums[i]);
              DFS(nums,i+1,list);
              list.removeLast();
          }
      }
    }
}
