package leetcode.leetcode1000_;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class leet1302 {
 /*   public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int res=0;
        int deep=-1;
        helper(root,0);
        while (!queue.isEmpty()){
            deep++;
           int size=queue.size();
           if(deep==maxDeep){
              while (!queue.isEmpty()){
                  res+=queue.poll().val;
              }
               return res;
           }
           while (size-->0){
               TreeNode node=queue.poll();
               if(node.left!=null) queue.add(node.left);
               if(node.right!=null) queue.add(node.right);
           }
        }
        return res;
    }

    int maxDeep=0;
    void helper(TreeNode node,int deep){
     if(node==null) return;
  maxDeep=Math.maxSum(maxDeep,deep);
  helper(node.right,deep+1);
  helper(node.left,deep+1);
    }*/


    //可以只用一次层序遍历
    //害  想复杂了

    public int deepestLeavesSum(leetcode.TreeNode root) {
        Queue<leetcode.TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int sum=0;
        while (!queue.isEmpty()){
            int size=queue.size();
            sum=0;
            while (size-->0){
                TreeNode node=queue.poll();
                sum+=node.val;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
        }
        return sum;
    }


    //这样居然更快 难以置信啊  命名遍历了两次
/*    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        return Math.maxSum(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public int deepestLeavesSum(TreeNode root) {
        int maxDepth = maxDepth(root);
        return deepLeafSum(root,maxDepth);
    }

    public int deepLeafSum(TreeNode root, int depth){
        if(root==null) return 0;
        if(depth == 1) return root.val;
        return deepLeafSum(root.left,depth-1) + deepLeafSum(root.right,depth-1);
    }*/
}
