package leetcode;

public class leet1573 {

    //mine
/*  static   public int numWays(String s) {
      char []arr=s.toCharArray();
      int one=0;
      for (int i = 0; i < arr.length; i++) {
            if(arr[i]=='1')one++;
        }

    if(one%3!=0) return 0;

    if(one==0){
       return  (int)combination(2,s.length()-1);
    }
    int count=one/3;

    long res=1;


       int ans=0;
       int c=0;
        for (int i = 0; i < arr.length&&c<2; i++) {
            if (arr[i] == '1') {
                ans++;
                if (ans == count) {
                    int zero = 0;
                    for (int j = i + 1; j < arr.length; j++) {
                        if (arr[j] == '0') zero++;
                        else {
                            break;
                        }

                    }
                    res = (res*(zero+1))%1000000007;
                ans=0;
                c++;
                }
            }
            else {
                continue;
            }
        }


        return (int)res;
    }
    static long combination(int small,int great ) {
        int a = 1;
        int b = great;
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 0; i < small; i++) {
            res = res.multiply(BigInteger.valueOf(b)).divide(BigInteger.valueOf(a));
            b--;
            a++;
        }
        res = res.remainder(BigInteger.valueOf(1000000007));
        return res.longValue();
    }*/



//唉  怎么还写不出这么简洁的code
    private static final int m = 1_000_000_007;
    public int numWays(String s) {
        int ones = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            ones += s.charAt(i) - '0';
        }
        if (ones == 0) {
            return (int) ((n - 2L) * (n - 1L) / 2 % m);
        }
        if (ones % 3 != 0) {
            return 0;
        }
        int onesInEachSplitedBlock = ones / 3;
        long waysOfFirstCut = 0, waysOfSecondCut = 0;
        for (int i = 0, count = 0; i < n; ++i) {
            count += s.charAt(i) - '0';
            if (count == onesInEachSplitedBlock) {
                ++waysOfFirstCut;
            } else if (count == 2 * onesInEachSplitedBlock) {
                ++waysOfSecondCut;
            }
        }
        return (int) (waysOfFirstCut * waysOfSecondCut % m);

    }
        public static void main(String[] args) {
      //  numWays("100100010100110");
    }
}
