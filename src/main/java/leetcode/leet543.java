package leetcode;

/**
 * Created by libin on 2019/1/9.
 */
public class leet543 {
    //错误的解法
//    public int diameterOfBinaryTree(TreeNode root) {
//        if (root==null) return 0;
//         return maxPath(root.left)+maxPath(root.right);
//    }
//     int maxPath(TreeNode node){
//        if(node==null) return 0;
//        int left=maxPath(node.left);
//        int right=maxPath(node.right);
//        return left>right?left+1:right+1;
//
//     }

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    //后序遍历
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }

}
