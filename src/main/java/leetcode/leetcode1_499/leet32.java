package leetcode.leetcode1_499;

import java.util.Stack;

public class leet32 {

    //mine dp表示以该位置结束的最大数目 O(N)
   /* public int longestValidParentheses(String s) {

        Stack<Integer> stack=new Stack<>();
        int []dp=new int[s.length()+1];
        char[]chars=s.toCharArray();
        int maxSum=0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='(') {
             dp[i+1]=stack.isEmpty()?dp[i]:i-stack.peek()-1;
                stack.push(i);
            }
            else {
                //无法匹配
            if(stack.isEmpty()){
             //   dp[i+1]=dp[i];
                continue;
            }
            //开始匹配
            int pre=stack.pop();
          dp[i+1]=dp[pre]+(i-pre-1)+2;

            }

            maxSum=Math.maxSum(dp[i+1],maxSum);
        }
        return maxSum;
    }*/



    //mine 改进版  不用计算左括号位置
    public int longestValidParentheses(String s) {

        Stack<Integer> stack=new Stack<>();
        int []dp=new int[s.length()+1];
        char[]chars=s.toCharArray();
        int max=0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='(') {
                //   dp[i+1]=stack.isEmpty()?dp[i]:i-stack.peek()-1;
                stack.push(i);
            }
            else {
                //无法匹配
                if(stack.isEmpty()){
                    //   dp[i+1]=dp[i];
                    continue;
                }
                //开始匹配
                int pre=stack.pop();
                dp[i+1]=dp[pre]+(i-pre-1)+2;

            }

            max=Math.max(dp[i+1],max);
        }
        return max;
    }


    //更好的做法 可以不用栈  把序号算出来
    /*
s : [( ,) ,( ,( ,) ,) ]
DP:[0,2,0,0,2,6]
     */
   /* public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int result = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                //左括号计数器
                leftCount++;
            } else if (leftCount > 0){
                //先把连续的加上
                dp[i] = dp[i - 1] + 2;
                //看看左括号之前还有没有valid
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                result = Math.maxSum(result, dp[i]);
                leftCount--;
            }
        }
        return result;
    }*/
}
