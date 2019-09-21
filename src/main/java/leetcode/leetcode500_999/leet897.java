package leetcode.leetcode500_999;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libin on 2019/1/3.
 */
public class leet897 {
    //此版本树位多了0,递归看该节点
//    TreeNode result = new TreeNode(0);
//    public TreeNode increasingBST(TreeNode root) {
//       TreeNode r=result;
//        inorder(root);
//        result=null;
//        return r;
//
//
//    }
//
//    void inorder(TreeNode node ) {
//
//        if (node == null) return;
//
//        inorder(node.left);
//        System.out.println(node.val);
//        result=node;
//        result.right=new TreeNode(0);
//        result=result.right;
//
//        inorder(node.right);
//
//    }
    //递归看该节点的右节点
//TreeNode cur;
//    public TreeNode increasingBST(TreeNode root) {
//        TreeNode ans = new TreeNode(0);
//        cur = ans;
//        inorder(root);
//        return ans.right;
//    }
//
//    public void inorder(TreeNode node) {
//        if (node == null) return;
//        inorder(node.left);
//        node.left = null;
//        cur.right = node;
//        cur = node;
//        inorder(node.right);
//    }
  //用list保存中序遍历节点，然后重新构造树
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root, vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v: vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }
}
