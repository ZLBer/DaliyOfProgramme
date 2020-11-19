package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class leet402 {

    //写的什么乱七八糟的
/*    public String removeKdigits(String num, int k) {
     if(num.length()==k) return "0";
     int K=k;
     Stack<Integer>stack = new Stack<>();
       int i=0;
        for (; i < num.length()&&k>0; i++) {
            int c=num.charAt(i)-'0';

            while (k>0&&!stack.isEmpty()&&stack.peek()>c){
               stack.pop();
               k--;
            }
          if(k==0) break;
            if(stack.isEmpty()||stack.peek()>=c){
                stack.push(c);
            }else {
               k--;
            }

        }
      //  System.out.println(stack.isEmpty());
       String res="";
        while (!stack.isEmpty()){
           res+=stack.pop();
        }
        res= res+num.substring(i,num.length());

        i=0;
        while (i<res.length()){
            if(res.charAt(i)=='0') {
                i++;continue;
            }else {
                break;
            }
        }
       if(i==res.length())return "0";
       res= res.substring(i);

       if(res.length()>num.length()-K){
          res=res.substring(0,num.length()-K+1);
       }
       return res;

    }*/

    public String removeKdigits(String num, int k) {
        Deque<Character> deque=new ArrayDeque<>();

        for (int i = 0; i < num.length(); i++) {
          char c=num.charAt(i);
            while (!num.isEmpty()&&k>0&&deque.peek()>c){
                k--;
                deque.pollLast();
            }
           deque.offerLast(c);
        }

      while (k-->0){
          deque.pollLast();
      }

      StringBuilder sb=new StringBuilder();
      boolean leadzero=true;
      while (!deque.isEmpty()){
          char c=deque.pollFirst();
          if(c=='0'&&leadzero){
             continue;
          }else {
             leadzero=false;
             sb.append(c);
          }
      }

      return sb.length()==0?"0":sb.toString();


    }
}
