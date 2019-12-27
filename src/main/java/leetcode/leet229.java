package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet229 {
    // 用最辣鸡的方法做?
/*    public List<Integer> majorityElement(int[] nums) {
  Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        List<Integer> res=new ArrayList<>();
    for(Map.Entry<Integer,Integer> e: map.entrySet()){
        if(e.getValue()>=nums.length/3) res.add(e.getKey()) ;
    }

  return res;
    }*/
    //   投票法
   // Boyer-Moore Majority Vote algorithm
    //保持两个数字，两个计数器
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if(nums.length==0) return  res;
       int count1=0,count2=0,num1=nums[0],num2=nums[0];
        for (int i = 0; i < nums.length; i++) {
            //存在匹配的
            if(nums[i]==num1){
             count1++;
         }else if(nums[i]==num2){
             count2++;

         }
         //存在一个减小了0
         else if(count1==0){
            count1=1;
            num1=nums[i];
         }else if(count2==0){
             count2=1;
             num2=nums[i];
         }
         //两个都不相等，且没有减到0
         else {
          count1--;
          count2--;
         }
        }
         count1=0;
         count2=0;
         //最后需要验证一下
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==num1) count1++;
            else if(nums[i]==num2) count2++;
        }
        if(count1>nums.length/3) res.add(num1);
        if(count2>nums.length/3) res.add(num2);
        return res;
    }
}
