package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2019/3/6.
 */
public class leet78$ {

    //深度优先遍历
   static public List<List<Integer>> subsets(int[] nums) {
   List<List<Integer>> result= new LinkedList<>();
   dfs(result,new LinkedList<>(),nums,0);
   return result;
     }
   static void  dfs( List<List<Integer>> result,List<Integer> tempList,int []nums,int start){
           //result.add(tempList);十分错误的写法，因为下面的代码会改变tempList里的内容，导致result的内容发生改变
          //所以要复制一个新的对象
           result.add(new LinkedList<>(tempList));
           for (int a:tempList){
               System.out.print(a+"  ");

           } System.out.println();
           for(int i=start;i<nums.length;i++){
               tempList.add(nums[i]);
               dfs(result,tempList,nums,i+1);
               tempList.remove(tempList.size()-1);
           }
    }


//广度优先遍历
 /*   public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }*/
    public static void main(String[] args) {
       subsets(new int[]{1,2,3});
    }
}
