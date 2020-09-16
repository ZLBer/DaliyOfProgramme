package leetcode.leetcode1000_1499;

import java.util.Stack;

public class leet1249 {
    //stack里只存括号的序号
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack=new Stack<>();
    char[]sc=s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            if(sc[i]=='('){
                stack.push(i);
            }else if(sc[i]==')'){
                if(stack.isEmpty()) sc[i]='0';
                else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()){
            sc[stack.pop()]='0';
        }

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < sc.length; i++) {
             if(sc[i]=='0') continue;
             sb.append(sc[i]);
        }
        return sb.toString();
    }



    //只要保证括号成对出现就行
  /*  public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;

        //先删除多余的右括号
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) continue;
                open--;
            }
            sb.append(c);
        }


        //再删除多余的左括号
        //O（N2）
 *//*       for (int i = sb.length() - 1; i >= 0 && open > 0; i--) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                open--;
            }
        }

        return sb.toString();*//*

      // O（N）
        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && open-- > 0) continue;
            result.append(sb.charAt(i));
        }

        return result.reverse().toString();
    }*/
}
