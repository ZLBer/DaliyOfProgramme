package leetcode;

/**
 * Created by libin on 2019/1/6.
 */
public class leet203 {

    //遍历解法
    public ListNode removeElements(ListNode head, int val) {
        if (head==null) return null;
        while(head==null&&head.val==val) {
            head=head.next;
        }
        if(head==null ) return  null;
        ListNode p= head.next;
        ListNode q=head;
         while (p!=null){
         if(p.val==val) {
             q.next=p.next;
           p=q.next;
         }
         else  {
             q=p;
             p=p.next;
         }
         }
         return head;
    }

//    递归解法  感觉很难想
//    public ListNode removeElements(ListNode head, int val) {
//        if (head == null) return null;
//        head.next = removeElements(head.next, val);
//        return head.val == val ? head.next : head;
//    }
}
