package leetcode.leetcode1000_1499;

import java.util.ArrayList;
import java.util.List;

public class leet1414 {

    //mine 就直接做呗
    public int findMinFibonacciNumbers(int k) {
     int f1=1,f2=1;
     List<Integer> list=new ArrayList<>();
     list.add(f1);
     list.add(f2);
     while (f2<=k){
       int f3=f1+f2;
       list.add(f3);
       f1=f2;
       f2=f3;
     }

     int index=list.size();

     int res=0;
     while (k>0){
        if(list.get(index)<=k){
            k-=list.get(index);
            res++;
        }else index--;
     }
     return res;
    }


/*    //递归版本
    public int findMinFibonacciNumbers(int k) {
        if (k < 2) return k;
        int a = 1, b = 1, c = 2;
        while (b <= k) {
            c = a + b;
            a = b;
            b = c;
        }
        return 1 + findMinFibonacciNumbers(k - a);
    }*/
}
