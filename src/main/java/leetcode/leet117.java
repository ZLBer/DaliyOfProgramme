package leetcode;

public class leet117 {
 /*   //mine  可以直接利用116题的层序遍历
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



    //直接利用next结构来做
    //based on level order traversal
    public Node connect(Node root) {

        Node head = null; //head of the next level
        Node prev = null; //the leading node on the next level
        Node cur = root;  //current node of current level

        while (cur != null) {

            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }

            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
        return  root;
    }


    //same
    public Node connect(Node root) {

      Node res=root;
        while(root != null){
            Node tempChild = new Node(0);
            Node currentChild = tempChild;
            while(root!=null){
                if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
                if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
                root = root.next;
            }
            root = tempChild.next;
        }
        return res;

    }*/
}
