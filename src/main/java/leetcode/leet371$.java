package leetcode;

/**
 * Created by libin on 2019/2/24.
 */
public class leet371$ {
    //haha
   /* public int getSum(int a, int b) {
        return a+b;
    }*/


   //not really understand
    
    /*  
     *    
   　对于二进制的加法运算，若不考虑进位，则1+1=0,1+0=1,0+1=1,0+0=0,通过对比异或，不难发现，此方法与异或运算类似。因而排出进位，
   加法可用异或来实现。然后考虑进位，0+0进位为0,1+0进位为0,0+1进位为0，1+1进位为1，该操作与位运算的&操作相似。

　　那么加法运算可以这样实现：

　　1）先不考虑进位，按位计算各位累加（用异或实现），得到值a；

　　2）然后在考虑进位，并将进位的值左移，得值b，若b为0，则a就是加法运算的结果，若b不为0，则a+b即得结果（递归调用该函数）。
     */  
    public int getSum(int a, int b) {
        if(b==0)
            return a;
        int sum = a^b;
        int carry =(a&b)<<1;
        return getSum(sum,carry);
    }
}
