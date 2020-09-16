package leetcode.leetcode1000_1499;

import java.util.*;

public class leet1329 {
/*    public int[][] diagonalSort(int[][] mat) {
     Map<Integer, PriorityQueue<Integer>> map=new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                map.putIfAbsent(i-j,new PriorityQueue<>());
                map.get(i-j).add(mat[i][j]);
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
            mat[i][j]=map.get(i-j).poll();
            }
        }
    return mat;
    }*/


//可以一趟一趟排序
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int r = m - 1, c = 0; r >= 0; r--) fillMatrix(mat, m, n, r, c);
        for (int r = 0, c = 1; c < n - 1; c++) fillMatrix(mat, m, n, r, c);
        return mat;
    }
    private void fillMatrix(int[][] mat, int m, int n, int r, int c) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; r + i < m && c + i < n; i++) arr.add(mat[r + i][c + i]);
        Collections.sort(arr);
        for (int i = 0; r + i < m && c + i < n; i++) mat[r + i][c + i] = arr.get(i);
    }
}
