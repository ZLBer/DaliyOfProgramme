package leetcode.leetcode1_499;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by libin on 2019/3/1.
 */
public class leet106 {
    //mine 递归
   /* public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        return postInCreat(postorder,inorder,0,postorder.length-1,0,inorder.length-1);
    }*/


    TreeNode postInCreat(int[] postorder, int []inorder, int l1, int h1, int l2, int h2){
        TreeNode  root=new TreeNode(0);
        root.val=postorder[h1];

        //找根节点在中序遍历中的位置
        int i=l2;
        for(;inorder[i]!=root.val;i++);

        //求左子树和右子树的长度
        int llen=i-l2;
        int rlen=h2-i;

        if(llen>0)
            root.left=postInCreat(postorder,inorder,l1,l1+llen-1,l2,l2+llen-1);
        else root.left=null;
        if(rlen>0)
            root.right=postInCreat(postorder,inorder,h1-rlen,h1-1,h2-rlen+1,h2);
        else root.right=null;

        return root;
    }




    //遍历
    public TreeNode buildTree( int[] inorder,int[] postorder) {
        // deal with edge case(s)
        if (postorder.length == 0) {
            return null;
        }

        // build a map of the indices of the values as they appear in the inorder array
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // initialize the stack of tree nodes
        Stack<TreeNode> stack = new Stack<>();
        int value = postorder[postorder.length-1];
        TreeNode root = new TreeNode(value);
        stack.push(root);

        // for all remaining values...
        for (int i = postorder.length-2; i >=0 ; i --) {
            // create a node
            value = postorder[i];
            TreeNode node = new TreeNode(value);

            if (map.get(value) > map.get(stack.peek().val)) {
                // the new node is on the left of the last node,
                // so it must be its left child (that's the way preorder works)
                stack.peek().right = node;
            } else {
                // the new node is on the right of the last node,
                // so it must be the right child of either the last node
                // or one of the last node's ancestors.
                // pop the stack until we either run out of ancestors
                // or the node at the top of the stack is to the right of the new node
                TreeNode parent = null;
                while(!stack.isEmpty() && map.get(value) < map.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.left = node;
            }
            stack.push(node);
        }

        return root;
    }
}
