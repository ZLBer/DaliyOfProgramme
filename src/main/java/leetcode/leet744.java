package leetcode;

/**
 * Created by libin on 2019/3/8.
 */
public class leet744 {
    public char nextGreatestLetter(char[] letters, char target) {

        char min='z'+1;
        char result=0;
        int distance=Integer.MAX_VALUE;
        for(int i=0;i<letters.length-1;i++){
         if(letters[i]<min) min=letters[i];
          if(letters[i]<target&&letters[i]-target>distance)
          {  distance=letters[i]-target;
              result=letters[i];
          }
         }

         if(distance==Integer.MAX_VALUE) return min;
        else return result;
    }
}
