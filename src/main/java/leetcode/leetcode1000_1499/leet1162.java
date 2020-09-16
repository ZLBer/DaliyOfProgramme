package leetcode.leetcode1000_1499;

import java.util.LinkedList;
import java.util.Queue;

public class leet1162 {

    //mine  没个water都要遍历
   static int[][]direction={{0,1},{0,-1},{1,0},{-1,0}};
  /*static   public int maxDistance(int[][] grid) {
        int max=-1;
      for(int i=0;i<grid.length;i++){
          for(int j=0;j<grid[0].length;j++){
              max=Math.max(max,bfs(new int[]{i,j},new boolean[grid.length][grid[0].length],grid));
          }
      }
      return max;
    }


   static int  bfs(int []xy,boolean [][]isTaken,int[][]grid){
        if(grid[xy[0]][xy[1]]==1) return -1;
        Queue<int[]>queue=new LinkedList<>();
        queue.add(xy);
        int distance=0;
        while (!queue.isEmpty()){
             distance++;
             int size=queue.size();
             for(int s=0;s<size;s++){
                 int []a=queue.poll();
                 //四个方向
                 for(int i=0;i<4;i++){
                     int x=a[0]+direction[i][0];
                     int y=a[1]+direction[i][1];
                     if(x>=0&&x<isTaken.length&&y>=0&&y<isTaken[0].length&&!isTaken[x][y]){
                         if(grid[x][y]==1) return distance;
                         isTaken[x][y]=true;
                         queue.add(new int[]{x,y});

                     }
                 }
             }

        }

        return -1;
        }*/


  //若是按照land遍历
    static   public int maxDistance(int[][] grid) {
        int max=-1;
        Queue<int[]>queue=new LinkedList<>();
        boolean [][]visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    queue.offer(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
        int distance=0;
        while (!queue.isEmpty()){
            distance++;
            int size=queue.size();
            for(int s=0;s<size;s++){
                int []a=queue.poll();
                //四个方向
                for(int i=0;i<4;i++){
                    int x=a[0]+direction[i][0];
                    int y=a[1]+direction[i][1];
                    if(x>=0&&x<visited.length&&y>=0&&y<visited[0].length&&!visited[x][y]){
                        visited[x][y]=true;
                        queue.add(new int[]{x,y});
                    }
                }
            }

        }
        return distance==1||distance==0?-1:distance-1;
    }






    public static void main(String[] args) {
        System.out.println(maxDistance(new int[][]{
             {1,1},{1,1}
     }));

    }
    }

