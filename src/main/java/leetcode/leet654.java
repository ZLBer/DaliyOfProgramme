package leetcode;

/**
 * Created by libin on 2019/1/15.
 */
public class leet654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

           return construct(nums,0,nums.length-1);
    }
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
        int max=0;
        int index=0;
        for(;i<=j;i++){
            if(nums[i]>max){
                 max=nums[i];
                 index=i;
            }
        }
        return new int []{index,max};
    }

    public static void main(String[] args) {
    for(int a:helper(new int[]{3,2,1,6,0,5},0,5)){
        System.out.println(a);
    }
    }
}
