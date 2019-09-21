package leetcode.leetcode1_499;

import leetcode.ListNode;

/**
 * Created by libin on 2019/1/6.
 */
public class leet141 {
    //用set集合
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> nodesSeen = new HashSet<>();
//        while (head != null) {
//            if (nodesSeen.contains(head)) {
//                return true;
//            } else {
//                nodesSeen.add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }
 //快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
