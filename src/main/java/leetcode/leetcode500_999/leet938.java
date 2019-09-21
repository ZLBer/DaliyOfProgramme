package leetcode.leetcode500_999;

import leetcode.TreeNode;

import java.util.Stack;

/**
 * Created by libin on 2019/1/15.
 */
public class leet938 {
     // 递归法 6ms
    public int rangeSumBST(TreeNode root, int L, int R) {
            int sum=0;
             if(root==null) return 0;
             if(root.val>=L&&root.val<=R)
                 sum+=root.val;
             sum+=rangeSumBST(root.left,L,R)+rangeSumBST(root.right,L,R);
             return sum;
    }

    //DFS
/*    public int rangeSumBST(TreeNode root, int L, int R) {
        int ans = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (L <= node.val && node.val <= R)
                    ans += node.val;
                if (L < node.val)
                    stack.push(node.left);
                if (node.val < R)
                    stack.push(node.right);
            }
        }
        return ans;
    }*/




}
