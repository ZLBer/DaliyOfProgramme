package leetcode.leetcode1000_;

import leetcode.TreeNode;

public class leet1145 {

    //mine  写这么多也没什么用 其实就是统计左节点，右节点，父节点的个数
 /*   public boolean btreeGameWinningMove(TreeNode root, int n, int x) {

        Queue<TreeNode> queue=new LinkedList<>();
queue.add(root);
TreeNode xTree=new TreeNode(0);
//找到x
while (!queue.isEmpty()){
   TreeNode node= queue.poll();
  if (node.val==x){
      xTree=node;
      break;
  }
   if(node.left!=null) queue.offer(node.left);
   if(node.right!=null) queue.offer(node.right);
}

queue=new LinkedList<>();
queue.add(xTree);
int Pcount=0;
int Lcount=0;
int Rcount=0;
      // 拦截父节点
        while (!queue.isEmpty()){
            TreeNode node= queue.poll();
            Pcount++;
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        System.out.println(Pcount);


        if((n-Pcount)-Pcount>0) return true;

        //拦截左孩子
        if(xTree.left!=null){
            queue=new LinkedList<>();
            queue.add(xTree.left);
            while (!queue.isEmpty()){
                TreeNode node= queue.poll();
                Lcount++;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }

        if(Lcount-(n-Lcount)>0) return true;


        //拦截右孩子
        if(xTree.right!=null){
            queue=new LinkedList<>();
            queue.add(xTree.right);
            while (!queue.isEmpty()){
                TreeNode node= queue.poll();
                Rcount++;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        if(Rcount-(n-Rcount)>0) return true;
        return false;
    }*/


    //多么简介

    int left, right, val;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        val = x;
        count(root);
        return Math.max(Math.max(left, right), n - left - right - 1) > n / 2;
    }

    private int count(TreeNode node) {
        if (node == null) return 0;
        int l = count(node.left), r = count(node.right);
        //找到x节点
        if (node.val == val) {
            left = l;
            right = r;
        }
        return l + r + 1;
    }
}
