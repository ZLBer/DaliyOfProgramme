package leetcode.tianchi;

import java源码学习.util.LinkedList;

import java.util.Queue;

public class tianchi1114 {

    public int maximumScore(int[][] matrix) {
        memo=new Integer[matrix.length][matrix[0].length];
      return  helper(-1,0,matrix);
    }


    Integer[][]memo;

    int helper(int x,int y,int[][]matrix){
       if(x==matrix.length-1) return 0;

       if(memo[x+1][y]!=null) return memo[x+1][y];
       int cost=Integer.MIN_VALUE;
       for(int i=0;i<matrix[0].length;i++){
          cost=Math.max(cost,helper(x+1,i,matrix)+matrix[x+1][i]-(x==-1?0:Math.abs(i-y)));
       }
       memo[x+1][y]=cost;
      return cost;
   }


    public boolean LRString(String s, String t, int n) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();

        Queue<Integer> queue=new LinkedList<>();
        for (int i = sarr.length - 1; i >= 0; i--) {
            if(sarr[i]=='l'&&sarr[i]!=tarr[i]){
                queue.add(i);
            }
            else if(sarr[i]=='r'&&sarr[i]!=tarr[i]){
                if(queue.isEmpty())return false;
                int q=queue.poll();
                n-=(q-i);
                if(n<0) return false;
            }
        }

        return queue.isEmpty();

    }

    public static void main(String[] args) {
     /*   maximumScore(new int[][]{
                {1,2},{3,4}
        });*/
    }
}
