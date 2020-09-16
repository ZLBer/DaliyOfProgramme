package leetcode.leetcode500_999;

import java.util.Stack;

public class leet503 {
  static   public int[] nextGreaterElements(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    Integer []res=new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()&&stack.peek()<=nums[i]){
              stack.pop();
            }
          if(!stack.isEmpty()) res[i]=stack.peek();
           stack.push(nums[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()&&stack.peek()<=nums[i]){
                stack.pop();
            }
           if(res[i]!=null) continue;
            if(!stack.isEmpty()) res[i]=stack.peek();
            else  res[i]=-1;
        }
       int []ans=new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
           ans[i]=res[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        nextGreaterElements(new int[]{1,2,3,4,5,6,5,4,5,1,2,3});
    }
}
