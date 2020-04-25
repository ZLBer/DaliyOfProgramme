package leetcode.leetcode1_499;

import leetcode.ListNode;

public class leet92 {

    //mine  原地反转列表  确实不是很容易去断开链接和接上链接
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;
     int index=1;
        ListNode p=head;
        ListNode pre=null;
     while (index++<=m-1){
         pre=p;
         p=p.next;
     }
     index--;
     ListNode r=p;
     ListNode dummy=new ListNode(0);//冗余的无效节点
     while (index++<=n){
          ListNode t=p.next;
          p.next=dummy.next;
          dummy.next=p;
          p=t;
     }

     //组装三段链表
        r.next=p;
        if(pre!=null){
            pre.next=dummy.next;
            return head;
        }else {
            return dummy.next;
        }


    }


  //看人家的多么简洁明了啊
/*    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;

    }*/
}
