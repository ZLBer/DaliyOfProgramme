package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class leet1670 {
    class FrontMiddleBackQueue {
   Deque<Integer> front=new LinkedList<>();
   Deque<Integer> back=new LinkedList<>();
        public FrontMiddleBackQueue() {

        }

        public void pushFront(int val) {
         if(front.size()>back.size()){
             back.addFirst(front.pollLast());
         }
          front.addFirst(val);
        }

        public void pushMiddle(int val) {
           if(front.size()>back.size()){
               back.addFirst(front.pollLast());
               front.addLast(val);
           }else {
               front.addLast(val);
           }
        }

        public void pushBack(int val) {
           back.addLast(val);
           if(back.size()>front.size()){
             front.addLast(back.pollFirst());
           }
        }

        public int popFront() {
           // System.out.println(front.size()+" "+back.size());
         if(front.size()==0) return -1;
          int res=front.pollFirst();

            if(back.size()>front.size()){
                front.addLast(back.pollFirst());
            }
            return res;
        }

        public int popMiddle() {
           // System.out.println(front.size()+" "+back.size());
            if(front.size()==0) return -1;
            int res=front.pollLast();
            if(back.size()>front.size()){
                front.addLast(back.pollFirst());
            }
            return res;

        }

        public int popBack() {
          //  System.out.println(front.size()+" "+back.size());
            if(front.size()==0) return -1;
            if(back.size()==0) return front.pollLast();

            if(front.size()>back.size()){
               back.addFirst(front.pollLast());
            }
         int res=back.pollLast();

            return res;
        }
    }
}
