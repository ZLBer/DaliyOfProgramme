package leetcode.leetcode500_999;

import jdk.internal.dynalink.linker.LinkerServices;
import org.assertj.core.internal.Integers;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by libin on 2019/1/18.
 */
public class leet682 {
    //链表做
/* static    public int calPoints(String[] ops) {
        LinkedList<Integer> linkedList=new LinkedList<>();
        for(String a:ops){
            switch (a){
                case "C": {
                    linkedList.remove(linkedList.size()-1);break;
                }
                case "D":{
                    linkedList.add(linkedList.get(linkedList.size()-1)*2);break;
                }
                case  "+":{
                    linkedList.add(linkedList.get(linkedList.size()-1)+linkedList.get(linkedList.size()-2));break;
                }
                default: linkedList.add(Integer.parseInt(a));
            }
        }

        int sum=0;
        for(int l:linkedList){
            sum+=l;
        }
        return sum;
}*/


//用栈做
   static public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();

        for(String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int ans = 0;
        for(int score : stack) ans += score;
        return ans;
    }
    public static void main(String[] args) {
        calPoints(new String[]{"5","2","C","D","+"});
    }
}
