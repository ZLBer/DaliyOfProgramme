package leetcode;




/**
 * Created by libin on 2019/3/27.
 */
public class leet1022 {
    int sum;
    public int sumRootToLeaf(TreeNode root) {
DFS(root,new StringBuilder());
        return sum;
    }


    void DFS(TreeNode root,StringBuilder sb){
        if(root==null) return ;

        sb.append(root.val);
        if(root.left==null&&root.right==null) {
            System.out.println(sb.toString());
            sum += Integer.parseInt(sb.toString(),2);
            return;
        }

        DFS(root.left,new StringBuilder(sb));
        DFS(root.right,new StringBuilder(sb));

    }


  //大神的做法
    //1000000007 是最小的十位质数。模1000000007，可以保证值永远在int的范围内。
  /*  int mod = 1000000007;
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) return 0;
        val = (val * 2 + root.val) % mod;
        return (root.left == root.right ? val : dfs(root.left, val) + dfs(root.right, val)) % mod;
    }*/
}
