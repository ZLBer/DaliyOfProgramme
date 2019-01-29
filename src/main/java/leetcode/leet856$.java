package leetcode;

import java.util.Stack;

/**
 * Created by libin on 2019/1/23.
 */
public class leet856$ {
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


  /*public int scoreOfParentheses(String S) {
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
    }*/

// 用栈
public int scoreOfParentheses(String S) {
    Stack<Integer> stack = new Stack<>();
    for (char c : S.toCharArray()) {
        //左括号入栈
        if (c == '(') {
            stack.push(-1);
        } else { //
            int cur = 0;
            //如果前一个不是括号
            while (stack.peek() != -1) {
                cur += stack.pop();
            }
            //直到遇到括号
            stack.pop();
            //翻倍
            stack.push(cur == 0 ? 1 : cur * 2);
        }
    }
    int sum = 0;
    //多个括号并列的情况
    while (!stack.isEmpty()) {
        sum += stack.pop();
    }
    return sum;
}


  //用栈的一种简单方法
   /* public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }*/

    public static void main(String[] args) {
        char a='1';
        System.out.println(a);
    }
}
