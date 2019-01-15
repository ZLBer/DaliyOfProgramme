package leetcode;

import java.util.ArrayList;

/**
 * Created by libin on 2019/1/10.
 */
public class leet338 {
    public int[] countBits(int num) {
        int result[]=new int[num+1];
        for(int i=0;i<=num;i++){
            result[i]=numberOne(i);

        }
            return result;
    }
   static int  numberOne(int num){
        int count=0;
        while(num>0) {
            if (num % 2 == 1) count++;
            num = num / 2;
        }
        return count;
    }

   // 优秀的做法   f[i] = f[i / 2] + i % 2.
 /*   public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }*/




    public static void main(String[] args) {
        System.out.println(numberOne(1));
    }



}
