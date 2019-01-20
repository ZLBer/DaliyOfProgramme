package leetcode;

import leetcode.LQTest.A;

/**
 * Created by libin on 2019/1/20.
 */
public class leet978 {
    //隔一个判断 ，  奇偶各遍历一次
  static   public int maxTurbulenceSize(int[] A) {
    //    System.out.println(helper(0, A));
    //    System.out.println(helper(1, A));
        return Math.max(helper(0, A), helper(1, A));
    }
 static   int  helper(int i,int []A){
       int Max=1;
       int count=1;
       for(;i< A.length;){
           if(i-1>=0&&A[i-1]>A[i]) count++;
           else {
               Max=Math.max(count,Max);
               count=1;
           }
           if(i+1<A.length&&A[i]<A[i+1]) count++;
           else {
               Max=Math.max(count,Max);
               count=1;
           }
           i+=2;
       }
       return Math.max(Max,count);
   }

    public static void main(String[] args) {
        maxTurbulenceSize(new int[]{0,8,45,88,48,68,28,55,17,24});
    }

}
