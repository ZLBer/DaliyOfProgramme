package leetcode;

import java.util.*;

public class leet18 {
/*    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                  int t=target-nums[i]-nums[j];
                  int left=j+1,right=nums.length-1;
                  while (left<right){
                      if(t==nums[left]+nums[right]){
                          List<Integer> temp=new ArrayList<>();
                          temp.addAll(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                          res.add(temp);
                          left++;
                          right--;
                      }else if(t>nums[right]+nums[left]){
                          left++;
                      }else right--;
                  }
            }
        }
       return  new ArrayList<>(res);
    }*/


//不用set去重
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;){

                int t=target-nums[i]-nums[j];
                int left=j+1,right=nums.length-1;
                while (left<right){
                    if(t==nums[left]+nums[right]){
                        List<Integer> temp=new ArrayList<>();
                        temp.addAll(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        res.add(temp);
                       // left++;
                       // right--;
                    while (++left<right&&nums[left-1]==nums[left]) continue;
                    while (--right>left&&nums[right]==nums[right+1]) continue;
                    }else if(t>nums[right]+nums[left]){
                        left++;
                    }else right--;
                }
                 j++;
                while (j<nums.length-2&&nums[j]==nums[j-1]) {
                    j++;
                }

            }
            while (i<nums.length-3&&nums[i]==nums[i+1]) {
                i++;
            }
        }
        return  res;
    }
}
