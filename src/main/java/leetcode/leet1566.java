package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet1566 {
 static    public boolean containsPattern(int[] arr, int m, int k) {

       for(int begin=0;begin<arr.length;begin++) {
           List<Integer> patten = new ArrayList<>();
           boolean flag=true;
           int count = 1;
           for (int i = begin; i <= arr.length-m; ) {


               if (patten.size() == 0) {
                   for (int j = 0; j < m; j++) {
                       patten.add(arr[i + j]);

                   }  i+=m;
               } else {

                   for (int j = 0; j < m; j++) {
                       if(patten.get(j)!=arr[i+j]){
                         flag=false;
                           break;
                       }

                   }
                   i+=m;
                  if(flag) {
                      count++;
                  }else {
                    break;
                  }

                  if(count>=k) return true;
               }


           }


       }
       return false;
    }

    public static void main(String[] args) {
        containsPattern(new int[]{1,2,1,2,1,3},2,3);
    }
}
