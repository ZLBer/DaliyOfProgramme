package leetcode;

import java.util.LinkedList;

/**
 * Created by libin on 2019/1/15.
 */
public class leet112 {
    //递归 1ms
    public boolean hasPathSum(TreeNode root, int sum) {
          return helper(root,sum);

    }
    boolean helper(TreeNode node ,int sum) {
        if (node == null) return false;
       boolean left=false;
       boolean  right=false;
        if (node.val == sum&&node.left==null&&node.right==null) return true;
        else {
           left= helper(node.left, sum - node.val);
            right=helper(node.right, sum - node.val);
        }
        return left||right;
    }
//遍历  用两个栈，一个存节点，一个存此处的sum
    //明显慢于地递归 6ms
/*    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<Integer> sum_stack = new LinkedList();
        node_stack.add(root);
        sum_stack.add(sum - root.val);

        TreeNode node;
        int curr_sum;
        while ( !node_stack.isEmpty() ) {
            node = node_stack.pollLast();
            curr_sum = sum_stack.pollLast();
            if ((node.right == null) && (node.left == null) && (curr_sum == 0))
                return true;

            if (node.right != null) {
                node_stack.add(node.right);
                sum_stack.add(curr_sum - node.right.val);
            }
            if (node.left != null) {
                node_stack.add(node.left);
                sum_stack.add(curr_sum - node.left.val);
            }
        }
        return false;
    }*/
}
