package leetcode.leetcode1000_;

import leetcode.TreeNode;

import java.nio.ByteBuffer;

public class leet1379 {
    public final leetcode.TreeNode getTargetCopy(final leetcode.TreeNode original, final leetcode.TreeNode cloned, final leetcode.TreeNode target) {
        if(original==null) return null;
        if(original==target){
            return cloned;
        }
        leetcode.TreeNode left=getTargetCopy(original.left,cloned.left,target);

        if(left!=null) return left;
        TreeNode right=getTargetCopy(original.right,cloned.right,target);
        if(right!=null) return right;
        return null;
    }

    public static void main(String[] args) {
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(1024);



    }

}
