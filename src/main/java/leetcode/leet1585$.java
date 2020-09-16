package leetcode;

import java.util.Stack;

public class leet1585$ {
    public boolean isTransformable(String s, String t){

 Stack<Integer>[] stacks=new Stack[10];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i]=new Stack<>();
        }

        for (int i = 0; i < s.length(); i++) {
           stacks[s.charAt(i)-'0'].push(i);
        }
        for (int i = t.length()-1; i >= 0; i--) {
            int num=t.charAt(i)-'0';
           if(stacks[num].isEmpty()) return false;
           int index=stacks[num].pop();
           for(int j=num+1;j<=9;j++){
              if(!stacks[j].isEmpty()&&index<stacks[j].peek()){
                  return false;
              }
           }
        }

        return true;


    }


}
