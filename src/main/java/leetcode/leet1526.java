package leetcode;

public class leet1526 {


    //mine
    public int minNumberOperations(int[] target) {
        int start=target[0];

        int res=target[0];
        for (int i = 1; i < target.length; i++) {
          if(target[i]>target[i-1]){
              res+=target[i]-target[i-1];
          }
        }
        return res;
    }

    //单调栈
 /*   public int minNumberOperations(int[] target) {
         Stack<Integer> stack=new Stack<>();
        int ans=0;
         for (int i = 0; i < target.length; i++) {
          if (!stack.isEmpty()&&stack.peek()>=target[i]){
          ans+=(stack.pop()-target[i]);
          }
             stack.push(target[i]);
        }
         ans+=stack.pop();
         return ans;
    }*/
}
