package leetcode.leetcode1_499;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by libin on 2019/1/30.
 */
public class leet94 {

    //mine 递归
   /* List<Integer> result=new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
   helper(root);
   return result;
    }
    void  helper(TreeNode node){
        if(node==null) return;
        helper(node.left);
       result.add(node.val);
        helper(node.right);
    }*/

  //非递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty()||p!=null) {
            if (p != null) {
                stack.add(p);
                p = p.left;
            } else {
                p = stack.pop();

                result.add(p.val);
                p = p.right;
            }
        }

        return result;


    }

}
