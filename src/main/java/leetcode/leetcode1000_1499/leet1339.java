package leetcode.leetcode1000_1499;

import leetcode.TreeNode;

public class leet1339 {

    //mine TLE  太多重复计算了
/*    public int maxProduct(TreeNode root) {
    long sum=helper(root);
     DFS(root,sum);
     return (int)(result%1000000007);
    }
    long result=0;
    void DFS(TreeNode node,long sum){
        if(node==null) return;
    long tSum=helper(node);
   result= Math.maxSum(result,(sum-tSum)*tSum);
   DFS(node.left,sum);
   DFS(node.right,sum);
    }


    long helper(TreeNode root){
        if(root==null) return 0;
        return root.val+helper(root.left)+helper(root.right);
    }*/


    //一样的东西为什么这个可以通过？
    //其实并不一样 人家的只需要便利一次  而你得n*n

    long res = 0, total = 0, sub;
    public int maxProduct(leetcode.TreeNode root) {
        total = s(root); s(root);
        return (int)(res % (int)(1e9 + 7));
    }

    private long s(TreeNode root) {
        if (root == null) return 0;
        sub = root.val + s(root.left) + s(root.right);
        res = Math.max(res, sub * (total - sub));
        return sub;
    }

//和上面一样  只是分成了两个
 /*   static long sum;
    static long maxProd;
    public static void dfs(TreeNode root) {
        if(root == null) return;
        sum += (long)root.val;
        dfs(root.left);
        dfs(root.right);
    }
    public static long checkMax(TreeNode root) {
        if(root == null) return 0;
        long l = checkMax(root.left);
        long r = checkMax(root.right);
        maxProd = Math.maxSum(maxProd, (l + r + root.val) * (sum - l - r - root.val));
        return l + r + root.val;
    }
    public int maxProduct(TreeNode root) {
        sum = 0;
        maxProd = 0;
        dfs(root);
        long rootProd = checkMax(root);
        return (int)(maxProd % ((int)Math.pow(10, 9) + 7));
    }*/
}
