package leetcode;

import java.util.PriorityQueue;

public class leet1337 {

    //mine 一遍成功   list排序
   /* public int[] kWeakestRows(int[][] mat, int k) {

        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int count=0;
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j]==1) {
                    count++;
                }else break;
            }
            list.add(new int[]{i,count});
        }
        Collections.sort(list,(int []a,int []b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
       int []res=new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i]=list.get(i)[0];
        }
        return res;
    }*/

    //mine 改成优先级队列 也就是heap堆

    public int[] kWeakestRows(int[][] mat, int k) {

        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>((int []a, int []b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        for (int i = 0; i < mat.length; i++) {
            int count=0;
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j]==1) {
                    count++;
                }else break;
            }
            priorityQueue.add(new int[]{i,count});
        }
        int []res=new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i]=priorityQueue.poll()[0];
        }
        return res;
    }
}
