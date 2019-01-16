package leetcode;

/**
 * Created by libin on 2019/1/16.
 */
public class leet814 {
    //递归写法
    public TreeNode pruneTree(TreeNode root) {

        return helper(root);
    }
    TreeNode helper(TreeNode node){
        if(node==null) return null;
        node.left=helper(node.left);
        node.right=helper(node.right);
         if(node.val==0&&node.left==null&&node.right==null){
             return null;
         }
         return node;
    }
}
