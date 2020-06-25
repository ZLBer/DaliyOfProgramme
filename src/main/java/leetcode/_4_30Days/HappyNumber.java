package leetcode._4_30Days;

public class HappyNumber {
    //mine
/*    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while (true) {
            set.add(n);
            int tn = 0;
            while (n > 0) {
                tn += (n % 10) * (n % 10);
                n = n / 10;
            }
            if(tn==1) return true;
            if(set.contains(tn)) return false;
            n=tn;
        }
    }
    */

    //递归也太秀了
/*    public boolean isHappy(int n) {
        if(n == 1 || n == 7) return true;
        else if(n < 10) return false;
        int m = 0;
        while(n != 0){
            int tail = n % 10;
            m += tail * tail;
            n = n/10;
        }
        return isHappy(m);
    }*/



    int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n>0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow); //慢指针一次一个
            fast = digitSquareSum(fast); //快指针一次挑两个
            fast = digitSquareSum(fast);
        } while(slow != fast);
        if (slow == 1) return true;
        else return false;
    }
}
