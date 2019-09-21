package leetcode.leetcode1_499;

import java.util.*;

public class leet155 {
/*    class MinStack {

        Stack<Integer> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        *//** initialize your data structure here. *//*
        public MinStack() {

        }

        public void push(int x) {
            stack.push(x);
            int insertIndex=0;
           for(int a:list){
               if(a<x) insertIndex++;
               else break;
           }
           list.add(insertIndex,x);
        }

        public void pop() {
         int delete=stack.pop();
         int deleteIndex=0;
         for (int i = 0; i < list.size(); i++) {
                 if(list.get(i)==delete) deleteIndex=i;
            }
         list.remove(deleteIndex);

        }

        public int top() {
       return   stack.peek();
        }

        public int getMin() {
       return list.get(0);
        }
    }*/

        //自己构造数据结构
 /*   class MinStack {

        *//** initialize your data structure here. *//*
        Node head=null;
        public MinStack() {

        }

        public void push(int x) {
          if(head==null)
              head=new Node(x,x,null);
          else {
              head=new Node(x,Math.min(x,head.min),head);
          }
        }

        public void pop() {
           head=head.next;
        }

        public int top() {
             return head.val;
        }

        public int getMin() {
              return head.min;
        }
    }

    class Node{
        int val;
        int min;
        Node next;
        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }*/


//用两个栈来做
/*    class MinStack {

        *//** initialize your data structure here.
         *
         *//*

        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        public MinStack() {

        }

        public void push(int x) {
         s1.push(x);
         if(s2.empty()||getMin()>=x) {
             s2.push(x);
         }
        }

        public void pop() {
            int s=s1.pop();
            if(s==getMin()){
                s2.pop();
            }
        }

        public int top() {
       return s1.peek();
        }

        public int getMin() {
         return s2.peek();
        }
    }*/


    //只用一个栈  神仙做法

    class MinStack {
        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        public void push(int x) {
            // only push the old minimum value when the current
            // minimum value changes after pushing the new value x
            if(x <= min){
                //这么理解 当min改变的时候都是先把老的min入栈
                stack.push(min);
                min=x;
            }
            stack.push(x);
        }

        public void pop() {
            // if pop operation could result in the changing of the current minimum value,
            // pop twice and change the current minimum value to the last minimum value.

            //当栈顶等于min时 需要弹出两次
            if(stack.pop() == min) min=stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
