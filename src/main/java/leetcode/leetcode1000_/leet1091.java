package leetcode.leetcode1000_;

import java源码学习.util.LinkedList;

import java.util.Queue;

public class leet1091 {


    //dfs   Time Limit Exceeded
    //因为需要遍历所有的路径
    //
  /*  int min=Integer.MAX_VALUE;
    public int shortestPathBinaryMatrix(int[][] grid) {
     boolean[][]visited=new boolean[grid.length][grid.length];
     dfs(grid,visited,0,0,0);
     if(min==Integer.MAX_VALUE)return -1;
     else return min;
    }

   void dfs(int [][]grid,boolean[][]visited,int x,int y,int count){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||visited[x][y]||grid[x][y]==1) return;
     count++;
     visited[x][y]=true;
        if(x==grid.length-1&&y==grid.length-1){
            min= Math.min(min,count);
            return;
        }

        int [][]nexts={{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1} };

        for (int []next:nexts){
            dfs(grid,visited,x+next[0],y+next[1],count);
        }
        count--;
        visited[x][y]=false;
   }*/


    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1) {
            return -1;
        }
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        int ans=1;
        int [][]nexts={{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1} };
   boolean [][]visited=new boolean[grid.length][grid.length];
   visited[0][0]=true;
        while (!queue.isEmpty()){
           int size=queue.size();
           for(int i=0;i<size;i++){
               int[]point=queue.poll();
              if(point[0]==grid.length-1&&point[1]==grid.length-1)
                   return ans;

              for(int []next:nexts){
                  int nextX=point[0]+next[0];
                  int nextY=point[1]+next[1];

                  if(nextX>=0&&nextY>=0&&nextX<grid.length&&nextY<grid.length&&visited[nextX][nextY]==false&&grid[nextX][nextY]==0)
                  {
                      queue.add(new int[]{nextX,nextY});
                      visited[nextX][nextY]=true;
                  }
              }

           }
           ans++;
        }

        return -1;
    }
}
