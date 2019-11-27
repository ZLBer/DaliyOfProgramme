package leetcode.leetcode1_499;

import leetcode.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class leet341 {

    //mine  就这么做完了？
  /*  public class NestedIterator implements Iterator<Integer> {

        List<Integer> list=new ArrayList<>();
        int index=0;
        public NestedIterator(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                helper(nestedInteger);
            }
            System.out.println(list.size());
        }

        void helper(NestedInteger nestedInteger){
            if(nestedInteger.getInteger()!=null){
               list.add(nestedInteger.getInteger());
            }else {
                for(NestedInteger nestedInteger1:nestedInteger.getList()){
                    helper(nestedInteger1);
                }
            }

        }

        @Override
        public Integer next() {
            return list.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index>=list.size();
        }
    }*/


    //可以用一个栈解决， 且延迟list化

    public class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> stack=new Stack<>();
        public NestedIterator(List<NestedInteger> nestedList) {
             for(int i=nestedList.size()-1;i>=0;i--){
                 stack.push(nestedList.get(i));
             }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()){
                NestedInteger nestedInteger=stack.peek();
                if(nestedInteger.getInteger()!=null)
                    return true;
                stack.pop();
                List<NestedInteger> list=nestedInteger.getList();
                for(int i=list.size()-1;i>=0;i--){
                    stack.push(list.get(i));
                }
            }
            return false;
        }
    }
}
