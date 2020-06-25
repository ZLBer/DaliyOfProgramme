package leetcode._jianzhioffer;


import java.util.Stack;

public class p31 {

    //mine 加一个栈模拟一下就ok
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
       int i=0,j=0;
      while (j<popped.length){
         if(i<pushed.length&&pushed[i]==popped[j]) {
             i++;j++;
         }else if(!stack.isEmpty()&&stack.peek()==popped[j]){
             stack.pop();
             j++;
         }
         else if(i<pushed.length){
           stack.push(pushed[i++]);
         }
         else {
             return false;
         }
      }
      return true;
    }
}
