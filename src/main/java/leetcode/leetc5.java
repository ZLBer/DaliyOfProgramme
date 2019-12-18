package leetcode;

public class leetc5 {
    public int getDecimalValue(ListNode head) {
    StringBuilder sb=new StringBuilder();
    while (head!=null){

        sb.append(head.val);
        head=head.next;
    }

    return Integer.valueOf(sb.toString(),2);
    }
}
