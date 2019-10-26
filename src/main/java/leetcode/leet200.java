package leetcode;

public class leet200 {
/*    int [][]next={
        {0,1},{1,0},{0,-1},{-1,0}
};
    public int numIslands(char[][] grid) {
      if(grid.length==0) return 0;
 boolean [][]visited=new boolean[grid.length][grid[0].length];
 int count=0;
 for(int i=0;i<grid.length;i++){
     for(int j=0;j<grid[0].length;j++){
         if(grid[i][j]=='0'||visited[i][j]) continue;
         else {
             DFS(grid,visited,i,j);
             count++;
         }
     }
 }
 return count;
    }
   void DFS(char[][]gird,boolean[][]visited,int x,int y){
         if(gird[x][y]=='0'||visited[x][y]) return ;
         visited[x][y]=true;
         for(int i=0;i<next.length;i++){
             int tempX=x+next[i][0];
             int tempY=y+next[i][1];
             if(tempX>=0&&tempY>=0&&tempX<gird.length&&tempY<gird[0].length){
                 DFS(gird,visited,tempX,tempY);
             }
         }
   }*/


   //可以不用visist数组


    int [][]next={
            {0,1},{1,0},{0,-1},{-1,0}
    };
    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='0') continue;
                else {
                    DFS(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    void DFS(char[][]gird,int x,int y){
        if(gird[x][y]=='0') return ;
        gird[x][y]='0';
        for(int i=0;i<next.length;i++){
            int tempX=x+next[i][0];
            int tempY=y+next[i][1];
            if(tempX>=0&&tempY>=0&&tempX<gird.length&&tempY<gird[0].length){
                DFS(gird,tempX,tempY);
            }
        }
    }


  //BFS
 /*   int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int islands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    BFS(grid,i,j);
                }
            }
        }
        return islands;
    }
    private void BFS(char[][] grid, int x, int y){
        grid[x][y] = '0';
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(x,y));
        while(q.size()>0){
            int size = q.size();
            Point p = q.poll();
            for(int i=0;i<size;i++){
                for(int[] dir:dirs){
                    int x1 = p.x+dir[0];
                    int y1 = p.y+dir[1];
                    if(x1>=0 && y1>=0 && x1< grid.length && y1<grid[0].length && grid[x1][y1]=='1'){
                        grid[x1][y1] = '0';
                        q.offer(new Point(x1,y1));
                    }
                }
            }
        }
    }
}
class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }*/
}
