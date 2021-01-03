package leetcode;

public class leet1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

       ListNode tail=null;

      ListNode temp=list2;

      while (temp!=null){
         tail=temp;
         temp=temp.next;
      }

      ListNode head=new ListNode(-1);
      head.next=list1;
      ListNode pre=head;
      temp=list1;
      int count=0;
      while (temp!=null){

          if(count==a){
            pre.next=list2;
         }

          pre=temp;
          temp=temp.next;
          if(count==b){
             tail.next=temp;
             break;
          }

         count++;
      }
      return head.next;
    }
}
