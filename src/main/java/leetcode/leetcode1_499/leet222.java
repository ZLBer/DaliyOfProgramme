package leetcode.leetcode1_499;

import leetcode.TreeNode;

public class leet222 {
    // mine  就简单的递归嘛  O（n）
/*    public int countNodes(TreeNode root) {
       if(root==null) return 0;

       return 1+countNodes(root.left)+countNodes(root.right);
    }*/

// O(log(n)^2)  全左，全右 剔除所有的完全子树，若不是完全子树，则进行递归
/*public int countNodes(TreeNode root) {

    int leftDepth = leftDepth(root);
    int rightDepth = rightDepth(root);

    if (leftDepth == rightDepth)
        return (1 << leftDepth) - 1;
    else
        return 1+countNodes(root.left) + countNodes(root.right);

}

    private int rightDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.right;
            dep++;
        }
        return dep;
    }

    private int leftDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.left;
            dep++;
        }
        return dep;
    }*/



// O(log(n)^2)
    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        //解释一下这里  如果右子树的高度等于左子树的高度，则表示左子树已经是完全二叉树了，只需要遍历右子树就可以了;若右子树的高度小于左子树的高度，则证明右子树是比左子树矮一层的完全二叉树
        return h < 0 ? 0 :
                height(root.right) == h-1 ? (1 << h) + countNodes(root.right)
                        : (1 << h-1) + countNodes(root.left);
    }
}
