package leetcode;

/**
 * Created by libin on 2019/1/11.
 */
public class leet700 {
    //第一版 6ms 没有看清是二叉搜索树   左小右大
   /* TreeNode result;
    public TreeNode searchBST(TreeNode root, int val) {
        inorder(root,val);
             return result;
    }
    void  inorder(TreeNode node,int val){
        if(node==null) return;
        if(node.val==val) result=node;
        inorder(node.left,val);
        inorder(node.right,val);
    }*/

    // 按照二叉搜索树查找  3ms
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        while (true) {
            if (root.val == val) {
                return root;
            } else if (root.val < val) {
                root = root.right;
            } else {
                root = root.left;
            }

            if (root == null) {
                return null;
            }
        }

    }
}
