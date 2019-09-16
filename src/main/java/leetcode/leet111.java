package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leet111 {
    //层序遍历
/*    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int depth=0;
        while (!queue.isEmpty()){
            int size=queue.size();
             depth++;
             while (size-->0){
                 TreeNode node=queue.poll();
                 if(node.left==null&&node.right==null){
                     return depth;
                 }
                 if (node.left!=null)
                     queue.add(node.left);
                  if(node.right!=null)
                     queue.add(node.right);

             }
        }
        return 0;
    }*/

    //递归
    public int minDepth(TreeNode root) {
        if(root==null) return 0 ;
    int left=minDepth(root.left);
    int  right=minDepth(root.right);

    if(left==0&&right==0) return 1;
    else if(left==0) return right+1;
    else if(right==0) return left+1;
    else return Math.min(left,right)+1;

    //上面的那些可以优化成
     //   return (left==0||right==0)?left+right+1:Math.min(left,right)+1;
    }
}
