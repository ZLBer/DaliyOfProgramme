package leetcode.leetcode1_499;

import leetcode.ListNode;

public class leet148 {
// O(n log n) time using constant space complexity.
    //这就是说不能用额外的数组来暂存list的值。也不能两次遍历


    //归并排序
/*
  static   public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
      ListNode fast=head,slow=head;
      ListNode pre=head;
      while (fast!=null&&fast.next!=null){
          pre=slow;
          fast=fast.next.next;
          slow=slow.next;
      }
      pre.next=null;
     ListNode left=sortList(head);
      ListNode right=sortList(slow);
   return merge(left,right);
    }

   static ListNode merge(ListNode left,ListNode right){
        ListNode res=new ListNode(0),p=res;
        while (left!=null&&right!=null){
            if(left.val<right.val){
             p.next=left;
             left=left.next;
             p=p.next;
            }else {
                p.next=right;
                right=right.next;
                p=p.next;
            }
        }
        while (left!=null){
            p.next=left;
            left=left.next;
            p=p.next;
        }
        while (right!=null){
            p.next=right;
            right=right.next;
            p=p.next;
        }
res=res.next;
        return res;
    }
*/

   //改进版的归并排序  从底层直接往上遍历
 /*   public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }

        //从短的往长的开始遍历
        for (int step = 1; step < n; step <<= 1) {
            ListNode prev = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode left = cur;
                //找到right段
                ListNode right = split(left, step);
                //找到下一个cur
                cur = split(right, step);

                //prev表示前一个段，需要把segment都连成一个链
                prev = merge(left, right, prev);
            }
        }

        return dummy.next;
    }
    //寻找stop后的下一个段
    private ListNode split(ListNode head, int step) {
        if (head == null) return null;

        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }

        ListNode right = head.next;
        //断开链接
        head.next = null;
        return right;
    }

    //合并算法
    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
        ListNode cur = prev;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            }
            else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if (left != null) cur.next = left;
        else if (right != null) cur.next = right;
        while (cur.next != null) cur = cur.next;
        return cur;
    }*/



    public ListNode sortList(ListNode head) {

   if(head==null||head.next==null) return head;
     ListNode fast=head,slow=head;
     ListNode pre=head;
     while (fast!=null&&fast.next!=null){
         fast=fast.next.next;
         pre=slow;
         slow=slow.next;
     }

     pre.next=null;


     ListNode left=sortList(head);

     ListNode right=sortList(slow);

     ListNode newHead=new ListNode(-1);
     ListNode temp=newHead;
     while (left!=null&&right!=null){
       if(left.val<=right.val){
           temp.next=left;
            left=left.next;
       }else {
           temp.next=right;
           right=right.next;
       }
       temp=temp.next;

     }

     temp.next=(left==null?right:left);

     return newHead.next;

    }

    public static void main(String[] args) {
         ListNode head=new ListNode(4);
         head.next=new ListNode(2);
         head.next.next=new ListNode(1);
         head.next.next.next=new ListNode(3);
        // sortList(head);
    }
}
