package leetcode.leetcode1_499;

import java源码学习.util.Map;

public class leet299 {
 /*   public String getHint(String secret, String guess) {
        int index=0;
        int bulls=0,cows=0;
        boolean isBulls[]=new boolean[secret.length()];
        int []digit=new  int[10];
        while (index<secret.length()){
            if(secret.charAt(index)==guess.charAt(index)) {
                bulls++;
                isBulls[index]=true;
            }else {
                digit[secret.charAt(index)-'0']++;
            }
            index++;
        }

        for (int i = 0; i < isBulls.length; i++) {
            int c=guess.charAt(i);
            if(!isBulls[i]&&digit[c-'0']>0){
                cows++;
                digit[c-'0']++;
            }
        }

        return bulls+"A"+cows+"B";
    }*/

    //可以用一次遍历做出来
    public String getHint(String secret, String guess) {
        int index = 0;
        int bulls = 0, cows = 0;
        boolean isBulls[] = new boolean[secret.length()];
        int[] digit = new int[10];
     for(int i=0;i<secret.length();i++){
         char s=secret.charAt(i);
         char g=guess.charAt(i);
         if(s==g) bulls++;
         else {
             if(++digit[s-'0']<=0) cows++;
             if((--digit[g-'0'])>=0) cows++;

         }
     }

        return bulls+"A"+cows+"B";
    }
}
