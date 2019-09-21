package leetcode.leetcode500_999;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by libin on 2019/1/21.
 */
public class leet515 {
    //mine   层序遍历  10ms
    public List<Integer> largestValues(TreeNode root) {
         List<Integer> result=new LinkedList<>();
         if(root==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
          int size=queue.size();
          int max=Integer.MIN_VALUE;
         while (size-->0){
             TreeNode node=queue.poll();
             if(node.val>max) max=node.val;
             if(node.left!=null) queue.add(node.left);
             if(node.right!=null)  queue.add(node.right);
         }
         result.add(max);
        }
return result;
    }

//深度优先遍历   8ms
   /* public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }

    //res的index就是每层的深度
    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
        //假如该层还没有元素
        if(d == res.size()){
            res.add(root.val);
        }
        //比较最大的加入
        else{
            //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        //继续遍历
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }*/
}
