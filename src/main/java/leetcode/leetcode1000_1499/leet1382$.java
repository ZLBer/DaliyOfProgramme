package leetcode.leetcode1000_1499;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class leet1382$ {
    //尝试去旋转二叉树可太困难了

    //尝试重建新的平衡二叉树,以前好像从来没这么考虑过
    //思路是别人的  代码是自己写的
    List<Integer> list=new ArrayList<>();
    public leetcode.TreeNode balanceBST(leetcode.TreeNode root) {
        inOrder(root);
 return helper(0,list.size()-1);
    }

     void inOrder(leetcode.TreeNode node){
       if(node==null) return;
       inOrder(node.left);
       list.add(node.val);
       inOrder(node.right);
    }
    leetcode.TreeNode helper(int begin, int end){
        if(begin>end) return null;
        int mid=(begin+end)/2;
        leetcode.TreeNode root=new TreeNode(list.get(mid));
        root.left=helper(begin,mid-1);
        root.right=helper(mid+1,end);
        return root;
    }
}