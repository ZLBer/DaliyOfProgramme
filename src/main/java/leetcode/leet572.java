package leetcode;

/**
 * Created by libin on 2019/1/10.
 */
public class leet572 {
    //自己写的第一版  21ms  双递归
    boolean flag=false;
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//        inorder(s,t);
//        return flag;
//    }
//     void  inorder(TreeNode s,TreeNode t){
//        if(s==null) return;
//        inorder(s.left,t);
//        inorder(s.right,t);
//        if(search(s,t)) flag=true;
//
//    }
//    boolean search(TreeNode s,TreeNode t){
//         if(s==null&&t==null) return true;
//         if(s==null||t==null) return false;
//         return s.val==t.val&&search(s.left,t.left)&& search(s.right,t.right);
//
//    }
    // 优化剪枝 19ms
public boolean isSubtree(TreeNode s, TreeNode t) {
    inorder(s,t);
    return flag;
}
    void  inorder(TreeNode s,TreeNode t){
        if(s==null) return;
        if(flag==false)
              inorder(s.left,t);
        if(flag==false)
              inorder(s.right,t);
        if(search(s,t)) flag=true;

    }
    boolean search(TreeNode s,TreeNode t){
        if(s==null&&t==null) return true;
        if(s==null||t==null) return false;
        return s.val==t.val&&search(s.left,t.left)&& search(s.right,t.right);

    }


}
