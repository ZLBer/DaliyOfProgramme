package leetcode.leetcode1_499;

import leetcode.ListNode;

import java.util.Random;

public class leet382 {
    class Solution {
        int size;
        ListNode head;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head=head;
            size=0;
           while(head!=null){
               size++;
               head=head.next;
           }
        }

        /** Returns a random node's value. */
        public int getRandom() {
            Random random=new Random();
            int index=random.nextInt(size);
            ListNode temp=head;
            while (index-->0){
                temp=temp.next;
            }
            return temp.val;
        }
    }




    //Reservoir Sampling 蓄水池算法  数据位置的情况下 随机取数
    //https://blog.csdn.net/anshuai_aw1/article/details/88750673
  /*  class Solution {
        ListNode head;
        *//** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. *//*
        public Solution(ListNode head) {
            this.head=head;
        }

        *//** Returns a random node's value. *//*
        public int getRandom() {
            Random random=new Random();
           int i=0;
           int res=head.val;
           ListNode temp=head.next;

           while (temp!=null){

               i++;
               if(random.nextInt(i+1)==i) res=temp.val;
               temp=temp.next;
           }
           return res;
    }

}*/

}
