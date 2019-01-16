package leetcode;

import java.util.Stack;

/**
 * Created by libin on 2019/1/16.
 */
public class leet921 {
    public int minAddToMakeValid(String S) {
        int stack=0;
        int result=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='(') stack++;
           else if(S.charAt(i)==')'&&stack>0) stack--;
            else result++;
        }

        return result+stack;
     }
}
