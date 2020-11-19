package leetcode.tianchi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class tianchi1031 {

    public int orderCheck(List<Integer> heights) {
       List<Integer> temp=new ArrayList<>(heights);
        Collections.sort(temp);
       int res=0;
        for (int i = 0; i < heights.size(); i++) {
            if(heights.get(i)!=temp.get(i)) res++;
        }
        return res;
    }


    public int[] getMedian(int[] arr) {
        int []nums=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i]=arr[i];
        }
        Arrays.sort(nums);


     int[]res=new int[arr.length];
        //原数组偶数

     int a=nums[arr.length/2-1],b=nums[arr.length/2];
     for (int i = 0; i < res.length; i++) {
         if (arr[i] <= a) res[i] = b;
         else {
             res[i] = a;
         }

     }
       return res;
    }

}
