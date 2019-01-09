package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by libin on 2019/1/9.
 */
public class leet226 {
    //！！典型错误！！  这样操作ledt已经改变了哦
//    public TreeNode invertTree(TreeNode root) {
//        if(root==null) return null;
//        root.left= invertTree(root.right) ;
//        root.right= invertTree(root.left);
//
//
//      return root;
//    }
    //递归正解 0ms
  /*  public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;


        return root;
    }*/
  //迭代方式 层序遍历 （慢于递归） 1ms
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}
