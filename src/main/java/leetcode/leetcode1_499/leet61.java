package leetcode.leetcode1_499;

import leetcode.ListNode;

public class leet61 {
    //mine  直接做就好
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null) return head;
     int count=0;
        ListNode p=head;
        //统计总个数
        ListNode pre=head;
        while (p!=null){
            pre=p;
           p=p.next;
           count++;
        }
        ListNode tail=pre;
        int index=count-(k%count);
        if(index==count) return head;
        p=head;
        pre=head;
        while (index-->0){
            pre=p;
           p=p.next;
        }
        pre.next=null;
        tail.next=head;

return p;
    }


   //判断next是否为空可以省略pre指针
/*    public ListNode rotateRight(ListNode head, int n) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++)//Get the total length
            fast=fast.next;

        for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
            slow=slow.next;

        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }*/
}
