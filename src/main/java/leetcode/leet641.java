package leetcode;

public class leet641 {



    //mine 用node
  /*  class MyCircularDeque {

        int maxSize;
        ListNode head=new ListNode();
        ListNode tail=new ListNode();
        int capacity=0;
        *//** Initialize your data structure here. Set the size of the deque to be k. *//*
        public MyCircularDeque(int k) {
            maxSize=k;
            head.next=tail;
            tail.pre=head;
        }

        *//** Adds an item at the front of Deque. Return true if the operation is successful. *//*
        public boolean insertFront(int value) {
            if(maxSize==capacity){
                return false;
            }
             ListNode insert=new ListNode();
             insert.val=value;
             insert.next=head.next;
             head.next.pre=insert;
             head.next=insert;
             insert.pre=head;
             capacity++;
             return true;
        }

        *//** Adds an item at the rear of Deque. Return true if the operation is successful. *//*
        public boolean insertLast(int value) {
            if(maxSize==capacity){
                return false;
            }
            ListNode insert=new ListNode();
            insert.val=value;
            insert.pre=tail.pre;
            tail.pre.next=insert;
            insert.next=tail;
            tail.pre=insert;
            capacity++;
            return true;
        }

        *//** Deletes an item from the front of Deque. Return true if the operation is successful. *//*
        public boolean deleteFront() {
            if(capacity==0)
                return false;
            head.next.next.pre=head;
            head.next=head.next.next;
            capacity--;
            return true;
        }

        *//** Deletes an item from the rear of Deque. Return true if the operation is successful. *//*
        public boolean deleteLast() {
            if(capacity==0)
                return false;
              tail.pre.pre.next=tail;
              tail.pre=tail.pre.pre;
              capacity--;
              return true;
        }

        *//** Get the front item from the deque. *//*
        public int getFront() {
            if (isEmpty()) return -1;
            return head.next.val;
        }

        *//** Get the last item from the deque. *//*
        public int getRear() {
            if(isEmpty()) return -1;
             return tail.pre.val;
        }

        *//** Checks whether the circular deque is empty or not. *//*
        public boolean isEmpty() {
            return capacity==0;
        }

        *//** Checks whether the circular deque is full or not. *//*
        public boolean isFull() {
             return capacity==maxSize;
        }
    }
    public  class ListNode{
        public int val=0;
        public ListNode next=null;
        public ListNode pre=null;
    }*/

    //用数组构造循环队列  front不存数字来区分empty和full
    class MyCircularDeque {
         int[] arr;
         int front=0;
         int rear=0;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
                arr=new int[k+1];
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if(isFull()) return false;
            arr[front++]=value;
            front=front%arr.length;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if(isFull())return false;
            rear=(rear-1+arr.length)%arr.length;
            arr[rear]=value;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if(isEmpty()) return false;
            front=(front-1+arr.length)%arr.length;
            return true;

        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if(isEmpty()) return false;
            rear=(rear+1)%arr.length;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if(isEmpty()) return -1;
            return arr[(front-1+arr.length)%arr.length];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if(isEmpty()) return -1;
            return arr[rear];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return rear==front;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
          return (front+1)%arr.length==rear;
        }
    }
}
