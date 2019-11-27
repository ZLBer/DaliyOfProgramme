package leetcode.leetcode1000_;


public class leet1127$ {

    //额 数学问题
    //要理解正确意思：是第n个乘客在自己位置上的概率

   /* public double nthPersonGetsNthSeat(int n) {
        if(n==1) return 1.0;
        return  1.0/n+(n-2.0)/nthPersonGetsNthSeat(n-1);
    }*/



   //数学归纳法归纳出 f(n)=1/n+(n-2)/n*f(n-2)
    public double nthPersonGetsNthSeat(int n) {
       return n==1?1.0:1.5;
    }
}
