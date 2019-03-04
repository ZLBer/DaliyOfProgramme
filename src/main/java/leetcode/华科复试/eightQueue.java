package leetcode.华科复试;

/**
 * Created by libin on 2019/3/3.
 */
public class eightQueue {
   int N=8;
   int count=0;
   int result=0;
int [][]board=new  int[N][N];


 /* int solution(){
    for(int i=0;i<N;i++){
        count++;
        board[i][0]=1;
        dfs(i,0);
        board[i][0]=0;
        count--;
    }
    return result;
    }

    void dfs(int x,int y){
        if(y>=N-1){
            result++;
            return;
        }

        for(int i=0;i<N;i++){
            if(canSet(i,y+1)){
                count++;
                board[i][y+1]=1;


                dfs(i,y+1);
                count--;
                board[i][y+1]=0;
            }
        }

    }*/



    public static void main(String[] args) {
        eightQueue eight=new eightQueue();
        System.out.println(eight.solution());

    }



    int solution(){
        for(int i=0;i<N;i++){
            dfs(i,0);
        }
        return result;
    }

    void dfs(int x,int y){
        if(canSet(x,y)) {
            count++;
            board[x][y]=1;
            if(count==N){
                result++;
                count--;
                board[x][y]=0;
                return;
            }

        }else  return;
        for(int i=0;i<N;i++){
                dfs(i,y+1);
        }
        count--;
        board[x][y]=0;
    }
    boolean canSet(int x,int y){
        //横竖
        for(int i=0;i<N;i++){
            if(board[x][i]==1) return false;
            if(board[i][y]==1) return false;

        }

        //斜线
 //左上斜线
        int tx=x-1;
        int ty=y-1;
         while (tx>=0&&ty>=0){
             if(board[tx][ty]==1) return false;
             tx--;
             ty--;
         }

         //右下下斜线
         tx=x+1;
         ty=y+1;
        while (tx<N&&ty<N){
            if(board[tx][ty]==1) return false;
            tx++;
            ty++;
        }

        //右上斜线
   tx=x-1;
        ty=y+1;
        while (tx>=0&&ty<N){
            if(board[tx][ty]==1) return false;
            tx--;
            ty++;
        }

        //左下斜线
        tx=x+1;
        ty=y-1;
        while (tx<N&&ty>=0){
            if(board[tx][ty]==1) return false;
            tx++;
            ty--;
        }



        return true;

    }
}
