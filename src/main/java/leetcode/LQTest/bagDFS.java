package leetcode.LQTest;

import java.util.Arrays;

/**
 * Created by libin on 2018/3/29.
 */
public class bagDFS {
    int [] weight=new int[]{2,1,3,2};
    int [] value=new int[] {12,10,20,15};
//    int [] weight=new int[]{3,2,2,1};
//    int [] value=new int[] {20,15,12,10};
    int capacity=5;
 static    int bestValue;
    int temValue;
    int temWeight;
    void DFS(int layer){
        if(layer>weight.length-1){
            if(temValue>bestValue) bestValue=temValue;
            return;
        }
      if(temWeight+weight[layer]<=capacity){
            temWeight+=weight[layer];
            temValue+=value[layer];
            DFS(layer+1);
          temWeight-=weight[layer];
          temValue-=value[layer];
      }
         DFS(layer+1);
    }
    boolean check(int layer){
        return false;
    }

    public static void main(String[] args) {
         bagDFS te=new bagDFS();

        te.DFS(0);
        System.out.println(bestValue);
    }
}
