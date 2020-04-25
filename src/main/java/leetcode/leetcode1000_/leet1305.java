package leetcode.leetcode1000_;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leet1305 {
    //mine 直接法
/*    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> res=new ArrayList<>();
      helper(root1,res);
      helper(root2,res);
        Collections.sort(res);
        return res;
    }

    void helper(TreeNode node,List<Integer> res){
        if(node==null) return;
        helper(node.left,res);
      res.add(node.val);
        helper(node.right,res);
    }*/

//mine 反而比之前的还慢
/*
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> q1=new LinkedList<>(),q2=new LinkedList<>();
        helper(root1,q1);
        helper(root2,q2);
        List<Integer> res=new ArrayList<>();
        while (!q1.isEmpty()&&!q2.isEmpty()){
           if(q1.peek()<q2.peek()){
               res.add(q1.poll());
           }
           else {
               res.add(q2.poll());
           }
        }
        while (!q1.isEmpty()){
            res.add(q1.poll());
        }
        while (!q2.isEmpty()){
            res.add(q2.poll());
        }
        return res;
    }
    void helper(TreeNode node,Queue<Integer> res){
        if(node==null) return;
        helper(node.left,res);
        res.offer(node.val);
        helper(node.right,res);
    }
*/

//直接在遍历的时候换
    public List<Integer> getAllElements(leetcode.TreeNode root1, leetcode.TreeNode root2) {
     Stack<leetcode.TreeNode> s1=new Stack<>(),s2=new Stack<>();
     helper(root1,s1);
     helper(root2,s2);
     List<Integer> res=new ArrayList<>();
     while (!s1.isEmpty()||!s2.isEmpty()){
         Stack<leetcode.TreeNode> temp=(s1.isEmpty())?s2:(s2.isEmpty()?s1:(s1.peek().val<s2.peek().val?s1:s2));
         leetcode.TreeNode t=temp.pop();
          res.add(t.val);
          helper(t.right,temp);
     }
     return res;
     }
    void helper(leetcode.TreeNode node, Stack<TreeNode> stack){
        if(node==null) return;
        stack.push(node);
        helper(node.left,stack);
    }
}
