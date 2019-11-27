package leetcode.leetcode1_499;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leet144 {

    //递归
 /*   public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> result=new ArrayList<>();
         helper(root,result);
         return result;
    }

    void helper(TreeNode node,List<Integer> list){
        if(node==null) return;
        list.add(node.val);
        helper(node.left,list);
        helper(node.right,list);
    }*/

    //非递归
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            result.add(node.val);
            if(node.right!=null)
                stack.push(node.right);
            if(node.left!=null)
                stack.push(node.left);
        }
        return result;
    }
}
