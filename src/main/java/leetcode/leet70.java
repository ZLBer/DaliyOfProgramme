package leetcode;

/**
 * Created by libin on 2019/1/9.
 */
public class leet70 {
    //斐波那契数列
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int c1=1,c2=2,c=0;
        for(int i=3;i<=n;i++){
         //   System.out.println(c1+"      "+c2);
             c=c1+c2;
             c1=c2;
            c2=c;

          //  System.out.println(c2);
        }
        return c2;
    }
}
