package leetcode.leetcode500_999;

import leetcode.TreeNode;

import java.util.Stack;

/**
 * Created by libin on 2019/1/9.
 */
public class leet538 {
    //二叉搜索树 先访问右子树再访问左子树  返回的就是递减序列
    //递归法
    int sum=0;
    public TreeNode convertBST(TreeNode root) {

        if(root!=null){
            convertBST(root.right);
            sum+=root.val;
            root.val=sum;
            convertBST(root.left);
        }
        return root;
    }
    // 深度优先 stack
   /* public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            int tmp = cur.val;
            cur.val += sum;
            sum += tmp;
            cur = cur.left;
        }
        return root;
    }*/

}
