package leetcode.leetcode500_999;

/**
 * Created by libin on 2019/1/15.
 */
public class leet807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
     int []top=new int[grid[0].length];
     int []left =new  int[grid.length];
     for(int i=0;i<top.length;i++){
         for(int j=0;j<left.length;j++){
             if(grid[j][i]>top[i]) top[i]=grid[j][i];
         }
     }

     for(int i=0;i<left.length;i++){
         for(int j=0;j<top.length;j++){
             if(grid[i][j]>left[i])  left[i]=grid[i][j];
         }
     }
     int count=0;
   for(int i=0;i<grid.length;i++){
         for(int j=0;j<grid[0].length;j++){
            count+=Math.min(top[j],left[i])- grid[i][j];
         }
   }
   return count;
    }
}
