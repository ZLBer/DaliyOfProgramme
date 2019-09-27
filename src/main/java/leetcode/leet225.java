package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leet225 {
    /*class MyStack {
   Queue<Integer> queueA=new LinkedList<>();
        Queue<Integer> queueB=new LinkedList<>();
        *//** Initialize your data structure here. *//*
        public MyStack() {

        }

        *//** Push element x onto stack. *//*
        public void push(int x) {
            Queue<Integer> full=queueA.isEmpty()?queueB:queueA;
            full.offer(x);
        }

        *//** Removes the element on top of the stack and returns that element. *//*
        public int pop() {
            Queue<Integer> full=queueA.isEmpty()?queueB:queueA;
            Queue<Integer> empty=queueA.isEmpty()?queueA:queueB;
            while (full.size()>1){
              empty.offer(full.poll());
            }
            return  full.poll();
        }

        *//** Get the top element. *//*
        public int top() {
            Queue<Integer> full=queueA.isEmpty()?queueB:queueA;
            Queue<Integer> empty=queueA.isEmpty()?queueA:queueB;
            while (full.size()>1){
                empty.offer(full.poll());
            }
            int result=  full.peek();
            empty.offer(full.poll());
            return result;
        }

        *//** Returns whether the stack is empty. *//*
        public boolean empty() {
            Queue<Integer> full=queueA.isEmpty()?queueB:queueA;
            return full.isEmpty();
        }
    }*/


        //只用一个queue
    class MyStack
    {
        Queue<Integer> queue;

        public MyStack()
        {
            this.queue=new LinkedList<Integer>();
        }

        // Push element x onto stack.
        public void push(int x)
        {
            queue.add(x);
            for(int i=0;i<queue.size()-1;i++)
            {
                queue.add(queue.poll());
            }
        }

        // Removes the element on top of the stack.
        public int pop()
        {
          return   queue.poll();
        }

        // Get the top element.
        public int top()
        {
            return queue.peek();
        }

        // Return whether the stack is empty.
        public boolean empty()
        {
            return queue.isEmpty();
        }
    }
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);queue.add(2);
        for(int i=0;i<queue.size()-1;i++)
        {
            int q=queue.poll();
            System.out.println(q);
            queue.add(q);
        }
        System.out.println(queue.peek());
    }
}
