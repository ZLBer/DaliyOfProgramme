package leetcode;

import java.util.Arrays;

public class leet1471 {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);


       int []res=new int[k];
        int left=0;
        int right=arr.length-1;
        int mid=arr[(arr.length-1)/2];

     while (k-->0){
       if(Math.abs(arr[left]-mid)>Math.abs(arr[right]-mid)){
         res[k]=arr[left++];
       }else {
           res[k]=arr[right--];
       }
     }
     return res;
    }
}
