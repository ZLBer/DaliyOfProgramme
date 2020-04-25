package leetcode.leetcode1000_;

import leetcode.ListNode;

public class leet1290 {
    //mine contest
 /*   public int getDecimalValue(ListNode head) {
    StringBuilder sb=new StringBuilder();
    while (head!=null){

        sb.append(head.val);
        head=head.next;
    }

    return Integer.valueOf(sb.toString(),2);
    }*/


    //mine 可以直接操作二进制数
    public int getDecimalValue(ListNode head) {
    int ans=0;
    while (head!=null){
     ans=((ans<<1)|head.val);
     head=head.next;
    }
    return ans;
    }
}
