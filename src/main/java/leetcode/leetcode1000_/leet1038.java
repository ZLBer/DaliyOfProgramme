package leetcode.leetcode1000_;

import leetcode.TreeNode;

public class leet1038 {
    //mine  两次前序遍历
/*    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        sum = dfsSum(root);
        change(root);
        return root;
    }

    int dfsSum(TreeNode root) {
        if (root == null)
            return 0;
        else return root.val + dfsSum(root.left) + dfsSum(root.right);
    }

    void change(TreeNode root) {
        if (root == null) return;
        change(root.left);
        int tem = root.val;
        root.val = sum;
        sum = sum - tem;
        change(root.right);
    }*/

  //直接一次遍历  先遍历右子树，然后根节点点 左子树  直接可以计算大于等于的val
    int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        pre = root.val = pre + root.val;
        if (root.left != null) bstToGst(root.left);
        return root;
    }
}
