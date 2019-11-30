package leetcode;

public class leet24 {

    //mine 搞不清楚这个题的意义，单纯节点交换
    public ListNode swapPairs(ListNode head) {
        ListNode h =new ListNode(0);
        h.next=head;
        ListNode pre=h;

        while (head!=null&&head.next!=null){
          ListNode first=head,seconnd=head.next;
          pre.next=seconnd;
          first.next=seconnd.next;
          seconnd.next=first;
          pre=first;
          head=pre.next;
        }
return h.next;
    }
}
