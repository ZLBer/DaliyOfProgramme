package leetcode.leetcode1_499;

import leetcode.ListNode;

/**
 * Created by libin on 2019/1/6.
 */
public class leet234 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null){
            slow=slow.next;
        }
     slow=reverse(slow);
        while(slow!=null){
            if(slow.val==head.val) {
                slow=slow.next;
                head=head.next;
            }
            else  return false;
        }



        return  true;
    }


    ListNode reverse(ListNode node){
          ListNode pre=null;
          while (node!=null){
              ListNode next = node.next;
              node.next = pre;
              pre = node;
              node = next;
          }
          return  pre;
    }
//    public boolean isPalindrome(ListNode head) {
//        ListNode fast = head, slow = head;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        if (fast != null) { // odd nodes: let right half smaller
//            slow = slow.next;
//        }
//        slow = reverse(slow);
//        fast = head;
//
//        while (slow != null) {
//            if (fast.val != slow.val) {
//                return false;
//            }
//            fast = fast.next;
//            slow = slow.next;
//        }
//        return true;
//    }
//
//    public ListNode reverse(ListNode head) {
//        ListNode prev = null;
//        while (head != null) {
//            ListNode next = head.next;
//            head.next = prev;
//            prev = head;
//            head = next;
//        }
//        return prev;
//    }
}
