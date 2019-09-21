package leetcode.leetcode1_499;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by libin on 2019/3/1.
 */
public class leet105 {

    //mine 递归
   /* public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        return preInCreat(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }*/


   TreeNode preInCreat(int[] preorder, int []inorder, int l1, int h1, int l2, int h2){
        TreeNode  root=new TreeNode(0);
        root.val=preorder[l1];

        //找根节点在中序遍历中的位置
       int i=l2;
        for(;inorder[i]!=root.val;i++);

        //求左子树和右子树的长度
         int llen=i-l2;
         int rlen=h2-i;

         if(llen>0)
             root.left=preInCreat(preorder,inorder,l1+1,l1+llen,l2,l2+llen-1);
         else root.left=null;
         if(rlen>0)
             root.right=preInCreat(preorder,inorder,h1-rlen+1,h1,h2-rlen+1,h2);
         else root.right=null;

         return root;
    }


    //遍历做法  牛逼！！！！！！
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // deal with edge case(s)
        if (preorder.length == 0) {
            return null;
        }

        // build a map of the indices of the values as they appear in the inorder array
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // initialize the stack of tree nodes
        Stack<TreeNode> stack = new Stack<>();
        int value = preorder[0];
        TreeNode root = new TreeNode(value);
        stack.push(root);

        // for all remaining values...
        for (int i = 1; i < preorder.length; i ++) {
            // create a node
            value = preorder[i];
            TreeNode node = new TreeNode(value);

            if (map.get(value) < map.get(stack.peek().val)) {
                // the new node is on the left of the last node,
                // so it must be its left child (that's the way preorder works)
                stack.peek().left = node;
            } else {
                // the new node is on the right of the last node,
                // so it must be the right child of either the last node
                // or one of the last node's ancestors.
                // pop the stack until we either run out of ancestors
                // or the node at the top of the stack is to the right of the new node
                TreeNode parent = null;
                while(!stack.isEmpty() && map.get(value) > map.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }

        return root;
    }
}
