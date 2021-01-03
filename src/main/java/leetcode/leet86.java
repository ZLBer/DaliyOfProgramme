package leetcode;

public class leet86 {
    public ListNode partition(ListNode head, int x) {
        ListNode up=new ListNode(-1);
        ListNode down=new ListNode(-1);
        ListNode uphead=up;
        ListNode downhead=down;
        while(head!=null){
            if(head.val<x){
                up.next=head;
                head=head.next;
                up.next.next=null;
                up=up.next;
            }else{
                down.next=head;
                head=head.next;
                down.next.next=null;
                down=down.next;
            }
        }
        up.next=downhead.next;
        return uphead.next;
    }
}
