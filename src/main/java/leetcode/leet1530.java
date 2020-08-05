package leetcode;

public class leet1530 {
    public int countPairs(TreeNode root, int distance) {
        count=0;
     dfs(root,distance);
     return count;
    }
    int count;

    int []dfs(TreeNode root,int distance){
     if(root==null) return new int[11];
    if(root.left==null&&root.right==null){
      int []res= new int[11];
      res[1]=1;
      return  res;
    }

   int []left=dfs(root.left,distance);
   int []right=dfs(root.right,distance);

        int []res=new int[11];

        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < right.length; j++) {
                 if(i+j<=distance){
                     count+=(left[i]*right[j]);
                 }

            }
        }
        for (int i = 0; i < res.length-1; i++) {
            res[i+1]=left[i]+right[i];
        }

        return res;
    }
}
