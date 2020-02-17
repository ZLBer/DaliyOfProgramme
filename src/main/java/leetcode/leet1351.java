package leetcode;

public class leet1351 {
    //mine
/*    public int countNegatives(int[][] grid) {
        int res=0;
        for (int i = 0; i < grid.length; i++) {
            int count=0;
            for (int j = grid[i].length-1; j>=0; j--) {
                if(grid[i][j]<0){
                    count++;
                }else break;
            }
            res+=count;
        }
        return res;
    }*/

    // mine 二分  快了很多
  /*  public int countNegatives(int[][] grid) {
        int res=0;
        for (int i = 0; i < grid.length; i++) {
             res+=check(grid[i]);
        }
        return res;
    }
    int check(int []arr){
        int res=0;
        int left=0,right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(arr[mid]<0){
                res+=(right-mid+1);
                right=mid-1;

            }
            //>=0
            else {
                 left=mid+1;
            }
        }
        return  res;
    }*/


        //可以直接利用列也递减的特性
        public int countNegatives(int[][] grid) {
            int row=grid.length-1,col=0;
            int res=0;
            while (row>=0&&col<grid[0].length){
                if(grid[row][col]<0){
                    res+=grid[0].length-col;
                    row--;
                }else {
                    col++;
                }
            }
            return res;
        }
}
