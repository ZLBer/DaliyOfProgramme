package leetcode.leetcode1000_1499;

import leetcode.TreeNode;

public class leet1457 {

    //mine
/*    public int pseudoPalindromicPaths (TreeNode root) {
        helper(new int[10],root);
        return res;
    }

    int res=0;

    void helper(int []count,TreeNode node){
        if(node==null) return;
        if(node.left==null&&node.right==null){
            count[node.val]++;
            if(check(count)) res++;
            count[node.val]--;
            return;
        }
        count[node.val]++;
        helper(count,node.left);
        helper(count,node.right);

        count[node.val]--;
    }
    boolean check(int []count){
        int odd=0;
        for (int i : count) {
            if(i%2!=0) odd++;
        }
        if(odd<=1) return true;
        else return false;
    }*/

  //绝了  只用一个数字进行位运算
    public int pseudoPalindromicPaths (leetcode.TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int count) {
        if (root == null) return 0;
        count ^= 1 << (root.val - 1);  //异或此位置
        int res = dfs(root.left, count) + dfs(root.right, count);

       //先判断是叶子节点  然后判断数字中只有一个1
        if (root.left == root.right && (count & (count - 1)) == 0) res++;
        return res;
    }
}
