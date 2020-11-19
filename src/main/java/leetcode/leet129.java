package leetcode;

public class leet129 {

   /* int res=0;
    public int sumNumbers(TreeNode root) {
      if(root==null) return 0;
     heler(root,new ArrayList<>());
     return res;
    }

    void heler(TreeNode node, List<Integer> list){
        if(node.left==null&&node.right==null){
            int num=0;
           list.add(node.val);
            for (Integer integer : list) {
                num *= 10;
                num += integer;
            }
           res+=num;
            list.remove(list.size()-1);
           return;
      }

      if(node.left!=null){
         list.add(node.val);
         heler(node.left,list);
         list.remove(list.size()-1);
      }

      if(node.right!=null){
          list.add(node.val);
          heler(node.right,list);
          list.remove(list.size()-1);
      }
    }*/

    public int sumNumbers(TreeNode root) {
    return helper(root,0);
    }

    int helper(TreeNode node,int presum){
      if(node==null) return 0;
     int temp=presum*10+node.val;
     if(node.left==null&&node.right==null)
         return temp;
    return helper(node.left,temp)+helper(node.right,temp);
    }
}
