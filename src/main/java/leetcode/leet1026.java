package leetcode;

/**
 * Created by libin on 2019/4/16.
 */
public class leet1026 {

    //mine  记录祖先的最大值和最小值
    int V=-1;
    public int maxAncestorDiff(TreeNode root) {
      DFS(root.val,root.val,root);
      return V;
    }

   void  DFS(int maxAncestor,int minAncestor,TreeNode node){
       if(node==null) return;

       V=Math.max(V,Math.abs(node.val-maxAncestor));
       V=Math.max(V,Math.abs(node.val-minAncestor));
     maxAncestor=Math.max(node.val,maxAncestor);
     minAncestor=Math.min(node.val,minAncestor);
       DFS(maxAncestor,minAncestor,node.left);
       DFS(maxAncestor,minAncestor,node.right);
    }



//纯递归 记录min和max，递归到底时计算V
   /* public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode root, int mn, int mx) {
        if (root == null) return mx - mn;
        mx = Math.max(mx, root.val);
        mn = Math.min(mn, root.val);
        return Math.max(dfs(root.left, mn, mx), dfs(root.right, mn, mx));
    }*/
}


