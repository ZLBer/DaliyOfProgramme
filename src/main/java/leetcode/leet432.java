package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leet432 {


    //双链表+hash  超级麻烦啊 再也不想碰了
    class AllOne {

        Map<String,Integer> map=new HashMap<>();
        Map<Integer,Node> mapToNode=new HashMap<>();
       DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
        /** Initialize your data structure here. */
        public AllOne() {

        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {

        if(map.containsKey(key)){
            int old=map.get(key);
            Node node = mapToNode.get(old);
            node.keys.remove(key);
            //添加到原node之后
           Node ne= doubleLinkedList.addNext(node,key,old+1);

            if(node.keys.isEmpty()) {
                mapToNode.remove(old);
                doubleLinkedList.remove(node);
            }

            //更新映射
            map.put(key,old+1);
            mapToNode.put(old+1,ne);

        }else {
          map.put(key,1);
          if(mapToNode.containsKey(1)){
            mapToNode.get(1).keys.add(key);
          }else {
             Node ne=new Node(key,1);
            doubleLinkedList.addHead(ne);
            mapToNode.put(1,ne);
          }

         }
        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
           if(!map.containsKey(key)) return;//不包含这个key

            int old = map.get(key);
            Node node = mapToNode.get(old);

            node.keys.remove(key);




          if(old!=1) {
              Node pre=doubleLinkedList.addPre(node, key, old - 1);

              mapToNode.put(old - 1, pre);
              map.put(key, old - 1);
          }else {
             map.remove(key);
          }
            if(node.keys.isEmpty()) {
                mapToNode.remove(old);
                doubleLinkedList.remove(node);
            }

          
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
        if(doubleLinkedList.isEmpty()){
            return "";
        }else {
            return doubleLinkedList.getTail().keys.iterator().next();
        }
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
         if(doubleLinkedList.isEmpty()){
             return "";
         }else {
             return doubleLinkedList.getHead().keys.iterator().next();
         }
        }
    }

    class DoubleLinkedList{
      Node head=new Node();
      Node tail=new Node();

        public DoubleLinkedList() {
            head.next=tail;
            tail.pre=head;
        }

        void addTail(Node node){
           node.pre=tail.pre;
           node.next=tail;
           tail.pre.next=node;
           tail.pre=node;
      }
      void addHead(Node node){
           head.next.pre=node;
           node.next=head.next;
           head.next=node;
           node.pre=head;
      }

      Node  addNext(Node node,String key,int val){
           Node next=node.next;
           if(next.val==val){
               next.keys.add(key);
               return  next;
           }else {
               Node nd=new Node(key,val);
             node.next=nd;
             nd.next=next;
             next.pre=nd;
             nd.pre=node;
return nd;
           }
      }

      Node addPre(Node node,String key,int val){
          Node pre = node.pre;
          if(pre.val==val){
             pre.keys.add(key);
             return pre;
          }else {
            Node nd=new Node(key,val);
            pre.next=nd;
            nd.pre=pre;
            nd.next=node;
            node.pre=nd;
            return nd;
          }

      }

      boolean checkLast(Node node){
         return node.next==tail;
      }
      boolean isEmpty(){
         return head.next==tail;
      }

      Node getHead(){
          return head.next;
      }
      Node getTail(){
           return tail.pre;
      }

      void  remove(Node node){
         node.pre.next=node.next;
         node.next.pre=node.pre;
      }
    }


    class Node{
        Node pre,next;
        int val=-1;
        Set<String> keys=new HashSet<>();
       public Node(String key,int val){
           keys.add(key);
           this.val=val;
        }

        public Node() {
        }
    }

/*    public static void main(String[] args) {
        AllOne allOne=new leet432().new AllOne();

*//*        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        System.out.println(allOne.getMinKey());
        allOne.dec("a");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());*//*


        allOne.inc("a");
        allOne.inc("a");
        allOne.inc("a");
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.dec("c");
        System.out.println(allOne.getMinKey());

    }*/




}
