package leetcode;

/**
 * Created by libin on 2019/1/22.
 */
public class leet892$ {
//    public int surfaceArea(int[][] grid) {
//        int surface=0;
//        //上下面计算
//        surface+=grid.length*grid[0].length*2;
//
//        //左右面计算
//        for(int i=0;i<grid.length;i++){
//            int maxI=0;
//            for(int j=0;j<grid[0].length;j++){
//
//            }
//        }
//    }
    //卧槽
    public int surfaceArea(int[][] grid) {
        int res = 0, n = grid.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                //先算出整体面积
                if (grid[i][j] > 0) res += grid[i][j] * 4 + 2;
                //前后相交的部分
                if (i > 0) res -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                //左右相交的部分
                if (j > 0) res -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
            }
        }
        return res;
    }
}
