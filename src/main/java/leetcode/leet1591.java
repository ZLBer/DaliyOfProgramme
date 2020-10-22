package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

public class leet1591 {

    //mine  模拟  从上往下
    //就每次都必须有一种颜色可以消去  否则就false
  /*  public boolean isPrintable(int[][] targetGrid) {
        Map<Integer,int[]> map= init(targetGrid);


        int all=map.size();
        Set<Integer> blank=new HashSet<>();
        while (true){
            if(blank.size()==all) return true;

            boolean flag=false;
            for (Integer key : map.keySet()) {
                if(check(key,targetGrid,map.get(key),blank)){
                    flag=true;     continue;

                }

            }
           if(!flag) return false; //标识一次也不能成功
        }

    }
     boolean check(int color, int [][]targetGrid, int []udlr, Set<Integer> blank){
        if(blank.contains(color)) return false;
        for(int i=udlr[0];i<=udlr[1];i++){
            for(int j=udlr[2];j<=udlr[3];j++){

                if(blank.contains(targetGrid[i][j])||targetGrid[i][j]==color) continue;
                else return false;
            }
        }
        blank.add(color); //已经空白了
        return true;
    }

     Map<Integer,int[]> init(int [][]target){
        Map<Integer,int[]> map=new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[0].length; j++) {
                if(!map.containsKey(target[i][j])){
                    map.put(target[i][j],new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE});
                }
                int []udlr=map.get(target[i][j]);
                udlr[0]=Math.min(i,udlr[0]);
                udlr[1]=Math.max(i,udlr[1]);
                udlr[2]=Math.min(j,udlr[2]);
                udlr[3]=Math.max(j,udlr[3]);
            }
        }
        return map;
    }*/



  //拓扑排序

    public boolean isPrintable(int[][] targetGrid) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[61];
        for(int i = 0; i <= 60; i++) graph.add(new ArrayList<>());
        for(int i = 1; i <= 60; i++) search(targetGrid, i, graph, inDegree);

        Deque<Integer> zeros = new ArrayDeque<>();
        HashSet<Integer> seen = new HashSet<>();
        for(int i = 0; i < inDegree.length; i++) if(inDegree[i] == 0) zeros.add(i);

        while(!zeros.isEmpty()) {
            int cur = zeros.poll();
            if(!seen.add(cur)) continue;

            for(Integer nbh : graph.get(cur)) {
                inDegree[nbh]--;
                if(inDegree[nbh] == 0) zeros.add(nbh);
            }
        }
        return seen.size() == 61;
    }

    private void search(int[][] grid, int color, List<List<Integer>> graph, int[] inDegree) {
        // get range
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++) for(int j = 0; j < grid[0].length; j++) {
            if(grid[i][j] == color) {
                minX = Math.min(minX, i);
                maxX = Math.max(maxX, i);
                minY = Math.min(minY, j);
                maxY = Math.max(maxY, j);
            }
        }

        if(minX == Integer.MAX_VALUE) return ;

        // check relations
        for(int i = minX; i <= maxX; i++) for(int j = minY; j <= maxY; j++) {
            if(grid[i][j] != color) {
                graph.get(grid[i][j]).add(color); // to paint current color, we need to paint color in grid[i][j] first
                inDegree[color]++;
            }
        }
    }

        public static void main(String[] args) {
/*        isPrintable(new int[][]{
//                {1,1,1,1},{1,1,3,3},{1,1,3,4},{5,5,1,4}
                {1,1,1,1},{1,2,2,1},{1,2,2,1}

        });*/
    }

}
