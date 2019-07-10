package leetcode;

import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class leet1111$ {
    //先遍历一遍 ，然后再删除
   static public int[] maxDepthAfterSplit(String seq) {
       int result[]=new int[seq.length()];
      char[] chars=seq.toCharArray();
        int pre=0;
        int max=0;
        //求seq的深度
        for (int i = 0; i < chars.length;i++ ) {
         if(chars[i]=='('){
            pre++;
             max=Math.max(pre,max);
         }
         else pre--;
        }
      int half=max/2;
       for (int i = 0; i < chars.length;i++ ) {
       if(chars[i]=='('){
           pre++;
           if(pre>half) result[i]=1;
       }
       else {
           if(pre>half) result[i]=1;
           pre--;
       }
       }
      return result;
    }



    public static void main(String[] args) {
        maxDepthAfterSplit("(()())");
    }
}
