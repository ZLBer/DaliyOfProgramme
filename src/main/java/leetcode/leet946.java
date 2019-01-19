package leetcode;

import java.util.Stack;

/**
 * Created by libin on 2019/1/19.
 */
public class leet946 {

   //myself 双指针   17ms
/*    public boolean validateStackSequences(int[] pushed, int[] popped) {
      int pushPoint=0,popPoint=0;
        Stack<Integer> stack=new Stack<>();
        while (pushPoint<pushed.length){
            //值不相同
          if(pushed[pushPoint]!=popped[popPoint]){
              //判断是否和栈顶元素相同
              if(stack.size()>0&&stack.peek()==popped[popPoint]){
                  stack.pop();
                  popPoint++;
              }
              //不相同则入栈
            else   stack.add(pushed[pushPoint++]);
          }
          //值相同 ，两个指针均自增
          else if((pushed[pushPoint]==popped[popPoint])){
              popPoint++;
              pushPoint++;
          }
      }
      //最后看栈里的元素和pop剩下的元素是否相同
           while (stack.size()>0){
            if(stack.pop()==popped[popPoint++])   continue;
            else return false;
           }
      return true;
    }*/


    //模拟入栈，将pushed依次入栈，当pop和栈顶元素相同时，开始出栈，直至不能出栈   很优雅的方法  15ms
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        for (int x : pushed) {
            s.push(x);
            while (!s.empty() && s.peek() == popped[i]) {
                s.pop();
                i++;
            }
        }
        return i == popped.length;
    }
}
