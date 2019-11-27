package leetcode.leetcode1000_;

import java.util.*;

public class leet1054 {
    //比较好理解的一种做法，每次拿出两个数字添加，还有剩余则放回
/*  static   public int[] rearrangeBarcodes(int[] barcodes) {
        int n=barcodes.length;
        List<Integer> list=new LinkedList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:barcodes){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        //不同返回key大的，不同返回value大的
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue= new PriorityQueue<Map.Entry<Integer, Integer>>(
                (a,b)->b.getValue()-a.getValue() == 0?a.getKey() - b.getKey(): b.getValue() - a.getValue());
        for(Map.Entry entry:map.entrySet()){
           priorityQueue.add(entry);
        }
    int [] result=new int[n];
        int index=0;
        while (!priorityQueue.isEmpty()){
            int k=2;
            List<Map.Entry> tempList=new LinkedList<>();
            while (k>0&&!priorityQueue.isEmpty()){
                Map.Entry<Integer,Integer>  entry=priorityQueue.poll();
                entry.setValue(entry.getValue()-1);
                tempList.add(entry);
                result[index++]=entry.getKey();
                k--;
            }

            for(Map.Entry <Integer,Integer>entry:tempList){
               if(entry.getValue()>0) priorityQueue.add(entry);
            }

        }

        return result;
    }*/

// 奇偶位填充


/*    static public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        List<Integer> list = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : barcodes) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //不同返回key大的，不同返回value大的
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<Map.Entry<Integer, Integer>>(
                (a, b) -> b.getValue() - a.getValue() == 0 ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
        for (Map.Entry entry : map.entrySet()) {
            priorityQueue.add(entry);
        }
        int[] result = new int[n];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = priorityQueue.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result[index] = entry.getKey();
                index += 2;
                if (index >= n) index = 1;
            }
        }

        return result;
    }*/

//放弃优先级队列的奇偶填充
static  public int[] rearrangeBarcodes(int[] B) {
    Map<Integer, Integer> count = new HashMap<>();
    for(int e : B) count.put(e, count.getOrDefault(e, 0) + 1);

    List<Map.Entry<Integer, Integer>> l = new ArrayList<>(count.entrySet());
    Collections.sort(l, (a, b)->Integer.compare(b.getValue(), a.getValue()));

    int idx = 0;
    for(Map.Entry<Integer, Integer> e : l) {
        int c = e.getValue(), v = e.getKey();
        for(int i = 0; i < c; i++) {
            B[idx] = v;
            idx += 2;
            if(idx >= B.length) idx = 1;
        }
    }
    return B;
}

    public static void main(String[] args) {
        int[] res = rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3});

        for (int i : res) {
            System.out.print(i + "  ");
        }
    }
}
