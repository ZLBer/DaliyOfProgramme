package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leet1609 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int level=0;

       while (!queue.isEmpty()){
           int size=queue.size();
           Integer pre=null;
           while (size-->0){
           TreeNode node=queue.poll();
              // System.out.println(pre+" "+node.val);
            if(level%2==0){
             if(node.val%2!=1||(pre!=null&&pre>=node.val)){
                return false;
             }
           }else {
                if(node.val%2!=0||(pre!=null&&pre<=node.val)){
                  return false;
                }
            }
             pre=node.val;
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
           }

           level++;
       }
       return  true;
    }
}
