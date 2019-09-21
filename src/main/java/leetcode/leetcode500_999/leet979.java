package leetcode.leetcode500_999;

import leetcode.TreeNode;

/**
 * Created by libin on 2019/1/20.
 */
public class leet979 {
    int touch=0;
    public int distributeCoins(TreeNode root) {

         helper(root);
        return touch;

    }


    void    preOrder(TreeNode root,TreeNode node,int path){
        if(node==null) return ;
     preOrder(root,node.left,path+1);
     preOrder(root,node.right,path+1);
  //将根节点多余的硬币往子节点移动
        if(node.val==0&&root.val>1) {
            touch += path;
            root.val-=1;
            node.val+=1;
        }
     }

  //把子节点的多余coin往根节点移动
     void helper(TreeNode node){
        if(node==null) return;

        helper(node.left);
        helper(node.right);
        if(node.left!=null&&node.left.val>1){
            touch+=node.left.val-1;
            node.val+=node.left.val-1;
            node.left.val=1;
        }
         if(node.right!=null&&node.right.val>1){
             touch+=node.right.val-1;
             node.val+=node.right.val-1;
             node.right.val=1;
         }
         //判断子节点是否还存在0
    if(node.val>1) preOrder(node,node,0);

     }
}
