package leetcode._4_30Days;

import leetcode.TreeNode;

import java.util.Stack;

public class ConstructBinarySearchTreefromPreorderTraversal {
    //递归
/*    public TreeNode bstFromPreorder(int[] preorder) {
  return helper(preorder,Integer.MAX_VALUE);
    }
    int index=0;
    TreeNode helper(int[]A, int bound ){
        if(index>=A.length||A[index]>bound) return null;
        TreeNode root=new TreeNode(A[index++]);
        root.left=helper(A,root.val);
        root.right=helper(A,bound);
        return root;
    }*/

    //前序 中序构造二叉树

/*

    int preIdx=0;
    int []preOrder;
    Map<Integer,Integer> map;
    public TreeNode bstFromPreorder(int[] preorder) {

        int []inorder= Arrays.copyOf(preorder,preorder.length);

        Arrays.sort(inorder);

        preOrder=preorder;
        map=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
          map.put(inorder[i],i);
        }
        return helper(0,preorder.length-1);
    }

    TreeNode helper(int start,int end){
        if(start>end) return null;
        if(start==end) return new TreeNode(preOrder[preIdx++]);


        int val=preOrder[preIdx++];
        int mid=map.get(val);
        TreeNode root=new TreeNode(val);
        root.left=helper(start,mid-1);
        root.right=helper(mid+1,end);
        return root;
    }
*/

    //非递归
    public TreeNode bstFromPreorder(int[] preorder) {
       if(preorder.length==0) return null;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode root=new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node=new TreeNode(preorder[i]);
            if(stack.peek().val>node.val){
               stack.peek().left=node;
            }else {
                TreeNode parent=stack.peek();
                while (!stack.isEmpty()&&node.val>stack.peek().val){
                    parent=stack.pop();
                }
                parent.right=node;
            }

            stack.push(node);
        }

        return root;
    }


}
