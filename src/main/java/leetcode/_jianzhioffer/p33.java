package leetcode._jianzhioffer;

public class p33 {
    //递归
    public boolean verifyPostorder(int[] postorder) {
  return helper(postorder,0,postorder.length-1);
    }
   boolean helper(int[]postorder,int i,int j){
       if(i==j) return true;
      int root=postorder[j];
     int p=i;
    while (postorder[p]<root)p++;
   int end=p-1;
   while (postorder[p]>root)p++;
   return   p==j&&helper(postorder,i,end)&&helper(postorder,end+1,j-1);
   }

  //单调栈
/*
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i]) //为了寻找i的根节点
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }
*/

}
