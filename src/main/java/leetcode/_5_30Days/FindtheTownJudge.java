package leetcode._5_30Days;

import leetcode.TreeNode;

public class FindtheTownJudge {
/*    public int findJudge(int N, int[][] trust) {
 int[]count=new int[N+1];
 boolean [] flag=new boolean[N+1];
        for (int[] ints : trust) {
            count[ints[1]]++;
            flag[ints[0]]=true;
        }
        for (int i = 1; i < count.length; i++) {
            if(count[i]==N-1&&flag[i]==false) return i;
        }
        return -1;
    }*/

    //考虑初出度入度
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }

    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    helper(root,p,q);
    return res;
    }

    boolean helper(TreeNode node,TreeNode p,TreeNode q){
        if(node==null) return false;
      boolean left=helper(node.left,p,q);
      boolean right=helper(node.right,p,q);

      if((left&&right)||(left||right)&&(node==p||node==q)) res=node;
      return left||right||(node==p||node==q);
    }
}
