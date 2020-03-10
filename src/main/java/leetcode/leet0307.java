package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class leet0307 {
    class MaxQueue {
   Queue<Integer> queue=new LinkedList<>();
   Deque<Integer> deque=new LinkedList<>();
        public MaxQueue() {

        }

        public int max_value() {
            if(!deque.isEmpty()) return deque.peekFirst();
            else return -1;
        }

        public void push_back(int value) {
           while (!deque.isEmpty()&&deque.peekLast()<value){
               deque.pollLast();
           }
           queue.offer(value);
           deque.offerLast(value);
        }

        public int pop_front() {
            if(queue.isEmpty()) return -1;
           int a=queue.poll();
           if(!deque.isEmpty()&&deque.peekFirst()==a){
               deque.pollFirst();
           }
           return a;
        }
    }
}
