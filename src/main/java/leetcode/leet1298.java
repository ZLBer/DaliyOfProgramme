package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class leet1298 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> box=new LinkedList<>();
        Set<Integer> key=new HashSet<>();
        for (int i = 0; i < initialBoxes.length; i++) {
            box.add(initialBoxes[i]);
        }

        int res=0;
        while (true){
            boolean flag=true;
            Queue<Integer> newBox=new LinkedList<>();
          while (!box.isEmpty()){
              int b=box.poll();
             if(status[b]==1||key.contains(b)){
                 //添加盒子
                 res+=candies[b];
                 for (int i = 0; i < containedBoxes[b].length; i++) {
                     flag=false;
                     newBox.add(containedBoxes[b][i]);
                 }
                 for (int i = 0; i < keys[b].length; i++) {
                     flag=false;
                     key.add(keys[b][i]);
                 }
             }
             else {
                 //继续下一次
                 newBox.add(b);
             }
          }
          //设置新的盒子
          box=newBox;

          //没有任何盒子打开 则可以结束
       if(flag) break;

        }
        return res;
    }


   //others  想法是一样的
 /*   public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length; // count of boxes
        boolean[] usedBoxes = new boolean[n]; // this are used once
        boolean[] boxFound = new boolean[n];// new box we found
        Queue<Integer> q = new LinkedList<>();
        for (int v : initialBoxes) {
            q.add(v);
            boxFound[v] = true; // initial boxes
        }
        int candy = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
             //有状态且没有被使用过
            if (status[cur] == 1 && !usedBoxes[cur]) { // not used and box open

                candy += candies[cur];
                usedBoxes[cur] = true;

                //遍历盒子里的钥匙
                //主动去更新更新钥匙状态
                //这个状动作可能会把之前扔掉的 未打开/打开 的盒子再次添加到队列里
                for (int k : keys[cur]) { // all keys in that box
                    status[k] = 1;
                    if (boxFound[k]) q.add(k);// box was found and we have the key
                }
                //遍历盒子里的盒子  无论什么盒子也都会添加，因为都是新发现的
                for (int k : containedBoxes[cur]) {// all boxes in cur box
                    boxFound[k] = true;
                    q.add(k);
                }
            }
        }
        return candy;
    }*/
}
