package leetcode.leetcode1000_1499;

import java.util.Stack;

/**
 * Created by libin on 2019/4/13.
 */
public class leet1003 {

    //mine 用栈
    public boolean isValid(String S) {
        Stack<Character> stack =new Stack<>();
       for (char a:S.toCharArray()){
           if(a=='a')  stack.push('a');
           else if(a=='b') {
               if(stack.isEmpty()) return false;
               if(stack.peek()=='a') stack.pop();stack.push('b');
           }else {
               if(stack.isEmpty()) return false;
               if(stack.peek()=='b') stack.pop();
           }
       }
       return stack.size()==0;
    }



    //骚方法
   /* public boolean isValid(String S) {
        String abc = "abc";

        while(S.contains(abc)) {
            S = S.replace(abc, "");
        }

        return S.isEmpty();

    }*/
}
