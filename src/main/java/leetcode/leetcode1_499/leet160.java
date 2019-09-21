package leetcode.leetcode1_499;

import leetcode.ListNode;

/**
 * Created by libin on 2019/1/6.
 */
public class leet160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                 ListNode l=headA;
                 int countA=0,countB=0;
                 while(l!=null){
                     countA++;
                     l=l.next;
                 }
                 l=headB;
                 while(l!=null){
                     countB++;
                     l=l.next;
                 }
                 int divide=0;
        ListNode p=headA;
        ListNode q=headB;
         if(countA>countB) {
             divide=countA-countB;
   while (divide!=0){
       divide--;
       p=p.next;
   }
         }
         else {
             divide=countB-countA;
             while (divide!=0){
                 divide--;
                 q=q.next;
             }
         }
        while (p!=null){
            if(p==q) return p;
            p=p.next;
            q=q.next;
        }
return null;
    }
}
