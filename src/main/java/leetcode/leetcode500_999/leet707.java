package leetcode.leetcode500_999;

import java.util.ArrayList;
import java.util.List;

public class leet707 {

    class MyLinkedList {
        class Node{
        int value;
        Node nextNode;
    }
         Node  head;
        /** Initialize your data structure here. */
        public MyLinkedList() {
         head=new Node();
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index<0) return -1;
          Node  curNode=head;
            while (curNode.nextNode!=null&&--index>=0){
               curNode=curNode.nextNode;
          }
            if(index>=0) return -1;
            return curNode.nextNode.value;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
          Node temp=new Node();
          temp.value=val;
          temp.nextNode=head.nextNode;
          head.nextNode=temp;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
           Node temp=head;
            while (temp.nextNode!=null){
                temp=temp.nextNode;
            }
           Node  add=new Node();
            add.value=val;
            temp.nextNode=add;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if(index<0) {
                addAtHead(val);
            }
            ;
               Node temp=head;
               Node add=new Node();
               add.value=val;
               while (temp.nextNode!=null&&--index>=0){
                 temp=temp.nextNode;
               }
               if(index>0) return;
               add.nextNode=temp.nextNode;
               temp.nextNode=add;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index<0) return ;
            Node pre=head;
            Node p=head.nextNode;
            while (p!=null&&--index>=0){
           pre=p;
            p=p.nextNode;
            }
            if(p==null) return;
             pre.nextNode=p.nextNode;

        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public static void main(String[] args) {
    List<Integer> list=new ArrayList<>();
    list.add(-1,0);
    System.out.println(list.size());

}
}
