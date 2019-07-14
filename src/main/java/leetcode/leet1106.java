package leetcode;

import java源码学习.util.LinkedList;

import java.util.*;

public class leet1106 {

    //mine  递归做法
   static public boolean parseBoolExpr(String expression) {
   return helper(expression);
    }
  static boolean helper(String expreesion){

    if(expreesion.startsWith("!")){
        return !helper(expreesion.substring(2,expreesion.length()-1));
    }
   else if (expreesion.startsWith("&")){

     String[] strings=   retureString(expreesion.substring(2,expreesion.length()-1));
     boolean result=helper(strings[0]);
     for(int i=1;i<strings.length;i++){
         result&=helper(strings[i]);
     }
     return result;
    }
else if (expreesion.startsWith("|")){
        String[] strings=   retureString(expreesion.substring(2,expreesion.length()-1));
        boolean result=helper(strings[0]);
        for(int i=1;i<strings.length;i++){
            result|=helper(strings[i]);
        }
        return result;
    }
if(expreesion.equals("t")) return true;
else return false;
   }
   //拆分字符串为数组
 static String[] retureString(String expression){
      List<String> result=new ArrayList<>();
      int pre=0;
      int preInteger=0;
      LinkedList<String> list=new LinkedList<>() ;
      for(int i=0;i<expression.length();i++){

          if(expression.charAt(i)=='(') pre++;
          else if((expression.charAt(i)==')')) pre--;
          else if((expression.charAt(i)==',')&&pre==0){
              list.add(expression.substring(preInteger,i));
              preInteger=i+1;
          }

      }
      list.add(expression.substring(preInteger));
     return list.toArray(new String[list.size()]);
   }



   //用栈来做
  /*  public boolean parseBoolExpr(String expression) {
        Deque<Character> stk = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (c == ')') {
                Set<Character> seen = new HashSet<>();
                while (stk.peek() != '(')
                    seen.add(stk.pop());
                stk.pop();// pop out '('.
                char operator = stk.pop(); // get operator for current expression.
                if (operator == '&') {
                    stk.push(seen.contains('f') ? 'f' : 't'); // if there is any 'f', & expression results to 'f'
                }else if (operator == '|') {
                    stk.push(seen.contains('t') ? 't' : 'f'); // if there is any 't', | expression results to 't'
                }else { // ! expression.
                    stk.push(seen.contains('t') ? 'f' : 't'); // Logical NOT flips the expression.
                }
            }else if (c != ',') {
                stk.push(c);
            }
        }
        return stk.pop() == 't';
    }*/
    public static void main(String[] args) {
     //   parseBoolExpr("!(&(!(t),!(!(&(f))),&(&(!(&(f)),&(t),|(f,f,t)),&(t),&(t,t,f))))");
     //   System.out.println("$(1,2)".substring(2,"$(1,2)".length()-1));
        for(String s:retureString("!(t),!(!(&(f))),&(&(!(&(f)),&(t),|(f,f,t)),&(t),&(t,t,f))")){
            System.out.println(s);
        }
    }
}
