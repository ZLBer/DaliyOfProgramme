package leetcode.leetcode500_999;

import leetcode.TreeNode;

/**
 * Created by libin on 2019/3/21.
 */
public class leet993 {
    int xDepth=0;
    int yDepth=0;
    Integer xFather=null;
    Integer yFather=null;
    public boolean isCousins(TreeNode root, int x, int y) {
       preOrder(root,null,0,x,y);
if(xDepth==yDepth&&xFather!=yFather) return true;
else return false;
    }

    void preOrder(TreeNode node,TreeNode father,int depth,int x,int y){
       if(node==null) return;
    if(node.val==x) {
        xDepth=depth;
        xFather=  (father==null? null:father.val);
    }else if(node.val==y){
        yDepth=depth;
        yFather= (father==null? null:father.val);
    }
        preOrder(node.left,node,depth+1,x,y);
       preOrder(node.right,node,depth+1,x,y);
    }
}
