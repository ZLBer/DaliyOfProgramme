package leetcode;

/**
 * Created by libin on 2019/1/18.
 */
public class leet669$ {
 //good recursion
        public TreeNode trimBST(TreeNode root, int L, int R) {
            //空就返回空
            if (root == null) return root;
            //此处说明右子树已经全部大于R，只需遍历左子树
            if (root.val > R) return trimBST(root.left, L, R);
            //同上
            if (root.val < L) return trimBST(root.right, L, R);
            //递归修建左子树
            root.left = trimBST(root.left, L, R);
            //递归修建右子树
            root.right = trimBST(root.right, L, R);
            //递归返回
            return root;
    }
}
