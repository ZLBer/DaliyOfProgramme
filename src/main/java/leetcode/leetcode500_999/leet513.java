package leetcode.leetcode500_999;

import leetcode.TreeNode;
import org.apache.kafka.common.metrics.stats.Max;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by libin on 2019/1/21.
 */
public class leet513 {
   /* int MaxLevel=0;
    int left=0;
    public int findBottomLeftValue(TreeNode root) {
        if(root.left==null) return root.val;
         helper(root,0);
         return left;
    }
    void  helper(TreeNode node,int level){
        if(node==null) return;
        if(node.left.left==null&&node.left.right==null)  {
            if(level>MaxLevel) {
                MaxLevel=level;
             left=node.left.val;
            }
        }
    helper(node.left,level+1);
        helper(node.right,level+1);
    }
*/
  //myself  层序遍历，考虑每层的第一个元素
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int result=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            TreeNode node= queue.peek();
            if(node.left==null&&node.right==null)  result=node.val;
            while (size-->0){
               TreeNode cur= queue.poll();
               if(cur.left!=null) queue.add(cur.left);
               if(cur.right!=null) queue.add(cur.right);
            }
        }
        return result;
    }

  //层序遍历，但是先遍历右子树，再遍历左子树，这样就不用考虑每一层的最左节点，最后遍历的节点一定是最后一层的最左节点
/*    public int findLeftMostNode(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return root.val;
    }*/

  //深度优先遍历，记录每次的深度，因为每次遍历的一定是该层的最左节点 （先序遍历）
   /* public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue(root, 1, new int[]{0,0});
    }
    public int findBottomLeftValue(TreeNode root, int depth, int[] res) {
        if (res[1]<depth) {res[0]=root.val;res[1]=depth;}
        if (root.left!=null) findBottomLeftValue(root.left, depth+1, res);
        if (root.right!=null) findBottomLeftValue(root.right, depth+1, res);
        return res[0];
    }*/
}
