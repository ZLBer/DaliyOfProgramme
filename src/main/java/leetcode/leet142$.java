package leetcode;

public class leet142$ {
    public ListNode detectCycle(ListNode head) {

        //从head出发
        //后面那个重复数字是从0开始
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

        }
        return null;
    }
}
