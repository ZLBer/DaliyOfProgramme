package leetcode;

public class leet25 {

    //mine
   static public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode h = new ListNode(0);
        ListNode pre = h;
        h.next = head;
        while (head != null) {
            int tk = k-1;
            ListNode p=head;
            ListNode next = head.next;
            head.next=null;  //此步断开连接很关键  否则会无限循环
            while (tk-- > 0) {
                if (next == null) {
                    //提前结束  再反转一次
                    ListNode n=head.next;
                    head.next=null;
                    while (n!=null){
                        ListNode c=n.next;
                        n.next=head;
                        head=n;
                        n=c;
                    }
                    break;
                }
                ListNode t = next.next;
                next.next = head;
                head = next;
                next = t;
            }
            pre.next = head;
            head = next;
            pre=p;
        }
        return h.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
       ListNode v= reverseKGroup(head,3);
   while (v!=null){
       System.out.println(v.val);
       v=v.next;
   }
    }
}
