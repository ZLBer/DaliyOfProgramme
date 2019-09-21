package leetcode.leetcode1_499;

import leetcode.ListNode;

/**
 * Created by libin on 2019/1/5.
 */
public class leet206 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode resut=head;

        ListNode p=head.next;
        head=head.next;
        resut.next=null;

        //前序插入
        while (head!=null){
             p=head;
             head=head.next;
             p.next=resut;
            resut=p;

        }
        return  resut;
    }

    // 方法二  遍历改变指针方向
    // public ListNode reverseList(ListNode head) {
//    ListNode prev = null;
//    ListNode curr = head;
//    while (curr != null) {
//        ListNode nextTemp = curr.next;
//        curr.next = prev;
//        prev = curr;
//        curr = nextTemp;
//    }
//    return prev;
//}

    //递归法
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode p = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return p;
//    }

}
