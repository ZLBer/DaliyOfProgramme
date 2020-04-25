package leetcode.leetcode1_499;

public class leet430 {

    //mine 需要考虑的东西比较多  例如 断开链接、重新组合链接(重新设置头节点、尾节点)等
/*    public Node flatten(Node head) {
        if(head==null) return head;
        return heler(head)[0];
    }
    Node[] heler(Node node){
        if(node==null) return null;
        Node head=node;
        Node tail=node;
        while (node!=null){
            tail=node;
            if(node.child==null){
                node=node.next;
            }else {
                Node n=node.next;
                Node[] next=heler(node.child);
                if(node.next!=null)
                    node.next.prev=next[1];
                next[1].next=node.next;
                node.next=next[0];
                next[0].prev=node;
                node.child=null;
                tail=next[1];
                node=n;
            }
        }
        return new Node[]{head,tail};
    }*/
}
