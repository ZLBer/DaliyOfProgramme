package leetcode.leetcode500_999;

public class leet706 {

    //mine  无脑数组
  /*  class MyHashMap {
   Integer [] map=new Integer[1000000];
        *//** Initialize your data structure here. *//*
        public MyHashMap() {

        }

        *//** value will always be non-negative. *//*
        public void put(int key, int value) {
           map[key]=value;
        }

        *//** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key *//*
        public int get(int key) {
 if(map[key]==null) return -1;
         return map[key];
        }

        *//** Removes the mapping of the specified value key if this map contains a mapping for the key *//*
        public void remove(int key) {
           map[key]=null;
        }
    }*/


    class MyHashMap {


        int max=10000;
        ListNode []container=new ListNode[max];
        /** Initialize your data structure here. */
        public MyHashMap() {

        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
           ListNode head=container[key%max];
           if(head==null) container[key%max]=new ListNode(key,value,null);
           else {
               ListNode pre=head;
               while (head!=null){
                   if(head.key==key){
                       head.val=value;
                       return;
                   }
                   pre=head;
                   head=head.next;
               }
               pre.next=new ListNode(key,value,null);
           }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            ListNode head=container[key%max];
            while (head!=null){
                if(head.key==key) return head.val;
                head=head.next;
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            ListNode head=container[key%max];
            ListNode dumpy=new ListNode(0,0,head);
            ListNode pre=dumpy;
            while (head!=null){
              if(head.key==key){
                 pre.next=head.next;
                break;
              }
              pre=head;
              head=head.next;
            }
            container[key%max]=dumpy.next;
        }
    }
    class ListNode{
        int key;
        int val;
        public ListNode(int key,int val, ListNode next) {
            this.key=key;
            this.val = val;
            this.next = next;
        }

        ListNode next;
    }
}
