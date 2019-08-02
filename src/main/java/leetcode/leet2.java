package leetcode;

public class leet2 {

    //mine
/*    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result=new ListNode(0);
        ListNode p=result;
        ListNode pre=null;
        int carry=0;
        while (l1!=null&&l2!=null){
            int sum=l1.val+l2.val+carry;
            carry=sum/10;
            sum=sum%10;
            p.val=sum;
            l1=l1.next;
            l2=l2.next;
            p.next=new ListNode(0);
            pre=p;
            p=p.next;
        }

        while (l1!=null){
            int sum=l1.val+carry;
            carry=sum/10;
            sum=sum%10;
            p.val=sum;
            p.next=new ListNode(0);
            l1=l1.next;
            pre=p;
            p=p.next;
        }

        while (l2!=null){
            int sum=l2.val+carry;
            carry=sum/10;
            sum=sum%10;
            p.val=sum;
            p.next=new ListNode(0);
            l2=l2.next;
            pre=p;
            p=p.next;
        }
        if (carry!=0){
            p.val=carry;
            pre=p;
        }
        pre.next=null;
        return result;
    }*/

   //别人的写法  首先不用carry保存进位,其次不用pre保存前节点 也不会显得那么臃肿,代码简洁
/*    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }*/



    //修改  不用pre的版本
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result=new ListNode(0);
        ListNode p=result;
        int carry=0;
        while (l1!=null&&l2!=null){
            int sum=l1.val+l2.val+carry;
            carry=sum/10;
            sum=sum%10;
            l1=l1.next;
            l2=l2.next;
            p.next=new ListNode(sum);
            p=p.next;
        }

        while (l1!=null){
            int sum=l1.val+carry;
            carry=sum/10;
            sum=sum%10;
            p.next=new ListNode(sum);
            l1=l1.next;
            p=p.next;
        }

        while (l2!=null){
            int sum=l2.val+carry;
            carry=sum/10;
            sum=sum%10;
            p.next=new ListNode(sum);
            l2=l2.next;
            p=p.next;
        }
        if (carry!=0){
            p.next=new ListNode(carry);
            p=p.next;
        }
        p.next=null;
        return result.next;
    }
}
