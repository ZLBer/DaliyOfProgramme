package leetcode;

/**
 * Created by libin on 2019/1/9.
 */
public class leet509 {
    public int fib(int N) {
        if(N==0) return 0;
        if(N==1) return 1;
       int c1=0,c2=1,c=0;
       for(int i=1;i<=N;i++){
           c=c1+c2;
           c1=c2;
           c2=c;

        }
       return  c1;
    }
}
