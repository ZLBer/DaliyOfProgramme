package leetcode.tianchi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class tianchi01 {
   static public List<Integer> ProductList(int offset, int n, int len1, int len2) {
        // write your code here
       if(offset>=len1){
          int begin2=(offset-len1);
          int end2=Math.min(begin2+n,len2);
       return new ArrayList<>(Arrays.asList(len1,len1,begin2,end2));
       }else{
          int begin1=offset;
          int end1=Math.min(begin1+n,len1);
            int remaind=begin1+n-len1;
         if(remaind<0){
           return    new ArrayList<>(Arrays.asList(begin1,end1,0,0));
         }else {
            return  new ArrayList<>(Arrays.asList(begin1,end1,0,Math.min(remaind,len2)));
         }
           }
    }

    public static void main(String[] args) {
       ProductList(1,2,4,4);
    }
}
