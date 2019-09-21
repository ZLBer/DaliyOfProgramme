package leetcode.leetcode1_499;

import java.util.Stack;

/**
 * Created by libin on 2019/1/10.
 */
public class leet20 {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            switch (c){
                case '(':stack.push(c);break;
                case '{':stack.push(c);break;
                case '[':stack.push(c);break;
                case '}':{
                    if(stack.size()==0||stack.pop()!='{') return false;
                    break;
                }
                case ']':{
                    if(stack.size()==0||stack.pop()!='[') return false;
                    break;
                }
                case ')':{
                    if(stack.size()==0||stack.pop()!='(') return false;
                }

            }

        }
        return stack.size()==0?true:false;
    }
 ///s十分简洁的方式
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<Character>();
//        for (char c : s.toCharArray()) {
//            if (c == '(')
//                stack.push(')');
//            else if (c == '{')
//                stack.push('}');
//            else if (c == '[')
//                stack.push(']');
//            else if (stack.isEmpty() || stack.pop() != c)
//                return false;
//        }
//        return stack.isEmpty();
//    }

}
