package leetcode.leetcode500_999;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet863$ {
 /*   public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result=new ArrayList<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root.left);
        int targetDeep=-1;
        int deep=0;
        while (queue!=null){
         int size=queue.size();
         deep++;
         map.put(deep,new ArrayList<>());
         while (size-->0){
             TreeNode node=queue.poll();
             map.get(deep).add(node.val);
             if(node.val==target.val) targetDeep=deep;
             if(node.left!=null) queue.add(node.left);
             if(node.right!=null) queue.add(node.right);
         }

         if(targetDeep!=-1&&deep==targetDeep+K) break;
        }

        result.addAll(map.get(targetDeep+K));
       int top= targetDeep-K>0?targetDeep-K:Math.abs(targetDeep-K)+1;
       if(top==targetDeep){
         int index=0;
         List<Integer> list=map.get(top);
           while (list.get(index)!=target.val){
               index++;
           }
           index++;
           while (index<list.size()){
               result.add(list.get(index));
           }
       }else {
           result.addAll(map.get(top));
       }
        return result;
    }*/




 public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
     helper(root,target);
     DFS(root,K,map.get(root));
     return res;
    }
    //只给父节点赋值
Map<TreeNode,Integer> map=new HashMap<>();
   int helper(TreeNode node,TreeNode taget){
        if(node==null) return -1;
        if(node.val==taget.val){
            map.put(node,0);
            return 0;
        }
        int left=helper(node.left,taget);
        if(left>=0){
            map.put(node,left+1);
            return left+1;
        }
        int righr=helper(node.right,taget);
        if(righr>=0){
            map.put(node,righr+1);
            return righr+1;
        }

        return -1;
   }

 List<Integer> res=new ArrayList<>();
  void DFS(TreeNode node,int K,int length){
   if(node==null) return;
   if(map.containsKey(node)) length=map.get(node);
   if(length==K)  res.add(node.val);
   DFS(node.left,K,length+1);
   DFS(node.right,K,length+1);
   }



   //构造无向图
/*   public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

       grath.put(root,new ArrayList<>());
 helper(root.left,root);
 helper(root.right,root);
       Queue<TreeNode> queue=new LinkedList<>();
       queue.offer(target);
       Set<TreeNode> visited=new HashSet<>();
       visited.add(target);
       int k=0;
       if(k==K) return Arrays.asList(target.val);
       while (!queue.isEmpty()){
           int size=queue.size();
           k++;
           while (size-->0){
               TreeNode node=queue.poll();
               visited.add(node);
               for(TreeNode next:grath.get(node)){
                   if(!visited.contains(next)){
                       queue.offer(next);
                   }
               }
           }
           if(k==K){

             return queue.stream().map((a)->a.val).collect(Collectors.toList());
           }
       }
       return  Collections.emptyList();
   }

   Map<TreeNode,List<TreeNode>> grath=new HashMap<>();
   void  helper(TreeNode node,TreeNode parent){
       if(node==null) return;
       grath.put(node,new ArrayList<>());
       helper(node.left,node);
       helper(node.right,node);
       grath.get(node).add(parent);
       grath.get(parent).add(node);

   }*/
}
