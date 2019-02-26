package leetcode;

/**
 * Created by libin on 2019/2/25.
 */
public class leet733 {
    //DFS
    int [][]result;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       result=image;
helper(sr,sc,newColor,result[sr][sc]);
return result;

    }


    void helper(int i,int j,int newColor,int color){
         if(result[i][j]==color) result[i][j]=newColor;
         else  return;
         if(i-1>=0) helper(i-1,j,newColor,color);
         if(j-1>=0) helper(i,j-1,newColor,color);
         if(i+1<result.length) helper(i+1,j,newColor,color);
         if(j+1<result[0].length) helper(i,j+1,newColor,color);
    }

    public static void main(String[] args) {
         leet733 leet=new leet733();
         leet.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}},1,1,2);
    }


    //思路一样
   /* public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }*/
}
