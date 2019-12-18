package leetcode;

public class leetc7 {
    public int maxSideLength(int[][] mat, int threshold) {

        int [][] row=new int[mat.length][mat[0].length];
     //   int [][]col=new int[mat.length][mat[0].length];
       //  int[][]dp=new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            int sum=0;
            for (int j = 0; j < mat[0].length; j++) {
                sum+=mat[i][j];
                row[i][j]=sum;
            }
        }

  /*      for (int i = 0; i < mat[0].length; i++) {
            int sum=0;
            for (int j = 0; j < mat.length; j++) {
                sum+=mat[j][i];
                col[j][i]=sum;
            }
        }*/

    /*    for (int i = 0; i < mat.length; i++) {
            if(mat[0][i]<=threshold) dp[0][i]=1;
        }
        for (int i = 0; i < mat[0].length; i++) {
            if(mat[i][0]<=threshold) dp[i][0]=1;
        }*/


       int length=Math.min(mat[0].length,mat.length);
       for(;length>1;length--){
          for(int r=0;r+length<=mat.length;r++){
              for(int c=0;c+length<=mat[0].length;c++){
                   int rowBegin=r,rowEnd=r+length-1;
                   int colBegin=c,colEnd=c+length-1;
                  if(cost(row,rowBegin,rowEnd,colBegin,colEnd)<=threshold)
                      return length;
              }
          }
       }
return 0;
        
    }

    int cost(int [][]row,int rowBegin,int rowEnd,int colBegin,int colEnd){
        int sum=0;
     for(int i=rowBegin;i<=rowEnd;i++){
         if(colBegin==0) sum+=row[i][colEnd];
        else  sum+=(row[i][colEnd]-row[i][colBegin-1]);
     }
     return sum;
    }
}
