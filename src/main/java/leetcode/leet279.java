package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet279 {
    //mine DFS 适合于最短问题
/*   static public int numSquares(int n) {

       Queue<Integer> queue=new LinkedList<>();
       queue.offer(n);
       int deep=0;
       while (!queue.isEmpty()) {
           int size = queue.size();
           deep++;
           while (size-- > 0) {
               int remaind=queue.poll();
               int max = (int) Math.sqrt(remaind);
               for (int i = 1; i <= max; i++) {
                   int sqare = i * i;
                   if(remaind==sqare) return deep;
                   queue.offer(remaind-sqare);
               }
           }
       }
      return 0;
    }*/


 //DP  看了一眼写出来的  求所有min（i-平方）
   /* static public int numSquares(int n) {


     int[] dp=new int[n+1];
       for(int i=1;i<=n;i++){
       int min=Integer.MAX_VALUE;
       int Max=(int)Math.sqrt(i);
       for(int j=1;j<=Max;j++){
            min=Math.min(min,dp[i-j*j]+1);
       }
       dp[i]=min;
       }
        return dp[n];
    }*/



// 发现一个骚操作  Static DP ，所有的测试用例都用这个变量
    static List<Integer> result = new ArrayList<>();
    public int numSquares(int n) {
        if (result.size() == 0) {
            result.add(0);
        }
        while (result.size() <= n) {
            int m = result.size();
            int tempMin = Integer.MAX_VALUE;
            for (int j = 1; j * j <= m; j++) {
                tempMin = Math.min(tempMin, result.get(m - j * j) + 1);
            }
            result.add(tempMin);
        }
        return result.get(n);
    }


    //Todo：Lagrange's Four Square theorem

    public static void main(String[] args) {
        System.out.println(1<<30);
    }
}
