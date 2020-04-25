package leetcode._30Days;

public class leet1 {
    public int minCount(int[] coins) {
    int res=0;
        for (int i = 0; i < coins.length; i++) {
            res+=(coins[i]+1)/2;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println("test");
    }
}
