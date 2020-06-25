package leetcode._4_30Days;

import leetcode.ListNode;

public class MiddleoftheLinkedList {

    //mine 快慢指针
    public ListNode middleNode(ListNode head) {
     ListNode dump=new ListNode(-1);
     dump.next=head;
     ListNode fast=dump;
     ListNode slow=dump;
     while (fast!=null&&fast.next!=null){
         fast=fast.next.next;
         slow=slow.next;
     }

     return  fast==null? slow.next:slow;
    }
}
