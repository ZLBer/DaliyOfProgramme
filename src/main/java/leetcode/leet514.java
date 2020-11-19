package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet514 {
    Integer[][]memo;
    public int findRotateSteps(String ring, String key) {
        List<Integer>[]  arr=new List[26];
        memo = new Integer[key.length()][ring.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=new ArrayList<>();
        }
        for (int i = 0; i < ring.length(); i++) {
            arr[ring.charAt(i)-'a'].add(i);
        }
        return  heler(0,0,ring,key,arr);
    }


    int heler(int keyIndex,int ringIndex,String ring,String key,List<Integer>[]arr){

        if(keyIndex>=key.length()) return 0;//无了


        if(memo[keyIndex][ringIndex]!=null) return memo[keyIndex][ringIndex];
        if(ring.charAt(ringIndex)==key.charAt(keyIndex)){
            return heler(keyIndex+1,ringIndex,ring,key,arr)+1;
        }

        int min=Integer.MAX_VALUE;

        for(int i:arr[key.charAt(keyIndex)-'a']){
            min=Math.min(min,heler(keyIndex+1,i,ring,key,arr)+getLen(ringIndex,i,ring.length()));
        }

        return memo[keyIndex][ringIndex]=min;

    }


    int getLen(int i,int j,int len){
        int min =Math.min(i,j),max=Math.max(i,j);
        i=min;j=max;
        int res= Math.min(Math.abs(j-i),i+len-j)+1;
        // System.out.println(i+" "+j+" "+len+" "+res);

        return res;
    }


    //直接dp ，其实会了dfs这个也不难了
 /*   public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; ++i) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }*/




    public static void main(String[] args) {
     //   findRotateSteps("abcde","ade");
    }


}
