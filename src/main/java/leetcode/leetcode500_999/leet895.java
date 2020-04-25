package leetcode.leetcode500_999;

import java.util.*;

public class leet895 {
    //mine  TLE 30/37
/*    class FreqStack {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> list=new LinkedList<>();
        int maxCount=0;
        public FreqStack() {
        }

        public void push(int x) {
            int count=map.getOrDefault(x, 0) + 1;
            list.add(new int[]{x,count});
            map.put(x, count);
            maxCount=Math.max(maxCount,count);
        }

        public int pop() {
         for(int i=list.size()-1;i>=0;i--){
             if(list.get(i)[1]==maxCount) {
                 int num= list.remove(i)[0];
                 map.put(num,map.get(num)-1);
                 return num;
             }
         }
         maxCount--;
            for(int i=list.size()-1;i>=0;i--){
                if(list.get(i)[1]==maxCount) {
                   int num= list.remove(i)[0];
                   map.put(num,map.get(num)-1);
                    return num;
                }
            }
       return -1;
        }
    }*/

//开始优化  依旧还是TLE..
/*  class FreqStack {
        Map<Integer, Integer> freq = new HashMap<>();
        List<int[]> list=new LinkedList<>();
        PriorityQueue<Integer> queue=new PriorityQueue<>(Comparator.reverseOrder());
        public FreqStack() {
        }

        public void push(int x) {
            int count=freq.getOrDefault(x, 0) + 1;
            list.add(new int[]{x,count});
            freq.put(x, count);
            queue.offer(count);
        }

        public int pop() {
           int  maxCount=queue.poll();
         for(int i=list.size()-1;i>=0;i--){
             if(list.get(i)[1]==maxCount) {
                 int num= list.remove(i)[0];
                 freq.put(num,freq.get(num)-1);
                 return num;
             }
         }

       return -1;
        }
    }*/

//吊炸天..  用map来存一个(freq,stack)，这样每个数都会存在1-freq之间的stack里，且保持了加入时的顺序
    class FreqStack {
   Map<Integer,Integer> freq=new HashMap<>();
   Map<Integer,Stack<Integer>> map=new HashMap<>();
   int maxFreq=0;
   public FreqStack() {
        }

        public void push(int x) {
        int f=freq.getOrDefault(x,0)+1;
        freq.put(x,f);
        maxFreq=Math.max(f,maxFreq);
        if(!freq.containsKey(f)) map.put(f,new Stack<>());
        map.get(f).add(x);
        }

        public int pop() {
         Stack<Integer> stack=map.get(maxFreq);
     int res=stack.pop();
     freq.put(res,maxFreq-1);
     if(stack.isEmpty()) {
         maxFreq--;
     }
return res;
        }
    }

   //和上边的类似  只是把map换成list
  /*  class FreqStack {

        List<Stack<Integer>> bucket;
        HashMap<Integer, Integer> map;

        public FreqStack() {
            bucket = new ArrayList<>();
            map = new HashMap<>();
        }

        public void push(int x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            int freq = map.get(x);
            if (freq - 1 >= bucket.size()) {
                bucket.add(new Stack<Integer>());
            }
            bucket.get(freq - 1).add(x);
        }

        public int pop() {
            int freq = bucket.size();
            int x = bucket.get(freq - 1).pop();
            if (bucket.get(freq - 1).isEmpty()) bucket.remove(bucket.size() - 1);

            map.put(x, map.get(x) - 1);
            if (map.get(x) == 0) map.remove(x);

            return x;
        }
    }*/
    //把(freq num index)封装成node ，按照指定顺序存入priorityQueue中
    /*class FreqStack {
        int pushCount;
        PriorityQueue<Node> pq;
        Map<Integer, Integer> map;
        public FreqStack() {
            pushCount = 0;
            pq = new PriorityQueue<Node>(new NodeComparator());
            map = new HashMap<Integer, Integer>();
        }

        public void push(int x) {
            if (!map.containsKey(x)){
                map.put(x, 0);
            }
            map.put(x, map.get(x) + 1);
            Node n = new Node(x, map.get(x), pushCount++);
            pq.offer(n);
        }

        public int pop() {
            map.put(pq.peek().value, map.get(pq.peek().value) - 1);
            return pq.poll().value;
        }


        class Node{
            public int value;
            int freq;
            int pushIndex;
            public Node(int v, int f, int p){
                this.value = v;
                this.freq = f;
                this.pushIndex = p;
            }
        }

        class NodeComparator implements Comparator<Node>{
            public int compare(Node a, Node b){
                if (a.freq != b.freq) return b.freq -a.freq;
                return b.pushIndex - a.pushIndex;

            }
        }
    }*/


    public static void main(String[] args) {
        Map<Integer,Integer> linkedHashMap=new LinkedHashMap<>(8,1,true);
        linkedHashMap.put(4,4);
        linkedHashMap.put(1,1);
        linkedHashMap.put(4,3);
        for(Map.Entry<Integer,Integer>entry:linkedHashMap.entrySet()){
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
    }
}
