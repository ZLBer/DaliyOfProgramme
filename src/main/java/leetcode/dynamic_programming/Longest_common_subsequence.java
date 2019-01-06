package leetcode.dynamic_programming;

/**
 * Created by libin on 2017/9/16.
 */
public class Longest_common_subsequence {
    int Num=51;
    int c[][]=new int[Num][Num];
    int b[][]=new int[Num][Num];
    void LCSLength(int m,int n,char x[],char y[]){
        int i,j;
        for(i=1;i<=m;i++) c[i][0]=0;
        for(i=1;i<=m;i++) c[0][i]=0;

        for(i=1;i<=m;i++)
            for(j=1;j<=m;j++){
                if(x[i]==y[i])
                {
                    c[i][j]=c[i-1][j-1]+1;
                    b[i][j]=1;
                }
                else if(c[i-1][j]>=c[i][j-1]){
                    c[i][j]=c[i-1][j];
                    b[i][j]=2;
                }
                else {
                    c[i][j]=c[i][j-1];
                    b[i][j]=3;
                }
            }
    }
    void  LCS(int i,int j,char x[]){
        if(i==0||j==0)return;
        if(b[i][j]==1){
            LCS(i-1,j-1,x);
            System.out.println(x[i]);
        }
        else if(b[i][j]==2) LCS(i-1,j,x);
        else LCS(i,j-1,x);
    }
    public static void main(String args[]){
        Longest_common_subsequence a=new Longest_common_subsequence();
        char []x={'a','b'};
        char []y={'b','b'};
        a.LCSLength(1, 1, x, y);
        a.LCS(1, 1, x);
    }
}
