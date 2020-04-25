package leetcode.leetcode500_999;

import leetcode.TreeNode;

import java.util.*;

public class leet652 {
    //mine 最初的版本
    //加符号是为了去除相同数字的情况
  /*  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    DFS(root);
        return res;
    }
    Set<String> set=new HashSet<>();
    List<TreeNode> res =new ArrayList<>();
    Set<String> isAdd=new HashSet<>();
     void DFS(TreeNode node){
        if(node==null) return;
        DFS(node.left);
        DFS(node.right);
        StringBuilder sb=new StringBuilder();
        inOrder(node,sb,'#');
       preOrder(node,sb,'#');
     // System.out.println(sb.toString());
        if(set.contains(sb.toString())&&!isAdd.contains(sb.toString())){
        res.add(node);
        isAdd.add(sb.toString());
        }else {

            set.add(sb.toString());
        }
     }

    void inOrder(TreeNode node,StringBuilder sb,char c){
      if(node==null) return;
      inOrder(node.left,sb,'L');
      sb.append(c+node.val);
      inOrder(node.right,sb,'R');
    }
    void preOrder(TreeNode node,StringBuilder sb,char c){
      if(node==null) return;
      sb.append(c+node.val);
      preOrder(node.left,sb,'L');
      preOrder(node.right,sb,'R');
    }*/


  //mine 增加一个缓存 时间是之前的三分之一  但很容易写错
/*    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        DFS(root);
        return res;
    }
    Set<String> set=new HashSet<>();
    List<TreeNode> res =new ArrayList<>();
    Set<String> isAdd=new HashSet<>();
    //增加缓存
    Map<TreeNode,String> inOrderMap=new HashMap<>();
    Map<TreeNode,String> preOrderMap=new HashMap<>();

    void DFS(TreeNode node){
        if(node==null) return;
        DFS(node.left);
        DFS(node.right);
        StringBuilder inOrderSb=new StringBuilder();
        inOrder(node,inOrderSb,'#');
        //存的是不包含符号的根节点
        inOrderMap.put(node,inOrderSb.toString().substring(1));
        StringBuilder preOrderSb=new StringBuilder();
        preOrder(node,preOrderSb,'#');
        //存的是不包含符号的根节点
        preOrderMap.put(node,preOrderSb.toString().substring(1));
        String ans=inOrderSb.toString()+preOrderSb.toString();
       // System.out.println(ans);
        if(set.contains(ans)&&!isAdd.contains(ans)){
            res.add(node);
            isAdd.add(ans);
        }else {
            set.add(ans);
        }
    }

    void inOrder(TreeNode node,StringBuilder sb,char c){
        if(node==null) return;
        if(inOrderMap.containsKey(node)) {
            sb.append(c).append(inOrderMap.get(node));
            return;
        }
        inOrder(node.left,sb,'L');
        sb.append(c).append(node.val);
        inOrder(node.right,sb,'R');
    }
    void preOrder(TreeNode node,StringBuilder sb,char c){
        if(node==null) return;
        if (preOrderMap.containsKey(node)) {
            sb.append(c).append(preOrderMap.get(node));
            return;
        }
        sb.append(c).append(node.val);
        preOrder(node.left,sb,'L');
        preOrder(node.right,sb,'R');
    }*/


    //别人的   很关键的一点是 根节点返回#,这样就不会存在相同导致树不一致的情况  13ms
  /*  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";
        String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
        if (map.getOrDefault(serial, 0) == 1) res.add(cur);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }*/

  //进一步把自己的优化一下  改成只需要一种遍历
    //之前想到的是 前中或者后中会唯一决定一棵树
    //又快了  从90ms->28ms->17ms
  public List<leetcode.TreeNode> findDuplicateSubtrees(leetcode.TreeNode root) {
      DFS(root);
      return res;
  }
    Set<String> set=new HashSet<>();
    List<leetcode.TreeNode> res =new ArrayList<>();
    Set<String> isAdd=new HashSet<>();
    //增加缓存
    Map<leetcode.TreeNode,String> inOrderMap=new HashMap<>();
    Map<leetcode.TreeNode,String> preOrderMap=new HashMap<>();

    void DFS(leetcode.TreeNode node){
        if(node==null) return;
        DFS(node.left);
        DFS(node.right);
        StringBuilder inOrderSb=new StringBuilder();
        inOrder(node,inOrderSb,'#');
        //存的是不包含符号的根节点
        inOrderMap.put(node,inOrderSb.toString().substring(1));
        String ans=inOrderSb.toString();
        // System.out.println(ans);
        if(set.contains(ans)&&!isAdd.contains(ans)){
            res.add(node);
            isAdd.add(ans);
        }else {
            set.add(ans);
        }
    }

    void inOrder(TreeNode node, StringBuilder sb, char c){
        if(node==null) {
            sb.append('#');
            return ;
        }
        if(inOrderMap.containsKey(node)) {
            sb.append(c).append(inOrderMap.get(node));
            return;
        }
        inOrder(node.left,sb,'L');
        sb.append(c).append(node.val);
        inOrder(node.right,sb,'R');
    }
}
