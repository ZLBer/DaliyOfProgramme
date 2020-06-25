package leetcode._5_30Days;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
     int srcColoer=image[sr][sc];
    if(srcColoer==newColor) return image;
   dfs(image,sr,sc,srcColoer,newColor);
   return image;
    }

    int [][]next=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
   void  dfs(int [][]image,int r,int c,int srcColor,int newColor){
       if(image[r][c]==srcColor){
           image[r][c]=newColor;
       }else {
          return;
       }


       for (int i = 0; i < next.length; i++) {
          int nextR=r+next[i][0];
          int nextC=c+next[i][1];
          if(nextR>=0&&nextR<image.length&&nextC>=0&&nextC<image[0].length){
              dfs(image,nextR,nextC,srcColor,newColor);
          }
       } 
   }
}
