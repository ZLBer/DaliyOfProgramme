package leetcode;

import java.util.Stack;

public class leet1381 {

    //mine 数组模拟
 /*   class CustomStack {
     int[] array;
     int top=-1;//指向栈顶下一个
        public CustomStack(int maxSize) {
        array=new int[maxSize];
        }

        public void push(int x) {
            if(top>=array.length-1) return;
         array[++top]=x;
        }

        public int pop() {
            if(top<0) return -1;
      return array[top--];
         }

        public void increment(int k, int val) {
             for(int i=0;i<(Math.min(top+1,k));i++){
                 array[i]+=val;
             }
        }
    }*/

    //延迟增加

    class CustomStack {
        Stack<Integer> stack=new Stack<>();
        int maxSize;
        int [] inc;
        public CustomStack(int maxSize) {
      this.maxSize=maxSize;
      inc=new int[maxSize+1];
        }

        public void push(int x) {
       if(stack.size()==maxSize) return;
       stack.push(x);
        }
        public int pop() {
            int index=stack.size()-1;
            if(index<0)return -1;
            if(index>0)
            inc[index-1]+=inc[index];
            int re=stack.pop()+inc[index];
            inc[index]=0;//需要清空
            return re;
        }

        public void increment(int k, int val) {
        int index=Math.min(k,stack.size())-1;
        if(index>=0){
            inc[index]+=val;
        }
        }
    }
}
