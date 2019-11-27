package leetcode.leetcode500_999;

import java.util.*;

public class leet846 {
/*    public boolean isNStraightHand(int[] hand, int W) {
        Arrays.sort(hand);
       int w=0,pre=0,count=0;
       boolean[]visited=new boolean[hand.length];
        for (int i = 0; i < hand.length; i++) {
           if(w==0){
               pre=hand[i];
               visited[i]=true
               w=W;
           }
            if(pre+1==hand[i]){
                w--;
                pre=hand[i];
            }else {
                return false;
            }

        }
        return true;
    }*/


//mine TreeMap
/*  static   public boolean isNStraightHand(int[] hand, int W) {
      if(hand.length%W!=0) return false;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }
        while (!map.isEmpty()){
            Map.Entry<Integer,Integer> minEntry=map.firstEntry();
            if(minEntry.getValue()==1){
                map.remove(minEntry.getKey());
            }else {
                map.put(minEntry.getKey(),minEntry.getValue()-1);
            }
            int w=W-1;
            while (w-->0){
                Map.Entry<Integer,Integer> entry=map.ceilingEntry(minEntry.getKey()+1);
                if(entry==null) return false;
                if(entry.getKey()==minEntry.getKey()+1){
                    if(entry.getValue()==1){
                        map.remove(entry.getKey());
                    }else {
                        map.put(entry.getKey(),entry.getValue()-1);
                    }

                }
                else {
                    return false;
                }
                minEntry=entry;
            }
        }
        return true;
    }*/


   //大哥的解法
  /*  public boolean isNStraightHand(int[] hand, int W) {
       // if(hand.length%W!=0) return false;
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : hand) c.put(i, c.getOrDefault(i, 0)+1);
        for (int it : c.keySet()) {
            int value = c.get(it);
            if (value > 0)
                for (int i = W - 1; i >= 0; --i) {
                    //避免多个相同值的情况
                    if (c.getOrDefault(it + i, 0) <value) return false;
                    //更新后续
                    c.put(it + i, c.get(it + i) - value);
                    //每次取出的最小值根本不用管
                }
        }
        return true;
    }*/




    //关键点：用opened记录开始的序列的数目  真的强
  /*  public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : hand) c.put(i, c.getOrDefault(i, 0)+1);
        Queue<Integer> start = new LinkedList<>();
        int last_checked = -1, opened = 0;
        for (int i : c.keySet()) {
            //一系列检查  opened > c.get(i)表示后边的不足以把前面的序列抵消
            if (opened > 0 && i > last_checked + 1 || opened > c.get(i)) return false;
            //计算此刻有几个打开的序列
            start.add(c.get(i) - opened);
            last_checked = i;
            //更新opened
            opened = c.get(i);
            //达到指定长度，首元素出队，opened更新
            if (start.size() == W) opened -= start.remove();
        }
        return opened == 0;
    }
*/

  //优先级队列也是一种解决办法
    public boolean isNStraightHand(int[] hand, int W) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : hand){
            minHeap.add(i);
        }
        while(minHeap.size() != 0) {
            int start = minHeap.poll();
            for(int j = 1; j < W; j++){
                if(minHeap.remove(start + j)) {
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
       // isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8},3);
    }
}
