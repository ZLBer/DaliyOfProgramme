package leetcode.leetcode1000_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet1200 {
    //mine
/*    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result=new ArrayList<>();
        int minDiff=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
             minDiff=Math.min(arr[i+1]-arr[i],minDiff);
        }
        for (int i = 0; i < arr.length; i++) {
            for(int j=i+1;j<arr.length;j++){
                int diff=arr[j]-arr[i];
                if(diff>minDiff)
                    break;
                else if(diff==minDiff){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        result.add(temp);
                }

            }
        }
        return result;
    }*/


    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result=new ArrayList<>();
        int minDiff=Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            minDiff=Math.min(arr[i+1]-arr[i],minDiff);
        }
        for (int i = 0; i < arr.length-1; i++) {
                int diff=arr[i+1]-arr[i];
               if(diff==minDiff){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[i+1]);
                    result.add(temp);
                }

            }
        return result;
    }
}
