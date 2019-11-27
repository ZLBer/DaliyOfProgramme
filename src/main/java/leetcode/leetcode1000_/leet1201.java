package leetcode.leetcode1000_;

public class leet1201 {

    //TLE
//    public int nthUglyNumber(int n, int a, int b, int c) {
//        int index=1;
//        while (n>0){
//            if(index%a==0||index%b==0||index%c==0)
//                n--;
//            index++;
//        }
//        return --index;
//    }
    //辗转相除法求最大公约数
    long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    //求最小公倍数
    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    int count(int num, int a, int b, int c) {
        return (int) (num / a + num / b + num / c
                - num / lcm(a, b)
                - num / lcm(b, c)
                - num / lcm(a, c)
                + num / (lcm(a, lcm(b, c))));
    }
    public int nthUglyNumber(int n, int a, int b, int c) {
        int left=0,right=Integer.MAX_VALUE;
        int result=0;

        while (left<=right){
            //int mid=(left+right)/2;// 会溢出
          int  mid= left + (right - left) / 2; //防止溢出
            if(count(mid,a,b,c)>=n){
               result=mid;
               right=mid-1;//为了让他最接近
            }
            else {
                left=mid+1;
            }
        }

        return result;
    }
}
