package leetcode.leetcode1_499;

public class leet138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    //mine O(2n)
 /*   public Node copyRandomList(Node head) {
  Node pre=new Node();
  Node cpoy=pre;
  Node h=head;
  Map<Node,Node> map=new HashMap<>();
  while (head!=null){
      Node temp=new Node(head.val,null,null);
      pre.next=temp;
      map.put(head,temp);
      pre=pre.next;
      head=head.next;
  }
  Node temp=cpoy.next;
  while (temp!=null){
     temp.random=map.get(h.random);
     temp=temp.next;
     h=h.next;
  }
  return cpoy.next;
    }*/


    //真棒的解法
    //自己写了一下 看着容易，但不是那么好写，需要很多判空检验
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node n=head;
        Node next;

        //在节点后面复制字符串
        while (n!=null){
            next=n.next;
            n.next=new Node(n.val,null,n.random);
            n.next.next=next;
            n=next;
        }
        //调整random
        n=head.next;
        while (n!=null){
            if(n.random!=null)
              n.random=n.random.next;
            if(n.next==null) break;
                n=n.next.next;
        }
        //分离
        Node newHead=head.next;
        n=head;
        Node ne=newHead;
        while (ne!=null){
            next=n.next.next;
            n.next=next;
            n=next;


            if(ne.next==null) break;
            next=ne.next.next;
            ne.next=next;
            ne=next;
        }
        return newHead;
    }
}
