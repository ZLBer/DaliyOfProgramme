package leetcode._jianzhioffer;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class p07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

    Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
      return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
   TreeNode helper(int []preorder,int pstart,int pend,int []inorder,int istart,int iend,Map<Integer,Integer> map){
   if(pstart>pend){
       return null;
   }

    TreeNode root=new TreeNode(preorder[pstart]);

    int index=map.get(preorder[pstart]);

    int leftLength=index-istart;
    root.left=helper(preorder,pstart+1,pstart+leftLength,inorder,istart,index-1,map);
    root.right=helper(preorder,pstart+leftLength+1,pend,inorder,index+1,iend,map);

    return root;
   }
}
