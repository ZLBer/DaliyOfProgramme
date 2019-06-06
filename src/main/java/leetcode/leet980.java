package leetcode;

public class leet980 {
    int result;
    int [][]board=new int[][]{
            {0,1},{0,-1},{-1,0},{1,0}
    };
    public int uniquePathsIII(int[][] grid) {
         int empty=0;
         int [] start=new int[2];


         for(int i=0;i<grid.length;i++){
             for(int j=0;j<grid[0].length;j++){
                 if(grid[i][j]==0){
                     empty++;
                     continue;
                 }
                 else if(grid[i][j]==1){
                     start[0]=i;
                     start[1]=j;
                 }
             }
         }

         boolean [][]visited=new boolean[grid.length][grid[0].length];
        visited[start[0]][start[1]]=true;
        for(int []b:board){
            dfs(grid,visited,start[0]+b[0],start[1]+b[1],0,empty);
        }
        return  result;
    }


     void dfs(int [][]grid,boolean [][] visited,int x,int y,int temp,int empty){
        if(x<0||x>=grid.length||y<0||y>=grid.length||visited[x][y]||grid[x][y]==-1) return;


        if(grid[x][y]==2&&temp==empty) {
            result++;
            return;
        } else if(grid[x][y]==2){
            return;
        }


         visited[x][y]=true;
         temp++;

       for(int []b:board){
           dfs(grid,visited,x+b[0],y+b[1],temp,empty);
       }

        visited[x][y]=false;
        temp--;


    }
}
