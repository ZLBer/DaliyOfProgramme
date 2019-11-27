package leetcode.leetcode1000_;

public class leet1139$ {
    public int largest1BorderedSquare(int[][] grid) {
  int [][]left=new int[grid.length][grid[0].length];
  int [][]top=new int[grid.length][grid[0].length];
  for(int i=0;i<grid.length;i++){
      for(int j=0;j<grid[0].length;j++){
          if(grid[i][j]>0) {
              if(i==0){
                top[i][j]=1;
              }else {
                  top[i][j]=top[i-1][j]+1;
              }

           if(j==0){
             left[i][j]=1;
           }else {
               left[i][j]=left[i][j-1]+1;
           }
          }
      }
  }
    /*    for(int i=0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(left[i][j]+"  ");
            }
        }
*/

    for(int l=Math.min(grid.length,grid[0].length);l>0;l--){
        for(int i=0;i+l<grid.length+1;i++){
            for(int j=0;j+l<grid[0].length+1;j++){
                if(left[i][j+l-1]>=l&&left[i+l-1][j+l-1]>=l&&top[i+l-1][j]>=l&&top[i+l-1][j+l-1]>=l)
                    return (l)*(l);
            }
        }
    }


  return 0;
    }
}
