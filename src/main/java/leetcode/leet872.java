package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2019/1/3.
 */
public class leet872 {
    List<Integer> l=new LinkedList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> l1=new LinkedList<>();
        inorder(root1);
        l1.addAll(l);
        l.clear();
        inorder(root2);
        System.out.println(l.size());
        System.out.println(l1.size());
        if(l1.size()!=l.size()) return false;
        for(int i=0;i<l.size();i++){
            System.out.println(l.get(0));
            System.out.println(l1.get(0));
            if(l1.get(i)!=l.get(i)) return false;
        }
        return true;
    }
    void inorder(TreeNode node){
        if(node==null) return;
        inorder(node.left);
        if(node.left==null&&node.right==null)
            l.add(node.val);
        inorder(node.right);
    }

   //深度优先遍历树，遍历的路径保存在栈里，每找到一个叶节点就返回该节点的数值，直至栈空
    //
//    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
//        Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
//        s1.push(root1); s2.push(root2);
//        while (!s1.empty() && !s2.empty())
//            if (dfs(s1) != dfs(s2)) return false;
//        return s1.empty() && s2.empty();
//    }
//
//    public int dfs(Stack<TreeNode> s) {
//        while (true) {
//            TreeNode node = s.pop();
//            if (node.right != null) s.push(node.right);
//            if (node.left != null) s.push(node.left);
//            if (node.left == null && node.right == null) return node.val;
//        }
//    }
}
