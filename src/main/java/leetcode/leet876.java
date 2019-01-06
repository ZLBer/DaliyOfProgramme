package leetcode;

/**
 * Created by libin on 2019/1/5.
 */
public class leet876 {
    public ListNode middleNode(ListNode head) {
            int count=0;
        ListNode p=head;
            while (p!=null){
                count++;
                p=p.next;
            }
            int middle=count/2+1;
            while (middle>0){
                middle--;
                if(middle==0) return head;
               head=head.next;
              }

return  null;
    }


    //快慢指针 ，快指针一次跳两个 ，慢指针一次跳一个  但是速度并不快
//    public ListNode middleNode(ListNode head) {
//        ListNode slow = head, fast = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
}
