package leetcode;

public class leet116 {

  /*  //mine  层序遍历
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            while (size-->0){
              Node node=queue.poll();
              //表示这一层结束
              if(size==0){
                  node.next=null;
              }else {
                  node.next=queue.peek();
              }
              if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return root;
    }

    //可以直接这么写 牛皮
    //基本的思想也是层序遍历 但充分利用了next数据结构
    public Node connect(Node root) {
        Node levelStart=root;
        while (levelStart!=null){
            Node cur=levelStart;
            while (cur != null) {
                if(cur.left!=null)  cur.right.next=cur.right;
                if(cur.right!=null&&cur.next!=null) cur.right.next=cur.next.left;
                cur=cur.next;
            }
            levelStart=levelStart.left;
        }
        return root;
    }

    //前序遍历
    public Node connect(Node root) {

        if(root==null) return null;
        if(root.left!=null){
            root.left.next=root.right;
            if(root.next!=null){
                root.right.next=root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
        return root;
    }*/

}
