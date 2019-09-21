package leetcode.leetcode500_999;


import leetcode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class leet965{
    public boolean isUnivalTree(TreeNode root) {

        return  Preorder_traversal(root,root.val);
    }
    boolean Preorder_traversal(TreeNode node,int c){
        if(node==null)   return  true ;

        if(node.val==c) {
           boolean left=Preorder_traversal(node.left, c);
           boolean right= Preorder_traversal(node.right, c);
           if(left&&right) return true;
           else return false;

        }
        else return false;
    }

    //更好的版本
//    public boolean isUnivalTree(TreeNode root) {
//        if (root == null) return true;
//        int value = root.val;
//        if (root.left != null && root.left.val != value) return false;
//        if (root.right != null && root.right.val != value) return false;
//        return isUnivalTree(root.left) && isUnivalTree(root.right);
//    }


}
