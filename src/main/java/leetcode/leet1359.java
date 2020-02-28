package leetcode;

public class leet1359 {

    //mine  不是很难  就是mod操作要注意点
    long mod=1000000000+7;
    public int countOrders(int n) {
        long pre=1;
        for(int i=1;i<n;i++){
            int count=i*2;
            pre=(pre*compute(count+1))%mod;
        }
        System.out.println(mod);
        System.out.println(pre);
        return (int)(pre%mod);
    }
    static int computeC(int a,int b){
        int up=1;
        int down=1;
        for(int i=1;i<=b;i++){
            up*=(a--);
            down*=(i);
        }

        return up/down;
    }

    static int compute(int n){
        int res=0;
        for(int i=1;i<=n;i++){
            res+=i;
        }
        return res;
    }

 //还可以更简单  其实道理一样  但计算更简单
/*    public int countOrders(int n) {
        long res = 1, mod = (long)1e9 + 7;
        for (int i = 1; i <= n; ++i)
            res = res * (i * 2 - 1) * i % mod;
        return (int)res;
    }*/

    public static void main(String[] args) {
        System.out.println(computeC(5,2));
    }
}
