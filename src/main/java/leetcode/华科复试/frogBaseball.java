package leetcode.华科复试;

import java.util.Stack;

/**
 * Created by libin on 2019/3/2.
 */
public class frogBaseball {
   static int solution(String board){
        Stack<Integer> stack=new Stack<>();
       for(int i=0;i<board.length();i++){
           if(Character.isDigit(board.charAt(i)))  stack.push(board.charAt(i)-'0');
           else if(board.charAt(i)=='+') {
               int a=stack.pop();
               int b=stack.pop();
             stack.push(a);
             stack.push(b);
             stack.push(a+b);
           }
           else if(board.charAt(i)=='C') stack.pop();
           else stack.push(stack.peek()*2);

       }

       int result=0;
        while (!stack.isEmpty()){
            result+=stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution("52CD+"));
    }
}
