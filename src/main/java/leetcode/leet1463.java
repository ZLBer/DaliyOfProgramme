package leetcode;

public class leet1463 {


    //一次过了 哈哈哈  记忆化搜索
/*    public int cherryPickup(int[][] grid) {
  int[][][]dp=new int[grid.length][grid[0].length][grid[0].length];



  return  dfs(grid,dp,0,grid[0].length-1,0);


    }

  int []next=new int[]{-1,0,1};
    int dfs(int [][]grid,int[][][]dp,int robot1,int robot2,int deep){
      if(deep>=grid.length){
   return 0;
      }


     if(dp[deep][robot1][robot2]!=0) return dp[deep][robot1][robot2];


       int there=0;
        if(robot1!=robot2)
            there=grid[deep][robot2]+grid[deep][robot1];
        else there=grid[deep][robot1];


        int max=0;
        for (int i : next) {
            int newRobot1=robot1+i;
            for (int j : next) {
             int newRobot2=robot2+j;
       if(check(newRobot1,grid)&&check(newRobot2,grid))
          max=Math.max(max, dfs(grid,dp,newRobot1,newRobot2,deep+1));
            }
        }

        dp[deep][robot1][robot2]=max+there;
        return max+there;
    }

    boolean check(int robot,int [][]grid){
        if(robot>=0&&robot<grid[0].length) return true;
        else return false;
    }*/


    //mine  试试直接dp


    public int cherryPickup(int[][] grid) {
        int[][][]dp=new int[grid.length][grid[0].length][grid[0].length];

        dp[0][0][grid[0].length-1]=grid[0][0]+grid[0][grid[0].length-1];





        int []next=new int[]{-1,0,1};
        for (int i = grid.length-1; i >=0; i--) {
            for (int j = 0; j < grid[0].length; j++) {
                for (int k = j+1; k < grid[0].length; k++) {  //注意：此处可以优化，只需要j小k大即可
                   int there=0;
                    if(j!=k){
                     there=grid[i][j]+grid[i][k];
                   }else {
                        there=grid[i][j];
                    }

                   if(i==grid.length-1){  //最后一行单独算
                     dp[i][j][k]=there;
                     continue;
                   }

                    int max=0;

                    for (int one : next) {
                        int newRobot1=one+j;
                        for (int two : next) {
                            int newRobot2=two+k;
                            if(check(newRobot1,grid)&&check(newRobot2,grid))
                                max=Math.max(max, dp[i+1][newRobot1][newRobot2]);
                        }
                    }
                    dp[i][j][k]=max+there;
                }
            }
        }

  return dp[0][0][grid[0].length-1];
    }
    boolean check(int robot,int [][]grid){
        if(robot>=0&&robot<grid[0].length) return true;
        else return false;
    }
}
