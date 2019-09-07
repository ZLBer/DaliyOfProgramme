package leetcode;

import java.util.*;

public class leet1171$ {
    public ListNode removeZeroSumSublists(ListNode head) {
        int prefix = 0;
        Map<Integer, ListNode> map = new HashMap<>();

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        while (cur != null) {
            prefix += cur.val;

            if (map.containsKey(prefix)) {
                ListNode left = map.get(prefix).next;
                int l = prefix;
                while (left != cur) {
                    l += left.val;
                    map.remove(l);
                    left=left.next;
                }
                map.get(prefix).next = cur.next;
            } else {
                map.put(prefix, cur);
            }

            cur = cur.next;

        }

        return pre.next;
    }
}
