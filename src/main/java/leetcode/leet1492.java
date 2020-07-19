package leetcode;

public class leet1492 {
/*    public int kthFactor(int n, int k) {

        int i=1;
        for (; i <= n; i++) {
            if(n%i==0) k--;
            if(k==0)return i;
        }
        return -1;
    }*/



    //更具对称性求因子
    int kthFactor(int n, int k) {
        int d = 1;
        for (; d * d <= n; ++d)
            if (n % d == 0 && --k == 0)
                return d;
        for (d = d - 1; d >= 1; --d) {
            if (d * d == n)
                continue;
            if (n % d == 0 && --k == 0)
                return n / d;
        }
        return -1;
    }

    public static void main(String[] args) {
     //   kthFactor(4,4);
    }
}
