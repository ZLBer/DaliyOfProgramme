package leetcode.leetcode1000_;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by libin on 2019/4/28.
 */
public class leet1034 {
    //mine DFS
    //bfs仅需要加个队列就可以
    int [][] indexChange={
            {0,1},{0,-1},{1,0},{-1,0}
    };

   /* public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if(color==grid[r0][c0])return grid;
       int precolor=grid[r0][c0];
        //int [][]preGrid=grid.clone(); 这里有个巨坑，二维数组和一维数组的clone不一样，二维数组依然是浅复制
        int [][]preGrid=new int[grid.length][grid[0].length];
        for (int i = 0; i < preGrid.length; i++) {
             preGrid[i]=Arrays.copyOf(grid[i],grid[i].length);
        }
        //记得visit数组结束递归
        boolean [][]visited=new boolean[grid.length][grid[0].length];
       DFS(preGrid,grid,visited,precolor,color,r0,c0);
       return grid;
    }*/
    void DFS(int [][] preGrid,int[][]grid,boolean [][] visited,int precolor,int color,int r0,int c0){
        //越界
        if(r0<0||r0>=grid.length||c0<0||c0>=grid[0].length||visited[r0][c0]){
            return;
        }
        visited[r0][c0]=true;
        //如果此处是选中的颜色
        if(grid[r0][c0]==precolor){
            //判断是否是边界
            if(isBoundary(preGrid,r0,c0,precolor)){
                grid[r0][c0]=color;
            }
        }
      else return;

        for(int []index:indexChange){
            DFS(preGrid,grid,visited,precolor,color,r0+index[0],c0+index[1]);
        }

    }



    boolean isBoundary(int[][]grid,int r0,int c0,int color){


       for(int[] index:indexChange){
           if(r0+index[0]<0||c0+index[1]<0||r0+index[0]>=grid.length||c0+index[1]>=grid[0].length||grid[r0+index[0]][c0+index[1]]!=color){
               return true;
           }
       }

       return false;
    }
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if(color==grid[r0][c0])return grid;
        int precolor=grid[r0][c0];
        //int [][]preGrid=grid.clone(); 这里有个巨坑，二维数组和一维数组的clone不一样，二维数组依然是浅复制
        int [][]preGrid=new int[grid.length][grid[0].length];
        for (int i = 0; i < preGrid.length; i++) {
            preGrid[i]=Arrays.copyOf(grid[i],grid[i].length);
        }
        //记得visit数组结束递归
        boolean [][]visited=new boolean[grid.length][grid[0].length];
        Queue<int []> queue=new LinkedList<>();
       queue.offer(new int[]{r0,c0});
       BFS(preGrid,grid,visited,precolor,color,queue);
        return grid;
    }
  void BFS(int[][]preGrid,int[][]grid,boolean[][]visited,int precolor,int color,Queue<int []>queue){
        while (!queue.isEmpty()){
            int []a=queue.poll();
            int r0=a[0],c0=a[1];
            if(visited[r0][c0]) continue;
            visited[r0][c0]=true;
            if(grid[r0][c0]==precolor){

                if(isBoundary(preGrid,r0,c0,precolor)){
                    grid[r0][c0]=color;
                }
            }
            else continue;
            for(int []index:indexChange){
                if(r0+index[0]>=0&&r0+index[0]<grid.length&c0+index[1]>=0&&c0+index[1]<grid[0].length){
                    queue.add(new int[]{r0+index[0],c0+index[1]});
                }
            }

        }
  }

}
