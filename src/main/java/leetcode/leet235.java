package leetcode;

/**
 * Created by libin on 2019/1/12.
 */
public class leet235 {
    //递归法   大体的思想就是 pq均小于root则遍历左子树，均大于root则遍历右子树，否则一个大一个小则说明该节点为公共最低节点
  /*  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
           int pval=p.val;
           int qval=q.val;
           if(p.val<root.val&&q.val<root.val){
              return lowestCommonAncestor(root.left,p,q);
           }
           else if(p.val>root.val&&q.val>root.val){
               return lowestCommonAncestor(root.right,p,q);
           }
           else  return root;
    }*/


  //遍历法
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      // Value of p
      int pVal = p.val;
      // Value of q;
      int qVal = q.val;
      // Start from the root node of the tree
      TreeNode node = root;
      // Traverse the tree
      while (node != null) {
          // Value of ancestor/parent node.
          int parentVal = node.val;
          if (pVal > parentVal && qVal > parentVal) {
              // If both p and q are greater than parent
              node = node.right;
          } else if (pVal < parentVal && qVal < parentVal) {
              // If both p and q are lesser than parent
              node = node.left;
          } else {
              // We have found the split point, i.e. the LCA node.
              return node;
          }
      }
      return null;
  }
}
