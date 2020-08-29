package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet1553 {


    //stack 太深了
 /*   public int minDays(int n) {
   Map<Integer,Integer> map=new HashMap<>();

   return helper(map,n);
    }
  int helper(Map<Integer,Integer> map,int n){
    if(n==1) return 1;

    if(map.containsKey(n) )return  map.get(n);
    int min=helper(map,n-1)+1;


    if(n%3==0){
   min=Math.min(min,helper(map,n/3)+1);
    }
    if(n%2==0) {
   min=Math.min(min,helper(map,n/2)+1);
    }

    map.put(n,min);

    return min;
  }
*/


 //颇有贪心的味道啊  直接不管吃一个的情况，这样stack深度就下来了
    public int minDays(int n) {
        Map<Integer,Integer> map=new HashMap<>();

        return helper(map,n);
    }
    int helper(Map<Integer,Integer> map,int n){
        if(n<3) return n;

        if(map.containsKey(n) )return  map.get(n);


         int min=helper(map,n/3)+n%3+1;


        min=Math.min(min,helper(map,n/2)+n%2+1);


        map.put(n,min);

        return min;
    }
}
