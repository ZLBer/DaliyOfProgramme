package leetcode.leetcode1000_1499;

import leetcode.TreeNode;

import java.util.*;

public class leet1161 {
    //mine 两层队列
   static public int maxLevelSum(TreeNode root) {

        Queue<Queue> level =new LinkedList<>();
        Queue<TreeNode> q =new LinkedList<>();
        q.add(root);
         level.add(q);
        int maxLevelSum=0;
        int res=0;
        int levelNum=0;
         while (!level.isEmpty()){
             levelNum++;
            int sum=0;
            Queue<TreeNode>  curLevel=level.poll();
            Queue<TreeNode> nextLevel=new LinkedList<>();
            while (!curLevel.isEmpty()){
            TreeNode cur=curLevel.poll();
             sum+=cur.val;
             if(cur.left!=null) nextLevel.add(cur.left);
             if(cur.right!=null)  nextLevel.add(cur.right);
            }
            if(nextLevel.size()>0)
                level.add(nextLevel);

            if(sum>maxLevelSum){
               maxLevelSum=sum;
               res=levelNum;
            }
         }
         return res;

    }



   //可以用个临时变量记录size的大小，表示该层节点的数目
/*    public int maxLevelSum(TreeNode root) {
        int level = 1, max = Integer.MIN_VALUE, maxLevel = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sum = 0;
            for (int sz = q.size(); sz > 0; --sz) {
                TreeNode n = q.poll();
                sum += n.val;
                if (n.left != null) { q.offer(n.left); }
                if (n.right != null) { q.offer(n.right); }
            }
            if (max < sum) {
                max = sum;
                maxLevel = level;
            }
            ++level;
        }
        return maxLevel;
    }*/



   //dfs
  /*  public int maxLevelSum(TreeNode root) {
        List<Integer> list=new ArrayList<>();
       dfs(list,1,root);
       *//*int maxNum=0;
       int max=0;
       for (int i = 0; i < list.size(); i++) {
             if(list.get(i)>max) {
                 maxNum=i;
                 max=list.get(i);
             }
        }
       return maxNum;*//*
        return 1 + IntStream.range(0, list.size()).reduce(0, (a, b) -> list.get(a) < list.get(b) ? b : a);
    }

   void dfs(List<Integer> list,int level,TreeNode node){
        if(node==null) return;
        if(list.size()>level){
            list.set(level,list.get(level)+node.val);
        }else {
            list.add(node.val);
        }

        dfs(list,level+1,node.left);
        dfs(list,level+1,node.right);
   }
*/

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(7);
        TreeNode t3=new TreeNode(0);
       // TreeNode t1=new TreeNode(0);
      //  TreeNode t1=new TreeNode(0);
        t1.left=t2;
        t1.right=t3;

    maxLevelSum(t1);
    }
}
