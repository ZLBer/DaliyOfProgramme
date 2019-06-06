package leetcode;

import java.util.*;

/**
 * Created by libin on 2019/1/16.
 */
public class leet894$ {
   // 不简单的递归 ,真的漂亮
 /*   public List<TreeNode> allPossibleFBT(int N) {
    List<TreeNode> result=new ArrayList<>();
     if(N==1) {
    result.add(new TreeNode(0));
    }
     // 把这个节点当作根节点拿出来
    N-=1;
     for(int i=1;i<N;i+=2){
         List<TreeNode> left= allPossibleFBT(i);
         List<TreeNode> right=allPossibleFBT(N-i);
         for(TreeNode l:left){
             for(TreeNode r:right){
                 //根节点
     TreeNode treeNode=new TreeNode(0);
           treeNode.left=l;
           treeNode.right=r;
           result.add(treeNode);
             }
         }
     }
     return  result;
    }*/
    //加个缓存的递归
    //但是很多公用一个节点
    Map<Integer,List<TreeNode>> cache= new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result=new ArrayList<>();

        if(cache.containsKey(N)){
            return cache.get(N);
        }
        if(N==1) {
            result.add(new TreeNode(0));
            return result;
        }
        // 把这个节点当作根节点拿出来
        N-=1;
        for(int i=1;i<N;i+=2){
            List<TreeNode> left= allPossibleFBT(i);
            List<TreeNode> right=allPossibleFBT(N-i);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    //根节点
                    TreeNode treeNode=new TreeNode(0);
                    treeNode.left=l;
                    treeNode.right=r;
                    result.add(treeNode);
                }
            }
        }
        cache.put(N,result);
        return  result;
    }
}
