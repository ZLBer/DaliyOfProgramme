package leetcode.leetcode500_999;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class leet817 {

    //mine set+flag
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < G.length; i++) {
            set.add(G[i]);
        }


        int result = 0;
        boolean flag = false;
        while (head != null) {
            if (set.contains(head.val))
                flag = true;
            else {
                if (flag) {
                    result++;
                    flag = false;
                }

            }
            head = head.next;
        }
        if (flag) result++;
        return result;
    }


    //只用set
 /*   public int numComponents(ListNode head, int[] G) {
        Set<Integer> setG = new HashSet<>();
        for (int i: G) setG.add(i);
        int res = 0;
        while (head != null) {
            if (setG.contains(head.val) && (head.next == null || !setG.contains(head.next.val))) res++;
            head = head.next;
        }
        return res;
    }*/

}
