package leetcode.leetcode500_999;

public class leet837$ {

    //回溯超时
/*    public double new21Game(int N, int K, int W) {
        return helper(1.0,N,K,W);
    }


    double helper(double probability,int N,int K,int W){

        if(K<=0){
            if(N>=0)
                return probability;
            else return 0;
        }

        double res=0;
        double p=1.0/W;
        for (int i = 1; i <= W; i++) {
            res+=helper(probability*p,N-i,K-i,W);
        }


        return res;
    }*/




//记忆化搜索也超时了啊
/*
public double new21Game(int N, int K, int W) {
    p=1.0/W;
    return helper(N,K,W);
}
    double p;
    Map<String,Double> map=new HashMap<>();
    double helper(int N,int K,int W){
        String s=N+"|"+K;

        if(map.containsKey(s)) {
            return map.get(s);
        }
        if(K<=0){
            if(N>=0){
                return 1.0;
            }

            else {
                return 0;
            }
        }


        double res=0;

        for (int i = 1; i <= W; i++) {
            res+=p*helper(N-i,K-i,W);
        }
        map.put(s,res);
        return res;
    }
*/




//从后往前考虑  绝了..
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[K + W];
        double sum = 0.0;
        for (int i = K; i < K + W; i++) {
            dp[i] = (i <= N ? 1.0 : 0.0);
            sum += dp[i];
        }
        for (int i = K-1; i > -1; i--) {
            dp[i] = sum / W;
            sum = sum - dp[i + W] + dp[i];
        }
        return dp[0];
    }


    public static void main(String[] args) {
      //  System.out.println(new21Game(1,1,2));
    }
}
