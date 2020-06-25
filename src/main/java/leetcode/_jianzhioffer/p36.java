package leetcode._jianzhioffer;

public class p36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    //mine 这个题好玩  纯靠数据结构 返回大小为2的数组，0表示首，1表示尾
/*    public Node treeToDoublyList(Node root) {
   Node []head=helper(root);
   if(head[0]==null) return null;
   head[0].left=head[1];
   head[1].right=head[0];
   return head[0];
    }
   Node[] helper(Node node){
        if(node==null) return new Node[]{null,null};

     Node []left=helper(node.left);
    Node []right=helper(node.right);

    if(left[1]!=null){
        node.left=left[1];
        left[1].right=node;
    }
    else {
        left[0]=node;
    }

if(right[0]!=null){
    node.right=right[0];
    right[0].left=node;
}else {
    right[1]=node;
}


    return new Node[]{left[0],right[1]};
   }*/

   //好吧 别人的简单多了  保存一个pre，然后中序遍历
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

}
