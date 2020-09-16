package leetcode.leetcode1_499;

import java.util.Stack;

public class leet71 {
    public String simplifyPath(String path) {
        String[] splits = path.split("/");
        Stack<String> stack=new Stack<>();
        for (String split : splits) {
          if("".equals(split)||".".equals(split)) continue;
          else if("..".equals(split)){
             if(!stack.isEmpty()) stack.pop();
          }else {
              stack.push(split);
          }
        }
       String res="";
        if(stack.isEmpty()) return "/";
      while (!stack.isEmpty()){
          res="/"+stack.pop()+res;
      }
   return res;
    }
}
