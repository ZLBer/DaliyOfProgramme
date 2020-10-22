package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet143 {
    public void reorderList(ListNode head) {
       List<ListNode> list=new ArrayList<>();
     ListNode node=head;
      while (node!=null){
        list.add(node);
        node=node.next;
      }
     ListNode dump=new ListNode(-1);
     int i=0,j=list.size()-1;
     node=dump;
     while (i<j) {
       node.next=list.get(i);
       node=node.next;
       node.next=list.get(j);
       node=node.next;
       i++;
       j--;
     }
     if(i==j){
         node.next=list.get(i);   node=node.next;
     }
     node.next=null;
    }
}
