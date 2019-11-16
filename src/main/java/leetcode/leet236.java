package leetcode;

public class leet236 {
/*    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    parent.put(node.left, node);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    parent.put(node.right, node);
                    queue.offer(node.right);
                }
            }
        }
        Set<TreeNode> set = new HashSet<>();
        set.add(p);
        while (p != null) {
            p = parent.get(p);
            set.add(p);
        }
        while (q != null) {
            if (set.contains(q)) return q;
            q = parent.get(q);


        }
        return null;
    }*/



//递归方式666  不是那么好理解
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //表示找到了p或q或null
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
     //   return left == null ? right : right == null ? left : root;

        //都是空表示没找到p和q
        if(left == null && right == null) return null;
        //都不空 表示root就是最低的祖先
        if(left != null && right != null) return root;
        //返回左右不为null的那个
        return left == null ? right : left;
    }
}
