package leetcode.leetcode500_999;

import javafx.util.Pair;
import leetcode.TreeNode;

import java.util.HashMap;

/**
 * Created by libin on 2019/1/31.
 */
public class leet865$ {
    //求深度
    /*public int depth(TreeNode root){
        if(root == null ) return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if( root == null ) return null;
        int left =  depth(root.left);
        int right = depth(root.right);
        //如果左子树深度=右子树深度  则表示该点就是公共点
        if( left  == right ) return root;

        //如果左子树更深
        if( left > right ) return subtreeWithAllDeepest(root.left);
        //右子树更深
        return subtreeWithAllDeepest(root.right);
    }*/


 //求深度 ，但是会记下每个点的深度  O(N)
   /* public int depth(TreeNode root,HashMap<TreeNode,Integer> map){
        if(root == null ) return 0;
        if( map.containsKey(root) ) return map.get(root);
        int max = Math.max(depth(root.left,map),depth(root.right,map))+1;
        map.put(root,max);
        return max;
    }
    public TreeNode dfs(TreeNode root, HashMap<TreeNode,Integer> map){
        int left =  depth(root.left,map);
        int right = depth(root.right,map);
        if( left  == right ) return root;
        if( left > right ) return dfs(root.left,map);
        return dfs(root.right,map);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if( root == null ) return null;
        HashMap<TreeNode,Integer> map = new HashMap<>();
        depth(root,map);
        return dfs(root,map);
    }*/


    //大神的做法
//pair对  key记录深度 ，value记录node
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deep(root).getValue();
    }

    public Pair<Integer, TreeNode> deep(TreeNode root) {
        if (root == null) return new Pair(0, null);
        Pair<Integer, TreeNode> l = deep(root.left), r = deep(root.right);

        int d1 = l.getKey(), d2 = r.getKey();
        return new Pair(Math.max(d1, d2) + 1, d1 == d2 ? root : d1 > d2 ? l.getValue() : r.getValue());
    }
}
