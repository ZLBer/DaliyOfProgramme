package leetcode;

import java.util.Stack;

/**
 * Created by libin on 2019/1/23.
 */
public class leet856 {
   /* public int scoreOfParentheses(String S) {
        Stack<Character> stack=new Stack<>();
       for(int i=0;i<S.length();i++){
           if(S.charAt(i)=='(') stack.push('(');
          else if(S.charAt(i)==')')  {
               char s=stack.pop();
               if(s=='(') stack.push((char)1);
               else {
                    stack.pop();
                   stack.push( (char)(s*2));
               }
           }
       }
        int result=0;
       while(!stack.isEmpty())
              result+=stack.pop();
       return result;
     }*/


    public int scoreOfParentheses(String S) {
        Stack<String> stack=new Stack<>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='(') stack.push("(");

            else if(S.charAt(i)==')')  {
                String s=stack.pop();
                if(s=="(") {
                    if(isNumeric(stack.peek())) stack.push(Integer.parseInt(stack.pop())+1+"");
                 else stack.push(1+"");
                }
                else {
                     stack.pop();
                        stack.push(Integer.parseInt(s)*2+"");

                }
            }
        }
        int result=0;
        while(!stack.isEmpty())
            result+=Integer.parseInt(stack.pop());
        return result;
    }
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char a='1';
        System.out.println(a);
    }
}
