package leetcode;

/**
 * Created by libin on 2019/1/6.
 */
public class leet83 {
    public ListNode deleteDuplicates(ListNode head) {
         if(head==null) return  null;
         ListNode re=head;
        while (head.next!=null){
            if(head.val==head.next.val){
                head.next=head.next.next;
            }
            else head=head.next;
        }
        return re;
    }
}
