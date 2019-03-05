package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2019/3/3.
 */
public class leet19 {
    //mine  two pass 两次遍历
   /* public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node=head;
        int count=0;
       while (node!=null){
         count++;
         node=node.next;
       }
       int beginToend=count-n;
ListNode pre=head;
node=head;
       while (beginToend!=0){pre=node;
           node=node.next;

           beginToend--;
       }
       pre.next=node.next;
       if(node==head) return node.next;
return head;
    }*/

   //mine onepass
 /*   public ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> listNodes=new LinkedList<>();
        ListNode node=head;
        while (node!=null){
            listNodes.add(node);
        node=node.next;
        }
        int beginToend= listNodes.size()-n;
        if (beginToend==0) return head.next;
        ListNode pre=listNodes.get(beginToend-1);
        node=listNodes.get(beginToend);
        pre.next=node.next;
        return head;
    }*/

    //更好的方法  快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //让两个指针之间的距离变为n
        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        //然后一起往后跑
        //Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}
