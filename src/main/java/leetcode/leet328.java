package leetcode;

import java.util.List;

public class leet328 {
    //内存超出限制
/*    public ListNode oddEvenList(ListNode head) {
        ListNode odd=new ListNode(0);
        ListNode even=new ListNode(0);
        ListNode firstOdd=odd;
        ListNode firstEven=even;
        int index=1;
        while (head!=null){
            if((index++)%2==1){
                odd.next=head;
                odd=odd.next;

            }
            else{
                even.next=head;
                even=even.next;
            }
            head=head.next;
        }
        //System.out.println(firstEven.val);
        odd.next=firstEven.next;
        return firstOdd.next;
    }*/

    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        ListNode odd=head,even=head.next,first=even;
        while (even!=null&&even.next!=null){
            odd.next=even.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=first;
        return head;
    }

}
