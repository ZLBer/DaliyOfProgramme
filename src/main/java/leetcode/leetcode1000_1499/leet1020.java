package leetcode.leetcode1000_1499;

/**
 * Created by libin on 2019/3/27.
 */
public class leet1020 {

    public int numEnclaves(int[][] A) {


      for(int i=0;i<A.length;i++){
          for(int j=0;j<A[0].length;j++){
                if(i==0||i==A.length-1||j==0||j==A[0].length-1)  //只搜索边界
                     dfs(A,i,j);
          }
      }

      int result=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++) {
                if(A[i][j]==1) result++;

            }
            }
return result;

    }

    void dfs(int[][]a,int i,int j){  //将与这个边界点有关的所有路径变为0
        if(i >= 0 && i <= a.length - 1 && j >= 0 && j <= a[i].length - 1 && a[i][j] == 1) {
            a[i][j]=0;
            dfs(a,i+1,j);
            dfs(a,i-1,j);
            dfs(a,i,j+1);
            dfs(a,i,j-1);
        }
    }
}
