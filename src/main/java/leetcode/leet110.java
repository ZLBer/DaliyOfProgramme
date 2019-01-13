package leetcode;

/**
 * Created by libin on 2019/1/13.
 */
public class leet110 {
    //两个递归
/*    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
       if(Math.abs(height(root.left)-height(root.right))<=1)
           return isBalanced(root.left)&&isBalanced(root.right);
       else  return false;
    }
    int height(TreeNode node){
        if(node==null) return 0;
        int left=height(node.left);
        int right=height(node.right);
        return left>right?left+1:right+1;
    }*/

   //更简单的递归方式  O(n)
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root) != -1;
    }
    //除了返回高度外 用-1记录此节点不平衡
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
