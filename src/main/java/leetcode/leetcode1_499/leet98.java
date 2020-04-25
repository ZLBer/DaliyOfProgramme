package leetcode.leetcode1_499;

import java.util.Stack;

public class leet98 {

    // 错误的做法 只判断当前节点
/*    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.left!=null&&root.left.val>root.val) return false;
        if(root.right!=null&&root.right.val<root.val) return false;
        boolean left=isValidBST(root.left);
        boolean right=isValidBST(root.right);
        return left&&right;
    }*/

  //mine 标记二叉树是往左走还是往右走
/*    public boolean isValidBST(TreeNode root) {
     return DFS(root,new ArrayList<>());
    }
    boolean DFS(TreeNode node, List<simpleNode> pre){
   if(node==null) return true;
        for (simpleNode simpleNode : pre) {
            if (simpleNode.isLeft == true && simpleNode.val <= node.val) return false;
            else if(simpleNode.isLeft == false&&simpleNode.val>=node.val) return false;
        }
       //左子树
        pre.add(new simpleNode(node.val, true));
        boolean left=DFS(node.left,pre);
        //右子树
        pre.remove(pre.size()-1);
        pre.add(new simpleNode(node.val, false));
        boolean right=DFS(node.right,pre);
        pre.remove(pre.size()-1);
        return left&&right;

    }
    class simpleNode{
        int val;
        boolean isLeft;

        public simpleNode(int val, boolean isLeft) {
            this.val = val;
            this.isLeft = isLeft;
        }
    }*/


    //忘记这个特性了  二叉搜索树的中序遍历就是顺序
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode pre=null;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();

        if(pre!=null&&pre.val>=root.val) return false;
        pre=root;
        root=root.right;

    }
        return true;
    }


    //递归传范围
 /*   public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }*/
}
