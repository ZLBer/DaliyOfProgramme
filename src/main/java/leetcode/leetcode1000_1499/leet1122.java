package leetcode.leetcode1000_1499;

import java.util.Arrays;

public class leet1122 {
    //mine
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        int[] result = new int[arr1.length];
        boolean [] taken = new boolean[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]){
                    result[index++] = arr2[i];
                    taken[j]=true;
                }
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            if(!taken[i]) result[index++]=arr1[i];
        }
        return result;
    }


    //计数排序
   /* public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int []result=new int[arr1.length];
        int count[]=new int[1001];
        int index=0;
        for(int a:arr1){
            count[a]++;
        }
        for(int a:arr2){
           while (count[a]-->0)
                 result[index++]=a;
        }
        for (int i = 0; i < count.length; i++) {
              while (count[i]-->0)
                  result[index++]=i;
        }
        return result;
    }*/

}
