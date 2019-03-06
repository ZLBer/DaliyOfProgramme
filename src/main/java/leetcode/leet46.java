package leetcode;

import org.assertj.core.internal.Integers;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2019/3/6.
 */
public class leet46 {
    //mine 回溯法
    List<List<Integer>> result=new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
    recursion(nums,0);
    return result;
    }

void recursion(int []nums,int current){
      if(current==nums.length-1){
          List<Integer> temp=new LinkedList<>();
          for(int a:nums){
       temp.add(a);
          }
          result.add(temp);
      }


        for(int i=current;i<nums.length;i++){
swap(nums,current,i);
recursion(nums,current+1);
swap(nums,current,i);
        }

}


 void swap(int []nums,int a,int b){
    int temp=nums[a];
    nums[a]=nums[b];
    nums[b]=temp;
 }

//回溯法  感觉更优雅点
  /*  public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }*/

}
