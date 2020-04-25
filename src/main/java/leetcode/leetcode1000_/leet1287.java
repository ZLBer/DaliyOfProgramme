package leetcode.leetcode1000_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet1287 {
    //mine contest
/*
    public int findSpecialInteger(int[] arr) {
        if(arr.length==1) return arr[0];
       int count=1;
        for (int i = 1; i < arr.length; i++) {
             if(arr[i]==arr[i-1]) count++;
             else {
                 count=1;
             }

             if(count>arr.length/4) return arr[i];
        }
        return -1;
    }
*/

    //可以用二分搜索 先找出三个四等分点，然后依次判断这个点是不是
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        if(n==1) {
            return arr[0];
        }
        List<Integer> list = new ArrayList<>(Arrays.asList(arr[n/4],arr[n/2],arr[(3*n)/4]));
        for (int element : list) {
            int f = firstOccurrence(arr,element);
            int l = lastOccurrence(arr,element);
            if(l-f+1>n/4) {
                return element;
            }
        }
        return -1;
    }



    //自己重写了查找函数  更容易理解
    //查找第一个出现的值
    static int firstOccurrence(int[] nums, int target) {
        int start=0;
        int end = nums.length-1;
        while(start < end){
            int middle = (start + end)/2;
            if(target > nums[middle])
                start = middle + 1;
            else if(target<nums[middle])
                end = middle-1;
            else
                end=middle;
        }
        return start;
    }


    //自己重写了查找函数  更容易理解
    //找最后一个出现的目标值
    static  int lastOccurrence(int[] nums,int target) {
        int start=0;
        int end = nums.length-1;
        while(start < end){
            int middle = (start+end+1)/2;
         if(target > nums[middle])
              start = middle + 1;
         else if(target<nums[middle])
             end=middle-1;
         else
            start = middle;

        }
        return start;
}

    public static void main(String[] args) {
        // 1,2,2,6,6,6,6,7,10,7,6,6,6,6,2,2,1
        lastOccurrence(new int[]{1,2,2,6,6,6,6,7,10},6);
    }
}
