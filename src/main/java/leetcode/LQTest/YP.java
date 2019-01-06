package leetcode.LQTest;

/**
 * Created by libin on 2018/3/29.
 */
public class YP {
  static   int length=4;
  static   int width=3;
  static  int [][]board={
          {1,2,3,4},
          {5,6,7,8},
          {9,10,11,12}
  };
    static  int [][]IS=new int[width][length];
    static int count=0;
    static  int sum=0;
    static  boolean []result=new boolean[12*5];
   static void  DFS(int x,int y){
       if(x<0||x>=width||y<0||y>=length) return;
       if(IS[x][y]==1) return;
       IS[x][y]=1;
       System.out.println(x+ "  "+y);
        count++;
        if(count==5) {
           for(int i=0;i<IS.length;i++){
               for(int j=0;j<IS[0].length;j++){
                if(IS[i][j]==1) sum+=board[i][j];
               }
           }
           result[sum]=true;
            sum=0;
            return;
        }
       DFS(x+1,y);
       DFS(x-1,y);
       DFS(x,y-1);
       DFS(x,y+1);

       IS[x][y]=0;
       count--;
   }

    public static void main(String[] args) {
       int counts =0;
       for(int i=0;i<width;i++){
           for(int j=0;j<length;j++){
               DFS(i,j);
           }
       }
        for(boolean a:result){
            if(a) counts++;
        }
        System.out.println(counts);
    }
}
