package leetcode._jianzhioffer;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p32 {

    //I
/*    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
    Queue<TreeNode> queue=new LinkedList<>();
     queue.add(root);
     List<Integer> res=new ArrayList<>();
     while (!queue.isEmpty()){
       int size=queue.size();
       while (size-->0){
        TreeNode node =queue.poll();
       res.add(node.val);
       if(node.left!=null) queue.add(node.left);
       if(node.right!=null) queue.add(node.right);
       }
     }

    return  res.stream().mapToInt(a->a).toArray();
    }*/
    //II
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return  res;
    List<TreeNode> queue=new ArrayList<>();
    queue.add(root);
    int level=0;

    while (!queue.isEmpty()){
       List<TreeNode> newQueue=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node=queue.get(i);
            list.add(node.val);
            if(node.left!=null)  newQueue.add(node.left);
            if(node.right!=null) newQueue.add(node.right);
        }

        if(level%2!=0){
            Collections.reverse(list);
        }


     queue=newQueue;
       res.add(list);
       level++;
    }
    return  res;

    }
}
