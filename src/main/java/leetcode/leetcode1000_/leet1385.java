package leetcode.leetcode1000_;

import java.util.TreeSet;

public class leet1385 {
    //mine 怎么简单怎么来
/*    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res=0;
        for (int i = 0; i < arr1.length; i++) {
            boolean flag=true;
            for (int j = 0; j < arr2.length; j++) {
                if(Math.abs(arr1[i]-arr1[j])<=d){
                    flag=false;
                    break;
                }
            }
            if(flag) res++;
        }
        return res;
    }*/

    //时间复杂度优化
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        TreeSet<Integer> treeSet=new TreeSet<>();
        for (int i : arr2) {
            treeSet.add(i);
        }
        int res=0;

        for (int i = 0; i < arr1.length; i++) {
            Integer higher=treeSet.ceiling(arr1[i]);
            Integer lower=treeSet.floor(arr1[i]);
            int diff=0;
            if(higher==null){
              diff=arr1[i]-lower;
            }else if(lower==null){
                diff=higher-arr1[i];
            }else {
                diff=Math.min(arr1[i]-lower,higher-arr1[i]);
            }

            if(diff>d){
                res++;
            }
        }
        return res;
    }

}
