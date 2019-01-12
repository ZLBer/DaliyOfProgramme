package leetcode;

/**
 * Created by libin on 2019/1/12.
 */
public class leet563 {
    //理解有误
//    public int findTilt(TreeNode root) {
//          if(root==null) return 0;
//          int sum=0;
//          if(root.left!=null&&root.right!=null) {
//              sum+=Math.abs(root.left.val-root.right.val);
//          sum+=findTilt(root.left)+findTilt(root.right);
//          }
//          if(root.left==null&&root.right==null)  return 0;
//          if(root.left==null) sum+=Math.abs(root.right.val);
//          if(root.right==null) sum+=Math.abs(root.left.val);
//          return sum;
//    }


    int tilt=0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }
    public int traverse(TreeNode root)
    {
        if(root==null )
            return 0;
        int left=traverse(root.left);
        int right=traverse(root.right);
        //计算该点的倾斜值
        tilt+=Math.abs(left-right);
        //返回该子树的和
        return left+right+root.val;
    }
}
