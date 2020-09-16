package leetcode.leetcode1000_1499;

import java.util.*;

public class leet1345 {
    //mine BFS
  static public int minJumps(int[] arr) {
      if(arr.length!=1&&arr[0]==arr[arr.length-1]) return 1;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        Map<Integer, List<Integer>> map=new HashMap<>(); //数字和index的映射
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list=map.computeIfAbsent(arr[i],k->new ArrayList<>());
            list.add(i);
        }
       // Set<Integer> visited=new HashSet<>();
        boolean []visited=new boolean[arr.length];
        int step=-1;
        while (!queue.isEmpty()){
            int size=queue.size();
            step++;
            while (size-->0){
            int index=queue.poll();
            if(index==arr.length-1) return step;
            if(visited[index]==true) continue;
            else  visited[index]=true;

            if(index-1>=0&&!visited[index-1]){
               queue.add(index-1);
            }
            if(index+1<arr.length&&!visited[index+1]){
                queue.add(index+1);
            }

            for(int i:map.get(arr[index])){
                if(!visited[i]) queue.add(i);
            }
        map.get(arr[index]).clear(); //小技巧  怪不得那么多人未通过
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        minJumps(new int[]{100,-23,100});
    }
}
