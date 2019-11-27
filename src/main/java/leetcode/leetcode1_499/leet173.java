package leetcode.leetcode1_499;

import java.util.Stack;

public class leet173 {
 /*   class BSTIterator {
        TreeSet<Integer> treeSet=new TreeSet<>();
        public BSTIterator(TreeNode root) {
        heler(root);
        }

        *//** @return the next smallest number *//*
        public int next() {
           return  treeSet.pollFirst();
        }

        *//** @return whether we have a next smallest number *//*
        public boolean hasNext() {
             return !treeSet.isEmpty();
        }
        void heler(TreeNode node){
          if(node==null) return;
          treeSet.add(node.val);
          heler(node.left);
          heler(node.right);
        }
    }*/


    class BSTIterator {
     Stack<TreeNode> stack=new Stack<>();
        public BSTIterator(TreeNode root) {
           helper(root);
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node=stack.pop();
            helper(node.right);
            return node.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
           return !stack.isEmpty();
        }

        void helper(TreeNode node){
            while (node!=null){
                stack.push(node);
                node=node.left;
            }
        }
    }
   /* class BSTIterator {
         List<Integer> list=new ArrayList<>();
        public BSTIterator(TreeNode root) {
           heler(root);
           list.sort(Integer::compareTo);
        }

        *//** @return the next smallest number *//*
        public int next() {
           return list.remove(0);
        }

        *//** @return whether we have a next smallest number *//*
        public boolean hasNext() {
          return !list.isEmpty();
        }
        void heler(TreeNode node){
            if(node==null) return;
            list.add(node.val);
            heler(node.left);
            heler(node.right);
        }
    }*/
}
