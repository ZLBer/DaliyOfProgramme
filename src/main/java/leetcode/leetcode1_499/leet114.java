package leetcode.leetcode1_499;

public class leet114 {
    //保存链表
 /*   List<TreeNode> list=new ArrayList<>();
    public void flatten(TreeNode root) {
       DFS(root);
        for (int i = 1; i < list.size(); i++) {
            root.left=null;
            root.right=list.get(i);
            root=list.get(i);
        }
    }

    void DFS(TreeNode node){
     if(node==null) return ;
     list.add(node);
     DFS(node.left);
     DFS(node.right);
    }*/



 //太强了 怎么会有这么brilliant的做法
/*    public void flatten(TreeNode root) {
       heler(root);
    }

    TreeNode pre;
    void  heler(TreeNode node){
      if (node==null) return;
        heler(node.right);
        heler(node.left);
        
        node.right=pre;
        node.left=null;
        pre=node;
    }*/

    //stack
/*    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
            if(!stack.isEmpty()) node.right=stack.peek();

            node.left=null;
        }
    }*/


    //用while寻找上一个节点，然后把右子树拆过去
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode last = cur.left;
                //寻早左子树最右节点
                while (last.right != null) last = last.right;
               //拆到左子树最下面
                last.right = cur.right;
           //flat
                cur.right = cur.left;
                cur.left = null;

            }
            //只需要进入左子树
            cur = cur.right;
        }
    }
}
