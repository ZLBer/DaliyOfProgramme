package leetcode.leetcode1000_1499;

import java.util.Arrays;

public class leet1467$ {


    //mine  TLE
/*
   static public double getProbability(int[] balls) {
        int sum=0;
        for (int ball : balls) {
            sum+=ball;
        }
        return dfs(0,0,new HashMap<>(),new HashMap<>(),sum/2,balls,0)/helper(sum,sum/2);
    }
    static double helper(int a,int b){
      double up=1;
         for (int i = 0; i < b; i++) {
            up*=(a--);
         }
       double down=1;
         for (int i = 1; i <= b; i++) {
             down*=i;
         }
       return up/down;
     }
  static   int dfs(int countA, int countB, Map<Integer,Integer> capA, Map<Integer,Integer> capB, int n, int []balls,int index){
        if(balls[index]==0)index++;
          if(countA==n){
        Map<Integer,Integer> newB=new HashMap<>(capB);
              for (int i = index; i < balls.length; i++) {
                if(!newB.containsKey(i)) newB.put(i,1);
              } 
          if(newB.size()==capA.size()) return 1;
          else return 0;

          }

         if(countB==n){
             Map<Integer,Integer> newA=new HashMap<>(capA);
             for (int i = index; i < balls.length; i++) {
                 if(!newA.containsKey(i)) newA.put(i,1);
             }
             if(newA.size()==capB.size()) return 1;
             else return 0;
         }

        int p=0;



         int color=index;

         if(capA.containsKey(color)){

             capA.put(color,capA.get(color)+1);
         }else {
            capA.put(color,1);
         }
         balls[index]--;
         p+=dfs(countA+1,countB,capA,capB,n,balls,index);//分配给A

        int c=capA.get(color);

        if(c==1) capA.remove(color);
        else {
            capA.put(color,c-1);
        }




        if(capB.containsKey(color)){

            capB.put(color,capB.get(color)+1);
        }else {
            capB.put(color,1);
        }

        p+=dfs(countA,countB+1,capA,capB,n,balls,index);

        c=capB.get(color);

        if(c==1) capB.remove(color);
        else {
            capB.put(color,c-1);
        }


        balls[index]++;


        return p;
    }

    public static void main(String[] args) {
        System.out.println(helper(6,3));
    }*/



  //把一种颜色为单位进行dfs
    double[] dp = new double[100];
    public double getProbability(int[] balls) {
        dp[0] = 1;
        int sum = Arrays.stream(balls).sum();
        for (int i = 1; i < 100; i++) dp[i] = dp[i - 1] * i; //this is for calculate C(a, b) as explained in helper method
        double validNumber = dfs(0, 0, 0, 0, balls, 0);
        double totalNumber = combination(sum, sum / 2);   //how many different ways we can pick sum / 2 balls from sum
        return validNumber / totalNumber;
    }

    //count means the numebr of distinguish balls in one box, sum means total balls in one box
    private double dfs(int count1, int count2, int sum1, int sum2, int[] balls, int i) {
        if (i == balls.length) return (sum1 == sum2 && count1 == count2) ? 1 : 0;
        double res = dfs(count1 + 1, count2, sum1 + balls[i], sum2, balls, i + 1);  //全部给a
        res += dfs(count1, count2 + 1, sum1, sum2 + balls[i], balls, i + 1);//全部给b
        for (int j = 1; j < balls[i]; j++) //分着给
            res += combination(balls[i], j) * dfs(count1 + 1, count2 + 1, sum1 + j, sum2 + balls[i] - j, balls, i + 1);
        return res;
    }

    //combination way to calculate pick b from a: C(a, b), eg C(4, 2) = dp[4] / dp[2] / dp[4 - 2] = 6
    private double combination(int a, int b) {
        return dp[a] / dp[b] / dp[a - b];
    }

}
