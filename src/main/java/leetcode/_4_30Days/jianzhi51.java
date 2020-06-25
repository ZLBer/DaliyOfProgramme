package leetcode._4_30Days;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class jianzhi51 {


    //mine 归并
 /*   public int reversePairs(int[] nums) {
   int val= mergeSort(0,nums.length-1,nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
        return val;
    }

    int mergeSort(int left,int right,int[]arr){
        if(left>=right) return 0;

      int mid=(left+right)/2;


      int res=mergeSort(left,mid,arr)+mergeSort(mid+1,right,arr);

        int []copy= new int[right-left+1];
        for (int i = 0; i < copy.length; i++) {
            copy[i]=arr[left+i];
        }
        int k=0,i=left,j=mid+1;
      for(;i<=mid&&j<=right;k++){
          if(arr[i]<=arr[j]){
              //arr[k]=copy[i++];
              copy[k]=arr[i++];
          }else {
              //arr[k]=copy[j++];
              copy[k]=arr[j++];
              res+=(mid-i+1);
          }
      }
      while (i<=mid) {
        //  arr[k++]=copy[i++];
          copy[k++]=arr[i++];
          //res+=(right-mid+1);
      }
      while (j<=right){
           //arr[k++]=copy[j++];
           copy[k++]=arr[j++];
      }
        for (int l = 0; l < copy.length; l++) {
            arr[left+l]=copy[l];
        }
      return res;
    }
*/


    //mine树状数组
    private int search(int[] bit, int i) {
        int sum = 0;

        while (i > 0 ) {
            sum += bit[i];
            i -= i & -i;
        }

        return sum;
    }

    private void insert(int[] bit, int i) {
        while (i < bit.length) {
            bit[i] += 1;
            i += i & -i;
        }
    }

    public int reversePairs(int[] nums) {


        TreeSet<Integer>treeSet=new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            treeSet.add(nums[i]);
        }
        int []bit=new int[treeSet.size()+1];
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        int index=1;
        for(int num:treeSet){
            map.put(num,index++);
        }

        for (int i = 0; i < nums.length; i++) {
            index=map.get(nums[i]);
            res+=(i-search(bit,index));
            insert(bit,index);
        }
        return res;
    }
}
