package leetcode.leetcode1_499;

import leetcode.LQTest.A;

import java.util.*;

public class leet15 {

     //错误
    /*  static   public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
      Set<String> set=new HashSet<>();
        int left=0,right=nums.length-1;
        while (left+1<=right&&nums[left]<=0&&nums[right]>=0){
            if(nums[left]+nums[right]>0){
                int cat = nums[left]+nums[left+1]+nums[right];
                String c=nums[left]+""+nums[left+1]+""+nums[right];
                if(cat==0){
                  List<Integer> temp=new ArrayList<>();
                  temp.add(nums[left]);
                    temp.add(nums[left+1]);
                    temp.add(nums[right]);
                    if(!set.contains(c)){
                        set.add(c);
                        result.add(temp);
                    }

                    left++;
                }else if(cat<0){
                    left++;
                }else {
                    right--;
                }
            }else {
                int cat=nums[left]+nums[right-1]+nums[right];
                String c=nums[left]+""+nums[right-1]+""+nums[right];
                if(cat==0){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(nums[right-1]);
                    temp.add(nums[right]);
                    if(!set.contains(c)){
                        result.add(temp);
                        set.add(c);
                    }

                    right--;
                }else if(cat>0){
                    right--;
                }else {
                    left++;
                }
            }




        }
        return result;
    }*/



    //问题分解很重要  先固定一个值，求另外两个数字的和
  /*   public List<List<Integer>> threeSum(int[] num) {
         Arrays.sort(num);
         List<List<Integer>> res = new LinkedList<>();
         for (int i = 0; i < num.length-2; i++) {
             //跳过重复的
             if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                 int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                 while (lo < hi) {
                     //找到两个和=sum
                     if (num[lo] + num[hi] == sum) {
                         res.add(Arrays.asList(num[i], num[lo], num[hi]));
                         //依旧需要跳过重复的
                         while (lo < hi && num[lo] == num[lo+1]) lo++;
                         while (lo < hi && num[hi] == num[hi-1]) hi--;
                         //答案是唯一的
                         lo++; hi--;
                     }
                      //sum需要变大
                     else if (num[lo] + num[hi] < sum) lo++;
                    //sum需要变小
                     else hi--;
                 }
             }
         }
         return res;
     }*/

  //自己写一遍
   /* public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for(int i=0;i<num.length-2;i++){
            if(i==0||(i>0&&num[i]!=num[i-1])){
                int low=i+1,high=num.length-1,sum=0-num[i];
                while (low<high){
                    if(num[low]+num[high]==sum){
                        res.add(Arrays.asList(num[i],num[low],num[high]));
                        while (low<high&&num[low]==num[low+1]) low++;
                        while (low<high&&num[high]==num[high-1]) high--;
                        low++;high--;
                    }else if(num[low]+num[high]<sum) low++;
                    else high--;
                }

            }
        }
        return res;
    }*/

    //要是换成set会会会更好理解
    public  List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
            int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if ( sum >0) k--;
                else if (sum<0) j++;
            }

        }
        return new ArrayList<>(res);

    }


    public static void main(String[] args) {
       // threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(-1+""+1);

        Set<List<Integer>> res=new HashSet<>();

        List<Integer> list=new ArrayList<>();
        list.hashCode();
        res.add(Arrays.asList(1,2,3));
        res.add(Arrays.asList(1,2,3));
        System.out.println(res.size());
    }
}
