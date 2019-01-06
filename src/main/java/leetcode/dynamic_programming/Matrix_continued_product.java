package leetcode.dynamic_programming;

/**
 * Created by libin on 2017/9/16.
 */
public class Matrix_continued_product {
    int Num=51;
    int []p={50,10,40,30,5,20,15};
    int [][]m=new int[Num][Num];
    int [][]s=new int[Num][Num];
    void MatixChain(int n){

        for(int i=1;i<=n;i++) m[i][i]=0;
        for(int r=2;r<=n;r++){
            for(int i=1;i<=n-r+1;i++){
                int j=i+r-1;
                m[i][j]=m[i+1][j]+p[i-1]*p[i]*p[j];
                s[i][j]=i;
                for(int k=i+1;k<j;k++){
                    int t=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                    if(t<m[i][j]){
                        m[i][j]=t;
                        s[i][j]=k;
                    }
                }

            }
        }
    }
    void TracBack(int i,int j){
        if(i==j) System.out.print("A"+i);
        else{
            System.out.print("(");
            TracBack(i,s[i][j]);
            TracBack(s[i][j]+1,j);
            System.out.print(")");
        }
    }
    public static void main(String args[]){
        Matrix_continued_product s=new Matrix_continued_product();
        s.MatixChain(6);
//	for(int i=1;i<=6;i++)
//		for(int j=1;j<=6;j++)
//			System.out.println(s.m[i][j]);
        s.TracBack(1, 6);
    }
}
