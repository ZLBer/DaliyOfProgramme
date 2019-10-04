package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet919 {
    //mine
/*    class CBTInserter {
       TreeNode head;
       int count=0;
        void count(TreeNode node){
            if(node==null)
                return;
            count++;
            count(node.left);
            count(node.right);
        }
        public CBTInserter(TreeNode root) {
       head=root;
       count(root);
        }

        public int insert(int v) {
         int deep=0;
         while (Math.pow(2,deep)-1<=count){
             deep++;
         }
         help(head,v,deep-1);
         count++;
         return parent;
        }

        public TreeNode get_root() {
               return head;
        }
        int parent=0;
        private boolean help(TreeNode node,int v,int deep){
            if(deep==1) {
                if(node.left==null) {
                    node.left=new TreeNode(v);
                    parent=node.val;
                    return true;
                }
                else if(node.right==null){
                    node.right=new TreeNode(v);
                    parent=node.val;
                    return true;
                }
            }
            else {
                if(help(node.left,v,deep-1))
                return true;
                if(help(node.right,v,deep-1))
                    return true;
            }
            return false;
        }
    }*/


    //怎么就忘了层序遍历呢
    class CBTInserter {
   List<TreeNode> list;
        public CBTInserter(TreeNode root) {
     list=new ArrayList<>();
     list.add(root);
     for(int i=0;i<list.size();i++){
         TreeNode temp=list.get(i);
         if(temp.left!=null) list.add(temp.left);
         if(temp.right!=null) list.add(temp.right);
     }
        }

        public int insert(int v) {
   int N=list.size();
   TreeNode node=new TreeNode(v);
   list.add(node);
   if(N%2==1)
       list.get((N-1)/2).left=node;
   else
       list.get((N-1)/2).right=node;

   return list.get((N - 1) / 2).val;
        }

        public TreeNode get_root() {
        return list.get(0);
        }
    }





    //用队列做 还是层序遍历的思想
   /* class CBTInserter {
        private TreeNode root;
        private Queue<TreeNode> q = new LinkedList<>();

        public CBTInserter(TreeNode root) {
            this.root = root;
            q.offer(root);
            while (q.peek().left != null && q.peek().right != null) {
                q.offer(q.peek().left);
                q.offer(q.poll().right);
            }
        }

        public int insert(int v) {
            TreeNode p = q.peek();
            if (p.left == null) {
                p.left = new TreeNode(v);
            }else {
                p.right = new TreeNode(v);
                q.offer(p.left);
                q.offer(p.right);
                q.poll();
            }
            return p.val;
        }

        public TreeNode get_root() { return root; }
    }*/



}
