package leetcode;

import java.nio.ByteBuffer;

public class leet1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original==null) return null;
        if(original==target){
            return cloned;
        }
        TreeNode left=getTargetCopy(original.left,cloned.left,target);

        if(left!=null) return left;
        TreeNode right=getTargetCopy(original.right,cloned.right,target);
        if(right!=null) return right;
        return null;
    }

    public static void main(String[] args) {
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(1024);



    }

}
