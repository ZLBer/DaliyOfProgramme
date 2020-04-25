package leetcode._30Days;

import java.util.Stack;

public class MinStack {
      Stack<Integer> stack=new Stack<>();
      Stack<Integer> minStack=new Stack<>();
        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
           minStack.push(x);
        }else if(minStack.peek()>=x){
         minStack.push(x);
        }
        }

        public void pop() {
      int val=stack.pop();
      if(minStack.peek()==val){
          minStack.pop();
      }
        }

        public int top() {
  return stack.peek();
        }

        public int getMin() {
     return minStack.peek();
        }
    }

