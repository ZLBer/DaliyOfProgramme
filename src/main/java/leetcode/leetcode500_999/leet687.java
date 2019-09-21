package leetcode.leetcode500_999;

import java源码学习.util.Map;
import leetcode.TreeNode;

import javax.swing.table.TableRowSorter;

public class leet687 {

    public int longestUnivaluePath(TreeNode root) {
  int[] res=new int[1];
  if(root!=null) dfs(root,res);
  return res[0];
    }
    int  dfs(TreeNode node, int [] res){
        int l=node.left!=null?dfs(node.left,res):0;
        int r=node.right!=null?dfs(node.right,res):0;
        int resl=node.left!=null&&node.val==node.left.val?l+1:0;
        int resr=node.right!=null&&node.val==node.right.val?r+1:0;

        res[0]= Math.max(res[0],resl+resr);
        return Math.max(resl,resr);

    }
}
