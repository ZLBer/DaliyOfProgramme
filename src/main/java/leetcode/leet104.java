package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by libin on 2019/1/9.
 */
public class leet104 {
    //递归  0ms
 /*      public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return left>right?left+1:right+1;
    }*/
    //BFs (层序遍历) 2ms
/*    public int maxDepth(TreeNode root) {
       if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int count =0;
     while (!queue.isEmpty()){
         //一次操作一层
         int size = queue.size();
         while(size-->0){
             TreeNode n=queue.poll();
             if(n.left!=null) queue.offer(n.left);
             if(n.right!=null) queue.offer(n.right);
         }
         count++;


     }
     return count;
    }*/
     //DFS(前序遍历)  5ms
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int max_depth = 0;
        Stack<TreeNode> s=new Stack<>();
       TreeNode p=root;
       //用val保存深度
       p.val=1;
        while (!s.empty()||p!=null){
           if(p!=null){
               //判断该节点深度和最大深度
               max_depth = Math.max(max_depth, p.val);
               s.push(p);
               if(p.left!=null) p.left.val=p.val+1;
               p=p.left;
           }else {
               p=s.pop();
               if(p.right!=null) p.right.val=p.val+1;
               p=p.right;
           }

        }
      return max_depth;
    }

}
