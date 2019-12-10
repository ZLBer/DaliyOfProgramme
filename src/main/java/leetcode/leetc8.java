package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class leetc8 {


    //mine 暴力法可以解决  但当时contest的时候前一个题目想太久了，导致根本没得时间做这个
    public int minFlips(int[][] mat) {


        Queue<Integer[][]> queue=new LinkedList<>();
        Set<String> set=new HashSet<>();
        Integer [][]copy=new Integer[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
            copy[i][j]=mat[i][j];
            }
        }
      int step=0;
      queue.add(copy);
        while (!queue.isEmpty()){
            step++;
            int size=queue.size();
            while (size-->0){
                Integer [][] arr=queue.poll() ;
                if(check(arr)) return step-1;
                String encoding=code(arr);
                if(set.contains(encoding)) continue;
                set.add(encoding);
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < mat[0].length; j++) {
                        Integer [][]pre=new Integer[arr.length][arr[0].length];
                        for (int a = 0; a < mat.length; a++) {
                            for (int b = 0; b < mat[0].length; b++) {
                                pre[a][b]=arr[a][b];
                            }
                        }
                        reverse(pre,i,j);

                        queue.add(pre);

                    }
                }
            }

        }
return -1;
    }

    int[][]next={{0,1},{0,-1},{1,0},{-1,0}};
    //矩阵变换
    void reverse(Integer[][]mat,int i,int j){
        mat[i][j]^=1;
        for (int n = 0; n < next.length; n++) {
          int x=i+next[n][0];
          int y=j+next[n][1];
          if(x>=0&&y>=0&&x<mat.length&&y<mat[0].length){
              mat[x][y]^=1;
          }
        }
    }
  boolean check(Integer[][]mat){
      for (int i = 0; i < mat.length; i++) {
          for (int j = 0; j < mat[0].length; j++) {
          if(mat[i][j]==1) return false;
          }
          }
      return true;
  }


  String code(Integer[][]mat){
        StringBuilder sb=new StringBuilder();
      for (int i = 0; i < mat.length; i++) {
          for (int j = 0; j < mat[0].length; j++) {
              sb.append(mat[i][j]);
          }
      }
      return sb.toString();
  }
    public static void main(String[] args) {
        System.out.println(1^1);
        System.out.println(0^1);
    }
}
