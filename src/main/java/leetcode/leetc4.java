package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class leetc4 {
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

       if(flag) break;

        }
        return res;
    }
}
