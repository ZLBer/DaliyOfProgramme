package leetcode._5_30Days;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsinBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            boolean l=false,r=false;
            while (size-->0){
               TreeNode node = queue.poll();
               int lef=0,rig=0;
               if(node.left!=null){
                   queue.add(node.left);
                   lef=node.left.val;
               }else {
                   lef=-1;
               }
               if(node.right!=null){
                   queue.add(node.right);
                   rig=node.right.val;
               }
               else {
                   rig=-1;
               }
               if(lef==x&&rig==y||lef==y&&rig==x) return false;
               if(lef==x||rig==x)  l=true;
               if(lef==y||rig==y)  r=true;
            }
            if(l&r) return true;
            else if(l||r) return false;
        }

        return false;
    }
}
