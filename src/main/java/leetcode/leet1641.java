package leetcode;

public class leet1641 {
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }


        for (int i = 1; i < n; i++) {
            int[] nd = new int[5];
            nd[0] = dp[0];
            nd[1] = dp[0] + dp[1];
            nd[2] = dp[0] + dp[1] + dp[2];
            nd[3] = dp[0] + dp[1] + dp[2] + dp[3];
            nd[4] = dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
            dp = nd;
        }
        int re = 0;
        for (int i : dp) {
            re += i;
        }
        return re;
    }


    //排列组合  n个小球放到m(这里是5)个桶里，可以为空；
/*
    public int countVowelStrings(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }*/
}
