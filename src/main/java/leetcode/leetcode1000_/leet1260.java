package leetcode.leetcode1000_;

import java.util.ArrayList;
import java.util.List;

public class leet1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
       while (k-->0){
           int []temp=new int[grid.length];
           for(int i=0;i<grid.length;i++){
               temp[i]=grid[i][m-1];
           }

           for(int i=m-1;i>0;i--){
               for(int j=0;j<n;j++){
                   grid[j][i]=grid[j][i-1];
               }
           }
           grid[0][0]=temp[n-1];
           for(int i=1;i<n;i++){
               grid[i][0]=temp[i-1];
           }
       }
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> temp=new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                 temp.add(grid[i][j]);
            }
            res.add(temp);
        }
        return res;
    }
}
