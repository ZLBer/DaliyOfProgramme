package leetcode.leetcode1_499;

import leetcode.ListNode;

public class leet147 {
    //mine 这种题不容易操作
/*    public ListNode insertionSortList(ListNode head) {
       ListNode p=head;
       ListNode sortHead=new ListNode(-1);
       ListNode sortTail=sortHead;
        sortHead.next=head;
       while (p!=null){

           ListNode preNode=sortHead;//前一个节点
           ListNode q=sortHead.next; //查找位置节点

           boolean flag=true;
           while (q!=p){
             if(q.val>p.val){
                flag=false;
                 sortTail.next=p.next;
                 p.next=q;
                 preNode.next=p;
                 break;
             }
             preNode=q;
               q=q.next;
           }

           if(flag){ //不需要移动
               sortTail=sortTail.next;
           }

           if(sortTail==null) break;
           p=sortTail.next;
       }
       return sortHead.next;
    }*/


//别人的方法  看起来真的简单易懂哦

    //分两条链链表   一条排序完成的有序  一条在排序的无序
    public ListNode insertionSortList(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while( cur != null ){
            next = cur.next;
            //find the right place to insert
            //寻找插入位置
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;  //回溯
            cur = next;
        }

        return helper.next;
    }
}
