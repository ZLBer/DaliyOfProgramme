package leetcode.华科复试;

/**
 * Created by libin on 2019/3/2.
 */
public class horseFuck {
    int [][] nextIncrese={
            {-1,-2 },
            {-2,-1 },
            {-2,1},
            {-1,2},
            {1,-2},
            {2,-1},
            {1,2},
            {2,1}
    };
    int count=0;//计数
    int method=0;//记录有多少种搜索方法
    int boardWidth=5; //棋盘宽度
    int boardLength=5;//棋盘长度
    int [][] isSearch=new int[5][5];  //记录是否搜索
     int  [][]attr=new int[5][5];
   void dfs(int m,int n,int step){
        for(int i=0;i<nextIncrese.length;i++ ){
           int x=m+nextIncrese[i][0];
          int  y=n+nextIncrese[i][1];
       //     System.out.println(x+"    "+y);
        //    System.out.println(count);
           if(x>=0&&y>=0&&x<boardWidth&&y<boardLength){
               if(isSearch[x][y]==1) continue;
               else {
                   isSearch[x][y]=1;
                   attr[x][y]=step;
                   count++;
                   if(count==boardLength*boardWidth)
                   {
                       sop(attr);
                       method++ ;
                       isSearch[x][y]=0;
                       count--;
                       return;
                   }

                   dfs(x,y,step+1);
                   isSearch[x][y]=0;
                   count--;
               }
           }
           else continue;
       }
    }
    private  void sop(int[][] arr) {
        for (int i = 0; i < boardWidth; i++) {
            for (int j = 0; j < boardWidth; j++) {
                System.out.print(arr[i][j] + " \t");}
            System.out.println(); } }

    public static void main(String[] args) {
      horseFuck horse=new horseFuck();
      horse.isSearch[0][0]=1;
      horse.count++;
      horse.attr[0][0]=1;
        horse.dfs(0,0,2);
        System.out.println(horse.method);
    }
}
