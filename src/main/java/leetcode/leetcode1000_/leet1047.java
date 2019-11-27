package leetcode.leetcode1000_;

import java.util.Stack;

public class leet1047 {
    //mine 栈
    public String removeDuplicates(String S) {
        Stack<Character> stack=new Stack<>();
        for(Character c:S.toCharArray()){
            if(stack.isEmpty()) stack.push(c);
            else if(stack.peek()==c) stack.pop();
            else stack.push(c);
        }
        StringBuilder sb=new StringBuilder();
         while (!stack.isEmpty()){
             sb.append(stack.pop());
         }
         return sb.reverse().toString();
    }
  //避免反转字符串
/*    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            int len = stack.length();
            if (len > 0 && stack.charAt(len - 1) == c) {
                stack.setLength(len - 1); //模拟出栈
            } else {
                stack.append(c); //入栈
            }
        }
        return stack.toString();
    }*/
}
