package leetcode;

public class leet1123$ {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
      int depth=depth(root);
return helper(root,depth);

    }
    //先求深度
    int depth(TreeNode treeNode){
        if(treeNode==null) return 0;
        return 1+Math.max(depth(treeNode.left),depth(treeNode.right));
    }
    TreeNode helper(TreeNode node,int depth){
    if(node==null) return null;
    if(depth==1) return node;
    TreeNode L=helper(node.left,depth-1),R=helper(node.right,depth-1);
    //若左右都非空，则返回该公共节点
    if(L!=null&&R!=null) return node;
    //否则 返回其中一个
    return  L==null?R:L;
    }
}
