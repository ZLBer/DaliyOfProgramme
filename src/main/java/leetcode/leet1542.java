package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leet1542 {
    //TLE
  /*  public int longestAwesome(String s) {

        int pre=0;
        int res=0;
        //   Map<Integer,Integer> map=new HashMap<>();
        int []arr=new int[s.length()];
        arr[0]=0;
      //  map.put(0,-1);
         for (int i = 0; i < s.length(); i++) {
         int num=s.charAt(i)-'0';
         if((pre&(1<<num))>>num==1){
            pre&=(~(1<<num));
         }
         else {
             pre=(pre^(1<<num));
         }
          //  System.out.println(Integer.toBinaryString(pre));
            *//* for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if(Integer.bitCount(pre|entry.getKey())-Integer.bitCount(pre&entry.getKey())<=1){
                    res=Math.max(i-entry.getValue(),res);
                }
             }*//*
             for (int j = 0; j <= i; j++) {
                 if(Integer.bitCount(pre|arr[j])-Integer.bitCount(pre&arr[j])<=1){
                     if(i-j>res){
                         res=i-j+1;
                         break;
                     }
                 }
             }
         
          arr[i+1]=pre;
      *//*   if(!map.containsKey(pre)){
             map.put(pre,i);
         }*//*
        }
        return res;
    }
*/

    //自己改进下
    //首先又忘记了异或的概念
    //此次循环里的规律不好找

    public int longestAwesome(String s) {
        int pre=0;
        int res=1;
         Map<Integer,Integer> map=new HashMap<>();
      map.put(0,-1);
        for (int i = 0; i < s.length(); i++) {
            int num=s.charAt(i)-'0';
           pre=pre^(1<<num);


           //这个规律不好找
            //之前自己那个一味的去便利了，没发掘更深层次的规律

         //这里判断 某区间内只有一位奇数位
        for(int j=0;j<=9;j++){
           int next=pre^(1<<j);
         if(map.containsKey(next)){
             res=Math.max(res,i-map.get(next));
         }
        }

        //  System.out.println(Integer.toBinaryString(pre));
            // 这里判断 某区间内全是偶数位置
        if(!map.containsKey(pre)){
             map.put(pre,i);
         }else {
            res=Math.max(res,i-map.get(pre));
        }
        }
        return res;
    }
}
