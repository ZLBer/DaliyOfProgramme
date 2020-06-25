package leetcode._jianzhioffer;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class p4 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
       if(root==null) return res;
     dfs(root,sum,new ArrayList<>());
     return res;
    }

    List<List<Integer>> res=new ArrayList<>();
   void dfs(TreeNode node,int sum,List<Integer> path){
     if(node.left==null&&node.right==null){
        if(sum==node.val){
     List <Integer> list=new ArrayList<>(path);
     list.add(node.val);
     res.add(list);
        }
        return;
     }
     path.add(node.val);
     if(node.left!=null)
     dfs(node.left,sum-node.val,path);
     if(node.right!=null)
     dfs(node.right,sum-node.val,path);
     path.remove(path.size()-1);
   }
}
