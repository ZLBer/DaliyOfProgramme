package leetcode;

public class leet441 {
   /* public int arrangeCoins(int n) {
   int result=1;
   while (n>=result){
       n-=result;
       result++;
   }
   return result-1;
    }*/

  //直接用数学方法解
    public int arrangeCoins(int n) {
        //转成long防止溢出
        return (int)(Math.sqrt(8*(long)n+1)/2-0.5);


    }
}
