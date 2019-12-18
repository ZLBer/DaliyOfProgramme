package leetcode;

import java.util.*;

public class leet1284 {


    //mine 暴力法可以解决  但当时contest的时候前一个题目想太久了，导致根本没得时间做这个
 /*   public int minFlips(int[][] mat) {


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
  }*/



 //按照行列进行编码
    private static final int[] d = {0, 0, 1, 0, -1, 0};
    public int minFlips(int[][] mat) {
        int start = 0, m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                //左移操作
                start |= mat[i][j] << (i * n + j); // convert the matrix to an int.
        Queue<Integer> q = new LinkedList<>(Arrays.asList(start));
        Set<Integer> seen = new HashSet<>(q);
        //BFS
        for (int step = 0; !q.isEmpty(); ++step) {
            for (int sz = q.size(); sz > 0; --sz) {
                int cur = q.poll();
                //即所有的数字都是0
                if (cur == 0) // All 0s matrix found.
                    return step;
                //需要把所有的位置都进行反转
                for (int i = 0; i < m; ++i) { // traverse all m * n bits of cur.
                    for (int j = 0; j < n; ++j) {
                        int next = cur;
                        //反转的关键步骤
                        for (int k = 0; k < 5; ++k) { // flip the cell (i, j) and its neighbors.
                            //求出行号和列好
                            int r = i + d[k], c = j + d[k + 1];
                            //保证不越界
                            if (r >= 0 && r < m && c >= 0 && c < n)
                                //异或进行反转
                                //根据行号和列好进行位置计算
                                next ^= 1 << (r * n + c);
                        }
                        if (seen.add(next)) // seen it before ?
                            q.offer(next); // no, put it into the Queue.
                    }
                }
            }
        }
        return -1; // impossible to get all 0s matrix.
    }



    public static void main(String[] args) {
        System.out.println(1^1);
        System.out.println(0^1);
    }
}
