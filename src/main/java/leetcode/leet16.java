package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leet16 {
    //就是在上个题的基础上改
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int min=Integer.MAX_VALUE;
        int result=0;
        for(int i=0;i<num.length-2;i++){
                int low=i+1,high=num.length-1,sum=target-num[i];
                while (low<high){
                    if(num[low]+num[high]==sum) return target;

                   int  dis=Math.abs(sum-num[low]-num[high]);
                   if(dis<min){
                       min=dis;
                       result=num[i]+num[low]+num[high];
                   }
                  if(num[low]+num[high]<sum) low++;
                    else high--;
                }
        }
        return result;
    }
}
