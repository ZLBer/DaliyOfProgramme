package leetcode;

/**
 * Created by libin on 2019/1/6.
 */
public class leet21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null) return null;
        if(l1==null){
            return  l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode result;
        if(l1.val<l2.val)   {
            result=l1;
            l1=l1.next;
        }
        else {
            result=l2;
            l2=l2.next;
        }
        ListNode re=result;
        ListNode p=l1;
        ListNode q=l2;
        while (p!=null&&q!=null){
            if(p.val<q.val){
                result.next=p;
                result=result.next;
                p=p.next;
            }
            else {
                result.next=q;
                result=result.next;
                q=q.next;
            }
        }
        while(q!=null) {
            result.next=q;
            result=result.next;
            q=q.next;
        }
        while (p!=null){
            result.next=p;
            result=result.next;
            p=p.next;
        }
        return re;
    }


//   递归写法
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
//        if(l1 == null) return l2;
//        if(l2 == null) return l1;
//        if(l1.val < l2.val){
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else{
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }
}
