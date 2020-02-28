package leetcode;

public class leet623 {

    //mine  层序遍历  一次过
/*
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
       int deep=0;
       Queue<TreeNode>  D_1=new LinkedList<>();
       Queue<TreeNode>  D=new LinkedList<>();
        while (deep<=d){
            deep++;
            int size=queue.size();
            while (size-->0){
               TreeNode node=queue.poll();
               if(deep==d-1&&node!=null){
                   D_1.offer(node);
               }else if(deep==d){
                   D.offer(node);
               }
               if(node==null) continue;
               queue.offer(node.left);
               queue.offer(node.right);
            }
        }
        queue.clear();
        while (!D_1.isEmpty()){
           TreeNode node=D_1.poll();
           TreeNode left=new TreeNode(v);
           TreeNode right=new TreeNode(v);
           node.left=left;node.right=right;
           queue.offer(left);
           queue.offer(right);
        }
        if(queue.isEmpty()) {
            TreeNode newRoot=new TreeNode(v);
            newRoot.left=root;
            return newRoot;

        }
        while (!queue.isEmpty()){
            TreeNode left=queue.poll();
            TreeNode right=queue.poll();
            TreeNode node=D.poll();
            if(node!=null) left.left=node;
            node=D.poll();
            if(node!=null) right.right=node;
        }
        return root;
    }
*/

    //dfs
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1||d==0){
           TreeNode node=new TreeNode(v);
           node.left=(d==1)?root:null;
           node.right=(d==0)?root:null;
           return node;
        }
        if(root!=null) {
            root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);
            root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
        }
        return root;
    }
}
