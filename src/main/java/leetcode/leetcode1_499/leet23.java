package leetcode.leetcode1_499;

import leetcode.ListNode;

import java.util.PriorityQueue;

public class leet23 {

    //mine k个指针
/*    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head=new ListNode(0);
        ListNode pre=head;
        boolean flag=false;
    while (true){
      int minPoint=0;
      int minValue=Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]==null) continue;
            if(lists[i].val<minValue){
                minPoint=i;
                minValue=lists[i].val;
            }
            flag=true;
        }
        while (!flag) return head.next;
        flag=false;
      pre.next=lists[minPoint];
      pre=pre.next;
      lists[minPoint]=lists[minPoint].next;
    }
    }*/


  //优先级队列   nlogk
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue=new PriorityQueue<>((a, b)->a.val-b.val);
        for (ListNode list : lists) {
            if(list!=null)
               priorityQueue.add(list);
        }
        ListNode head=new ListNode(0);
        ListNode tail=head;
        while (!priorityQueue.isEmpty()){
            tail.next=priorityQueue.poll();
            tail=tail.next;

            if(tail.next!=null){
                priorityQueue.add(tail.next);
            }
        }
    return head.next;
    }


//  divide and conquer  分之法  就是两两合并
  /*  public static ListNode mergeKLists(ListNode[] lists){
        return partion(lists,0,lists.length-1);
    }

    public static ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
*/
}
