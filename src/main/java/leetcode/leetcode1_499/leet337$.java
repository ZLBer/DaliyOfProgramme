package leetcode.leetcode1_499;

public class leet337$ {

    //总结一下这个题目：树形DFS选择，需要先从子节点向上汇总，不是以往的从原点开始

/*    public int rob(TreeNode root) {
       return DFS(root);

    }
    int DFS(TreeNode node){
 if(node==null) return 0;
 int val=0;
 //打劫此处
 if(node.left!=null){
     val+=DFS(node.left.left)+DFS(node.left.right);
 }
 if(node.right!=null){
     val+=DFS(node.right.left)+DFS(node.right.right);
 }
 //和不打劫此处作比较
 return Math.max(val+node.val,DFS(node.left)+DFS(node.right));
    }*/
/*public int rob(TreeNode root) {
    return DFS(root,new HashMap<>());
}

    int DFS(TreeNode node, Map<TreeNode,Integer> map){
    if(node==null) return 0;
    if(map.containsKey(node)) return map.get(node);
    int val=0;
        if(node.left!=null){
            val+=DFS(node.left.left,map)+DFS(node.left.right,map);
        }
        if(node.right!=null){
            val+=DFS(node.right.left,map)+DFS(node.right.right,map);
        }

       val=Math.max(val+node.val,DFS(node.left,map)+DFS(node.right,map));
        map.put(node,val);
        return val;
    }*/


    public int rob(TreeNode root) {
      int[] res=DFS(root);
      return Math.max(res[0],res[1]);
    }


    int[] DFS(TreeNode node){
        if(node==null) return new int[2];

        int[] left=DFS(node.left);
        int[] right=DFS(node.right);

        int[] here=new int[2];

        //抢劫这个点
        here[0]=left[1]+right[1]+node.val;
        //不抢劫
        here[1]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return here;

    }



/* //一种简洁明了的递归方式
    public int rob(TreeNode root) {
        if (root == null) return 0;
        return Math.max(robInclude(root), robExclude(root));
    }
//抢劫这个点 只能去调用robExclude
    public int robInclude(TreeNode node) {
        if(node == null) return 0;
        return robExclude(node.left) + robExclude(node.right) + node.val;
    }

    //不抢劫二这个点需要调用max函数
    public int robExclude(TreeNode node) {
        if(node == null) return 0;
        return rob(node.left) + rob(node.right);
    }*/

}
