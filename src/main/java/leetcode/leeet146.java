package leetcode;


import java.util.HashMap;
import java.util.Map;

public class leeet146 {

    //双向链表解决
    class Node{
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        int key;
        int val;
        Node pre;
        Node next;
    }
    class LRUCache {
Node head=new Node(0,0);
Node tail=new Node(0,0);
Map<Integer,Node> map=new HashMap<>();
int count=0;
int capacity;
        public LRUCache(int capacity) {
           this.capacity=capacity;
            head.next=tail;
            tail.pre=head;
            head.pre = null;
            tail.next = null;
        }
       void deleteNode(Node node){
            node.pre.next=node.next;
            node.next.pre=node.pre;
        }
        void addToHead(Node node){
         node.next=head.next;
         node.next.pre=node;
         node.pre=head;
         head.next=node;
        }
        public int get(int key) {
          if(map.containsKey(key)){
              Node node=map.get(key);
           deleteNode(node);
           addToHead(node);
           return node.val;
          }
          return -1;
        }

        public void put(int key, int value) {
            System.out.println("put");
        if(map.containsKey(key)){
              Node node=map.get(key);
              deleteNode(node);
              addToHead(node);
              node.val=value;
        }else {
            Node node=new Node(key,value);
            map.put(key,node);
            //替换
             if(count>=capacity){
                 map.remove(tail.pre.key);
             deleteNode(tail.pre);
            addToHead(node);
             }else {
              addToHead(node); count++;
             }

        }
        }
    }


}
