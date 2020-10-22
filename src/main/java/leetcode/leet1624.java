package leetcode;

import java.util.Arrays;

public class leet1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
     int []left=new int[26];
        Arrays.fill(left,-1);
        int res=-1;
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(left[c-'a']==-1){
                left[c-'a']=i;
            }else {
              res=Math.max(i-left[c-'a']-1,res);
            }
        }
        return res;
    }







    public static void main(String[] args) {

    }
}
