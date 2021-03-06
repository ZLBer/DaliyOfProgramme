package leetcode.leetcode500_999;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class leet958$ {
    //教科书般的解法
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (queue.peek()!=null){
            TreeNode node=queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }

        while (!queue.isEmpty()&&queue.peek()==null){
            queue.poll();
        }
        return queue.isEmpty();
    }
}
