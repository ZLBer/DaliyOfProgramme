package leetcode;

public class leet1367 {
    //mine 错误的代码  断开连接之后也会认为是对的

/*    public boolean isSubPath(ListNode head, TreeNode root) {
    if(head==null) return true;
    if(root==null) return false;

    if(head.val==root.val){
      return  isSubPath(head.next,root.left)||isSubPath(head.next,root.right);
    }

    return isSubPath(head,root.left)||isSubPath(head,root.right);


    }*/

    //需要改成这样  到每一个点都dfs
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null) return true;
        if(root==null) return false;
        return dfs(head,root)||isSubPath(head,root.left)||isSubPath(head,root.right);
    }

    boolean dfs(ListNode head, TreeNode root){
        if(head==null) return true;
        if(root==null) return false;
        return  head.val==root.val&&(dfs(head.next,root.left)||dfs(head.next,root.right));
    }
}
