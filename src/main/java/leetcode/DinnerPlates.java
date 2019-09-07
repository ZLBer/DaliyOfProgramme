package leetcode;

import java.util.ArrayList;
import java.util.Stack;

class DinnerPlates {
    int capacity=0;
    ArrayList<plateStack> stacks=new ArrayList<>();
    public DinnerPlates(int capacity) {
        this.capacity=capacity;
    }

    public void push(int val) {
        if(stacks.size()==0)
        {
            plateStack ps=new plateStack(capacity);
            ps.push(val);
            stacks.add(ps);
        }
        else {
            for(plateStack ps:stacks){
                if(ps.push(val))
                    return;
            }
            plateStack ps=new plateStack(capacity);
            ps.push(val);
            stacks.add(ps);

        }

    }

    public int pop() {
        for(int i=stacks.size()-1;i>=0;i--){
            plateStack ps =stacks.get(i);
            if(ps.count==0) {
                checkTailVoid();
                continue;
            }
            int result=  ps.pop();
            checkTailVoid();
            return result;
        }
        return -1;
    }

    public int popAtStack(int index) {
        if(index>=stacks.size())
            return -1;

        plateStack ps= stacks.get(index);
        if(ps.count==0) return -1;
        int result=ps.pop();
        if(index==stacks.size()-1)  checkTailVoid();
        return result;
    }

    private  void checkTailVoid(){
        if(stacks.get(stacks.size()-1).count==0) stacks.remove(stacks.size()-1);
    }

    class plateStack{
        public Stack<Integer> stack=new Stack<>();
        public int capacity=0;
        public int count=0;

        public plateStack(int capacity) {
            this.capacity = capacity;
        }

        public boolean push(int val){
            if(count>=capacity) return false;
            stack.push(val);
            count++;
            return true;
        }

        public int  pop(){
            int re= stack.pop();
            count--;
            return  re;
        }
    }

    public static void main(String[] args) {
        DinnerPlates dinnerPlates=new DinnerPlates(1);
        dinnerPlates.push(1);
        dinnerPlates.push(2);
        dinnerPlates.push(3);
        dinnerPlates.popAtStack(1);
        dinnerPlates.pop();
        dinnerPlates.pop();
    }

}