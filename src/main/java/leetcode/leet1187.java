package leetcode;

import java.util.Arrays;
import java.util.TreeSet;

public class leet1187 {
/*    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int countOperation=0;
        int index1=0;
        int index2=0;

        while (index1<arr1.length-1){
            if(arr1[index1+1]>arr1[index1]) {
                index1++;
                continue;
            }
            else {
                while (arr2[index2]>=arr1[index1+1])
                    index2++;


            }
        }
    }*/


    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int i:arr2){
            set.add(i);
        }
        for (int i = 0; i < arr1.length; i++) {
            
        }
        return  0;
    }
}
