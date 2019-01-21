package leetcode;

import java.util.Stack;

/**
 * Created by libin on 2019/1/21.
 */
public class leet739 {

    //最直接的方法  O(n2)    310ms
   /* public int[] dailyTemperatures(int[] T) {
           int result[]=new int[T.length];
           for(int i=0;i<T.length;i++){
               for(int j=i+1;j<T.length;j++)
                   if(T[j]>T[i])  {
                   result[i]=j-i;
                  break;
                   }
           }
           return result;
     }*/

   //用栈   75
/*    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            //当满足条件时，将栈顶元素出栈，直至条件不符合
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            //依次入栈
            stack.push(i);
        }
        return ret;
    }*/
   //用数组来模拟栈  13ms  比栈快很多
    public int[] dailyTemperatures(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        int top = -1;
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int idx = stack[top--];
                ret[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return ret;
    }
}
