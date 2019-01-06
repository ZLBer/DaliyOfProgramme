package leetcode.Array;

import java.util.LinkedList;

/**
 * Created by libin on 2017/10/16.
 */
public class Rotate_Array {
    public void rotate(int[] nums, int k) {

        int n=k%nums.length;
        if(k==0||n==0)
            return ;
//        LinkedList<Integer> a=new LinkedList<Integer>();
//        for(int i=0;i<n;i++){
//            a.add(nums[i]);
//        }
//        for(int i=nums.length-1;i>=n;i--){
//            a.addFirst(nums[i]);
//        }
//       for(int i=0;i<nums.length;i++){
//          nums[i]=a.get(i);
//       }
        int []num=nums.clone();
        for(int i=0;i<nums.length-n;i++){
            nums[i+n]=num[i];

        }
        for(int i=0;i<n;i++){
            nums[i]=num[nums.length-n+i];
        }
    }
   static void swap(int []nums,int m,int n){
        int a=nums[m];
        nums[m]=nums[n];
        nums[n]=a;

    }
}
