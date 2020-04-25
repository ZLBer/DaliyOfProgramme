package leetcode.leetcode1_499;

import java.util.*;

public class leet295 {

    //mine  自己维护一个自增的列表
/*    class MedianFinder {
        List<Integer> list=new ArrayList<>();
        *//** initialize your data structure here. *//*
        public MedianFinder() {
     
        }

        public void addNum(int num) {
            int i=0;
            for (; i < list.size(); i++) {
                if(list.get(i)<num) continue;
                else break;
            }
            System.out.println(i);
            list.add(i,num);
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }

        public double findMedian() {
            //偶数
       if(list.size()%2==0){
           return ((double)list.get(list.size()/2-1)+list.get(list.size()/2))/2;
       }
       //奇数
       else {
           return list.get(list.size()/2);
       }
        }
    }*/

      //用一个最大堆和最小堆实现中位数
/*    class MedianFinder {
        //small大顶堆  队列左半边
        private Queue<Integer> small = new PriorityQueue(Comparator.reverseOrder());
     //小顶堆  队列右半边
        private Queue<Integer> large = new PriorityQueue();
        // Adds a number into the data structure.
        public void addNum(int num) {
            //先往右半边添加
            large.add(num);
            //将右半边最小的添加到左半边
            small.add(large.poll());
            //若是左半边比右半边大则置换一个 为了保证右边比左边大
            if (large.size() < small.size())
                large.add(small.poll());
        }

        // Returns the median of current data stream
        public double findMedian() {
            //若是右边比左边大 则直接返回右边的第一个
            //否则就是相等，则返回左边最后一个和右边第一个的和/2
            return large.size() > small.size()
                    ? large.peek()
                    : (large.peek() + small.peek()) / 2.0;
        }
    }*/

    //一样的思路   但这种方法更好理解
   class MedianFinder{
       private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
       private PriorityQueue<Integer> large = new PriorityQueue<>();
       private boolean even = true;


       //永远只可能左边比右边小
       public double findMedian() {
           //若相等
           if (even)
               return (small.peek() + large.peek()) / 2.0;
           //不等
           else
               return small.peek();
       }

       public void addNum(int num) {
           //此步之后 samll比large大
           if (even) {
               large.offer(num);
               small.offer(large.poll());

               //此步之后一样大
           } else {
               small.offer(num);
               large.offer(small.poll());
           }
           even = !even;
       }
   }

    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        System.out.println(queue.poll());
    }
}
