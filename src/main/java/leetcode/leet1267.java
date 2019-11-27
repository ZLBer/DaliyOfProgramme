package leetcode;

public class leet1267 {

    //mine  暴力法
    public int countServers(int[][] grid) {
 int res=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if(check(i,j,grid)) res++;
                }
            }
        }

     return  res;
    }

   boolean check(int i,int j,int [][]grid){
        for(int k=0;k<grid[0].length;k++){
            if(k!=j&&grid[i][k]==1) return true;
        }

        for(int k=0;k<grid.length;k++){
            if(k!=i&&grid[k][j]==1) return true;
        }
        return false;
   }
}
