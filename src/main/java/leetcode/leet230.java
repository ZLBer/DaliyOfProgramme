package leetcode;

import leetcode.LQTest.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leet230 {
    //mine
/*    List<Integer> list=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return list.get(k);
    }


    void helper(TreeNode node,int k){
        if(node==null|list.size()>=k) return;
        helper(node.left,k);
        if(list.size()>=k) return;
        helper(node.right,k);
        list.add(node.val);
    }*/

    //其实根本不用保存的啊  中序遍历本来就是一个递增序列


    public int kthSmallest(TreeNode root, int k) {
        count=k;
        helper(root);
        return result;
    }
      int count=0;
    int result=0;
    void helper(TreeNode node){
       if(node.left!=null) helper(node.left);
       count--;
       if(count==0){
           result=node.val;
           return;
       }
       if(node.right!=null) helper(node.right);
    }


    //非递归
   /* public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }

        return -1; // never hit if k is valid
    }*/
}
