package leetcode;

/**
 * Created by libin on 2019/1/15.
 */
public class leet654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

           return construct(nums,0,nums.length-1);
    }
    //构造二叉树
    TreeNode construct(int []nums,int i,int j){
        int [] max=helper(nums,i,j);
        TreeNode node=new TreeNode(0);
        if(max[0]!=-1)
            node.val=max[1];
        else{
            node=null;
            return node;
        }
        System.out.println(max[0]);
        node.left=construct(nums,i,max[0]-1);
        node.right=construct(nums,max[0]+1,j);
        return node;
    }
    //求最大值和它的位置
  static   int [] helper(int []nums,int i,int j){
        if(j<i) return new int[]{-1,0};
        int max=-1;
        int index=-1;
        for(;i<=j;i++){
            if(nums[i]>max){
                 max=nums[i];
                 index=i;
            }
        }
        return new int []{index,max};
    }

}
