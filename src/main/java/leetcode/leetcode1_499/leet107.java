package leetcode.leetcode1_499;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by libin on 2019/1/12.
 */
public class leet107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
            LinkedList<List<Integer>> result=new LinkedList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null) return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> temp=new LinkedList<>();
            while (size-- > 0) {
                root = queue.poll();
                temp.add(root.val);
              if(root.left!=null) queue.add(root.left);
              if(root.right!=null) queue.add(root.right);
            }
            result.addFirst(temp);
        }
        return result;
    }
}
