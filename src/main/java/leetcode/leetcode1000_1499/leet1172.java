package leetcode.leetcode1000_1499;

import java.util.*;

public class leet1172 {
   /* class DinnerPlates {
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

    }*/



   //前后各一个指针
 /*   class DinnerPlates {
   int cur=0;
   int last=0;
   Map<Integer,Stack> map=new HashMap<>();
   int capacity;
        public DinnerPlates(int capacity) {
            this.capacity=capacity;
            map.put(cur, new Stack<>());
        }

        public void push(int val) {
          while (map.containsKey(cur)&&map.get(cur).size()==capacity)
              cur++;
          if(!map.containsKey(cur)){
              map.put(cur,new Stack());
          }
          last=Math.max(cur,last);
          map.get(cur).push(val);
        }

        public int pop() {
            while (map.get(last).size()==0&&last>=0)
                last--;
            if(last==-1)  return -1;
            cur=Math.min(cur,last);
            return (int )map.get(last).pop();
        }

        public int popAtStack(int index) {
            if(!map.containsKey(index)||map.get(index).size()==0)
                return -1;
            //及时更新cur
            cur=Math.min(cur,index);
            return (int)map.get(index).pop();

        }
    }*/
 //加了count作用不大
/*   class DinnerPlates {
       int cur=0;
       int last=0;
       int count=0;
       Map<Integer,Stack> map=new HashMap<>();
       int capacity;
       public DinnerPlates(int capacity) {
           this.capacity=capacity;
           map.put(cur, new Stack<>());
       }

       public void push(int val) {
           while (map.containsKey(cur)&&map.get(cur).size()==capacity)
               cur++;
           if(!map.containsKey(cur)){
               map.put(cur,new Stack());
           }
           last=Math.max(cur,last);
           map.get(cur).push(val);
           count++;
       }

       public int pop() {
           if(count==0) return -1;
           while (map.get(last).size()==0&&last>=0)
               last--;
           if(last==-1)  return -1;
           cur=Math.min(cur,last);
           count--;
           return (int )map.get(last).pop();
       }

       public int popAtStack(int index) {
           if(!map.containsKey(index)||map.get(index).size()==0)
               return -1;
           //及时更新cur
           cur=Math.min(cur,index);
           count--;
           return (int)map.get(index).pop();

       }
   }*/


//用list 和 Treeset
    class DinnerPlates {

        List<Stack<Integer>> stacks;
        TreeSet<Integer> openStacks;
        int capacity;

        public DinnerPlates(int capacity) {
            this.stacks = new ArrayList();
            this.openStacks = new TreeSet();
            this.capacity = capacity;
        }

        public void push(int val) {
            if (openStacks.isEmpty()) {
                stacks.add(new Stack());
                openStacks.add(stacks.size() - 1);
            }

            stacks.get(openStacks.first()).push(val);
            if (stacks.get(openStacks.first()).size() == capacity)
                openStacks.pollFirst();
        }

        public int pop() {
            return myPop(stacks.size() - 1);
        }

        public int popAtStack(int index) {
            return myPop(index);
        }

        private int myPop(int i) {
            if (i < 0 || i >= stacks.size() || stacks.get(i).isEmpty())
                return -1;
            int ret = stacks.get(i).pop();
            openStacks.add(i);
            while (stacks.size() > 0 && stacks.get(stacks.size() - 1).isEmpty())
                stacks.remove((int) openStacks.pollLast()); // Cast is necessary!
            return ret;
        }
    }

    public static void main(String[] args) {

    }

}
