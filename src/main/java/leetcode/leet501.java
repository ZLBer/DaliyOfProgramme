package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet501 {

    //mine 不考虑是不是二叉搜索树
/*    public int[] findMode(TreeNode root) {

     dfs(root);
  int max=0;
        for (Integer value : map.values()) {
            max=Math.max(value,max);
        }

        List<Integer> temp=new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==max){
             temp.add(entry.getKey());
            }
        }   
      int []res=new int[temp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=temp.get(i);
        }
       return res;
    }
   Map<Integer,Integer> map=new HashMap<>();
    void dfs(TreeNode  node){
       if(node==null) return;
       map.put(node.val,map.getOrDefault(node.val,0)+1);
     dfs(node.left);
     dfs(node.right);
    }*/

  //mine 不用额外空间  两次dfs
/*  public int[] findMode(TreeNode root) {
      pre=-1;
  dfs(root);
      System.out.println(max);
      pre=-1;
      count=0;
  dfs2(root);
      int []res=new int[list.size()];
      for (int i = 0; i < res.length; i++) {
          res[i]=list.get(i);
      }
      return res;
  }

      int max=0;
      int pre=-1;
      int count=0;
      void dfs(TreeNode  node){
      if(node==null) return;

      dfs(node.left);

      if(node.val==pre){
        count++;

      }else {

         pre=node.val;
         count=1;
      }
          max=Math.max(max,count);
    dfs(node.right);
  }
  List<Integer> list=new ArrayList<>();
    void dfs2(TreeNode  node){
        if(node==null) return;

        dfs2(node.left);

        if(node.val==pre){
            count++;
        }else {

            pre=node.val;
            count=1;
        }
        if(max==count) list.add(pre);
        dfs2(node.right);
    }*/



    //只遍历一次也是可以的
    List<Integer> mList = new ArrayList<>();
    int curent = 0;//表示当前节点的值
    int count = 0;//表示当前节点的数量
    int maxCount = 0;//最大的重复数量

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int[] res = new int[mList.size()];
        //把集合list转化为数组
        for (int i = 0; i < mList.size(); i++) {
            res[i] = mList.get(i);
        }
        return res;
    }

    //递归方式
    public void inOrderTraversal(TreeNode node) {
        //终止条件判断
        if (node == null)
            return;
        //遍历左子树
        inOrderTraversal(node.left);

        //下面是对当前节点的一些逻辑操作
        int nodeValue = node.val;
        if (nodeValue == curent) {
            //如果节点值等于curent，count就加1
            count++;
        } else {
            //否则，就表示遇到了一个新的值，curent和count都要
            //重新赋值
            curent = nodeValue;
            count = 1;
        }
        if (count == maxCount) {
            //如果count == maxCount，就把当前节点加入到集合中
            mList.add(nodeValue);
        } else if (count > maxCount) {
            //否则，当前节点的值重复量是最多的，直接把list清空，然后
            //把当前节点的值加入到集合中
            mList=new ArrayList<>();
            mList.add(nodeValue);
            maxCount = count;
        }

        //遍历右子树
        inOrderTraversal(node.right);
    }



}
