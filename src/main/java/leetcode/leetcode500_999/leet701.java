package leetcode.leetcode500_999;

import leetcode.TreeNode;

/**
 * Created by libin on 2019/1/15.
 */
public class leet701 {
    //myself easy to understand
 /*   public TreeNode insertIntoBST(TreeNode root, int val) {
          helper(root,val);
          return root;
    }

    void  helper(TreeNode node,int val){
        if(node==null) return;
        if(node.left!=null&&node.val>val)
            helper(node.left,val);
        if(node.right!=null&&node.val<val)
            helper(node.right,val);
        if(node.left==null&&node.val>val)
            node.left=new TreeNode(val);
        if(node.right==null&&node.val<val)
            node.right=new TreeNode(val);
     }*/

//an elegant solution
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
