package leetcode;

public class leet450 {

    //mine 二叉搜索树删除节点
 public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode stupid=new TreeNode(0);
        stupid.left=root;
        dfs(root,key,stupid,true);
        return stupid.left;
    }

    boolean dfs(TreeNode node,int key,TreeNode parent,boolean isLeft){
        if(node==null) return false;
        if(node.val==key){
           //如果是叶子节点
            if(node.left==null&&node.right==null){
                if(isLeft) parent.left=null;
                else parent.right=null;
                //有一个节点为空
            }else if(node.left!=null&&node.right==null){
                if(isLeft) parent.left=node.left;
                else parent.right=node.left;
            }else if(node.right!=null&&node.left==null){
                if(isLeft) parent.left=node.right;
                else parent.right=node.right;
            }
            //所有节点都不为空，需要找中序遍历的第一个子女来填补
            else {
                TreeNode stupid=new TreeNode(0);
                stupid.left=node.right;
               TreeNode insert=helper(stupid.left,stupid);
                insert.left=node.left;
                insert.right=stupid.left;
               if(isLeft) parent.left=insert;
               else parent.right=insert;
            }
        }

        //后期优化
        if(key>node.val){
            return dfs(node.right,key,node,false);
        }else {
            return dfs(node.left,key,node,true);
        }

    }


    //找到并删除右子树最左节点
    TreeNode helper(TreeNode node,TreeNode parent){
    if(node.left==null){
        parent.left=node.right;
        return node;
    }
    return    helper(node.left,node);
    }



 //别人的  本质是一样的  算法略有不同

    //寻找二叉搜索树最小节点  就是一直向左寻找
   /* private TreeNode minNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    *//**
     * 删除一个二分搜索树中最小的节点，把新的二分搜索树的根返回回去
     * 使用递归，要特别注意，定义的递归函数，返回的是，删除了最小值节点以后的新的二分搜索树的根
     *//*
    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            // 就是那个我们要删除的节点
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        //去右边寻找
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
            //左边寻找
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;

            //已经找到节点
        } else {
            // 如果待删除的节点左孩子为空
            if (root.left == null) {
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            }
            // 如果待删除的节点只有右孩子
            if (root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            }
            // 从它的右子树中拿到最小的
            TreeNode successor = new TreeNode(minNode(root.right).val);
            //左子树不动
            successor.left = root.left;
            //右子树需要删除最小的那一个
            successor.right = removeMin(root.right);
            //断开链接
            root.left = null;
            root.right = null;
            return successor;
        }
    }
*/


  /* //用遍历来做
    private TreeNode deleteRootNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode next = root.right;
        TreeNode pre = null;
        //寻找后继节点
        for(; next.left != null; pre = next, next = next.left);
        next.left = root.left;
        if(root.right != next) {
            pre.left = next.right;
            next.right = root.right;
        }
        return next;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null && cur.val != key) {
            pre = cur;
            if (key < cur.val) {
                cur = cur.left;
            } else if (key > cur.val) {
                cur = cur.right;
            }
        }
        if (pre == null) {
            return deleteRootNode(cur);
        }
        if (pre.left == cur) {
            pre.left = deleteRootNode(cur);
        } else {
            pre.right = deleteRootNode(cur);
        }
        return root;
    }*/
}
