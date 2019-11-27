package leetcode.leetcode1_499;

import java.util.Stack;

public class leet232 {
    class MyQueue {
      Stack<Integer> stackA=new Stack<>();
        Stack<Integer> stackB=new Stack<>();
        /** Initialize your data structure here. */
        public MyQueue() {
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
               stackA.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
         checkB();
           return stackB.pop();

        }

        /** Get the front element. */
        public int peek() {
        checkB();
        return stackB.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
              return stackA.isEmpty()&&stackB.isEmpty();
        }

        void checkB(){
            if(stackB.isEmpty()){
                while (!stackA.isEmpty()){
                    stackB.push(stackA.pop());
                }

            }
        }
    }
}
