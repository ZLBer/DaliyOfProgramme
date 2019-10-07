package leetcode;

import java.util.*;

public class leet1213 {
    //mine 三指针
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int a1=0,a2=0,a3=0;
        List<Integer> result=new ArrayList<>();
        while (a1<arr1.length&&a2<arr2.length&&a3<arr3.length){
            int a=arr1[a1];
            int b=arr2[a2];
            int c=arr3[a3];
            if(a==b&&a==c){
                result.add(a);
                a1++;
                a2++;
                a3++;
               continue;
            }
            if(a<=b&&a<=c){
                a1++;
            } else if(b<=a&&b<=c){
                a2++;
            }else {
                a3++;
            }
        }
        return result;
    }
   /* public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
             map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i],map.getOrDefault(arr2[i],0)+1);
        }
        for (int i = 0; i < arr3.length; i++) {
            map.put(arr3[i],map.getOrDefault(arr3[i],0)+1);
        }

        List<Integer> result=new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==3)
                result.add(key);
        }
        return result;
    }*/
}
