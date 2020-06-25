package leetcode._4_30Days;


import java.util.Stack;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {

        return helper(S).equals(helper(T));
    }



    String helper(String s){
        Stack<Character> stack=new Stack<>();
        for (char c : s.toCharArray()) {
            if(c=='#'){
                if(!stack.isEmpty())stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
