package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet1632 {
   static class Point{
       int x;
       int y;
       int value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }


    //排序+并查集
  static   public int[][] matrixRankTransform(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;

        Point[] points=new Point[m*n];

        int k=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                points[k++]=new Point(i,j,matrix[i][j]);
            }
        }

        Arrays.sort(points,(a,b)->a.value-b.value);

        int []row=new int[m];
        int []col=new int[n];

  
        int [][]res=new int[m][n];

        for (int i = 0; i < points.length; ) {
            int pre=points[i].value;
           List<Point> list=new ArrayList<>();
           UnionFind uf=new UnionFind(m+n);
            while (i<points.length&&points[i].value==pre){
               list.add(points[i]);
              uf.union(points[i].x,points[i].y+m);
                i++;
            }

            Map<Integer,List<Point>> map=new HashMap<>();


            //按照联通分组
            for (Point point : list) {
                int key=uf.find(point.x);
               if(!map.containsKey(key)) map.put(key,new ArrayList<>());
               map.get(key).add(point);
            }

            //寻找每个组的最大值
            for (List<Point> values : map.values()) {
                int max=0;
                for (Point point : values) {
                   max=Math.max(row[point.x]+1,Math.max(col[point.y]+1,max));
                }
                for (Point point : values) {
                   res[point.x][point.y]=max;
                   row[point.x]=max;
                   col[point.y]=max;
                }
            }

        }
 return res;
    }

  static   class UnionFind{
        public final int[] parents;
        public int count;

        public UnionFind(int n){
            this.parents = new int[n];
            reset();
        }

        public void reset(){
            for(int i =0;i<parents.length;i++){
                parents[i] = i;
            }
            count = parents.length-1;
        }

        public int find(int i){
            int parent = parents[i];
            if(parent == i){
                return i;
            }else{
                int root = find(parent);
                parents[i] = root;
                return root;
            }
        }

        public boolean union(int i, int j){
            int r1 = find(i);
            int r2 = find(j);
            if(r1 != r2){
                count--;
                parents[r1] = r2;
                return true;
            }else{
                return false;
            }
        }

    }
/*    int getMax(int val,int i,Point []points,int [][]row,int [][]col){
      int max=0;
       while (i<points.length){

       }
    }*/

    public static void main(String[] args) {
       /* matrixRankTransform(new int[][]{
                {-37,-50,-3,44},{-37,46,13,-32},{47,-42,-3,-40},{-17,-22,-39,24}
        });*/

               matrixRankTransform(new int[][]{
                {7,7},{7,7}
        });
    }



   /* public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] ret = new int[m][n];
        int[] row = new int[m];
        int[] col = new int[n];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                queue.offer(new int[]{matrix[i][j], i, j});
            }
        }
        while(!queue.isEmpty()) {
            int target = queue.peek()[0];
            List<int[]> list = new ArrayList<>();
            while(!queue.isEmpty() && queue.peek()[0] == target) {
                list.add(queue.poll());
            }
            UF uf = new UF(m + n);
            for (int[] pair : list) {
                uf.union(pair[1], pair[2] + m);
            }
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int[] pair : list) {
                map.computeIfAbsent(uf.find(pair[1]), $ -> new ArrayList<>()).add(pair);
            }
            for (List<int[]> group : map.values()) {
                int rank = 0;
                for (int[] arr : group) {
                    int i = arr[1], j = arr[2];
                    rank = Math.max(rank, Math.max(row[i], col[j]) + 1);
                }
                for (int[] arr : group) {
                    int i = arr[1], j = arr[2];
                    ret[i][j] = rank;
                    row[i] = Math.max(row[i], rank);
                    col[j] = Math.max(col[j], rank);
                }
            }
        }
        return ret;
    }
    class UF {
        UF(int size) {
            parent = new int[size];
            for(int i = 0; i < size; i++)
                parent[i] = i;
        }
        private int[] parent;
        private int find(int x) {
            if(parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
        private void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }*/
}
