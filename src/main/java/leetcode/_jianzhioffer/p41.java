package leetcode._jianzhioffer;

import java.util.PriorityQueue;

public class p41 {
    class MedianFinder {

        /** initialize your data structure here. */

        PriorityQueue<Integer> A=new PriorityQueue<>();
        PriorityQueue<Integer> B=new PriorityQueue<>((a,b)->b-a);
        public MedianFinder() {

        }

        public void addNum(int num) {
     if(A.size()==B.size()){
      B.add(num);
      A.add(B.poll());
     }else {
       A.add(num);
       B.add(A.poll());
     }
        }

        public double findMedian() {
      return  A.size()==B.size()?(double)(A.peek()+B.peek())/2:A.peek();
        }
    }
}
