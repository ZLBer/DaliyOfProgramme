package leetcode.leetcode1000_;

public class leet1317 {
    public int[] getNoZeroIntegers(int n) {

        for(int i=1;i<n;i++){
             if(check(i+"")&&check(n-i+"")) return new int[]{i,n-i};
        }
        return null;
    }
    boolean check(String s){
        for(char c:s.toCharArray()){
            if(c=='0') return false;
        }
        return true;
    }

    //可以用contains函数
/*    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;
            if (!String.valueOf(a).contains("0") && !String.valueOf(b).contains("0"))
                return new int[]{a, b};
        }
        return new int[]{}; // unreachable because at least one valid solution
    }*/
}
