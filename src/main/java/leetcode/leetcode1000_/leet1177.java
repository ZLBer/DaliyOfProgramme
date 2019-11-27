package leetcode.leetcode1000_;

import java.util.ArrayList;
import java.util.List;

public class leet1177 {
   /* public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][]prefix=new int[s.length()+1][26];
        for (int i = 0; i < s.length(); i++) {
            prefix[i+1]=prefix[i].clone();
            prefix[i+1][s.charAt(i)-'a']++;
        }

        List<Boolean> result=new ArrayList<>();

        for(int []query:queries){
       int sum=0;
        for(int i=0;i<26;i++){
         sum+=(prefix[query[1]+1][i]-prefix[query[0]][i])%2;
        }
       if(sum/2<=query[2])
           result.add(true);
       else result.add(false);

        }
        return result;
    }*/




   //位操作 -异或
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        int[] odds = new int[s.length() + 1]; // odds[i]: within range [0...i) of s, the jth bit of odd[i] indicates even/odd of the count of (char)(j + 'a').
        for (int i = 0; i < s.length(); ++i)
            odds[i + 1] = odds[i] ^ (1 << s.charAt(i) - 'a');
        for (int[] q : queries)
            ans.add(Integer.bitCount(odds[q[1] + 1] ^ odds[q[0]]) / 2 <= q[2]); // odds[q[1] + 1] ^ odds[q[0]] indicates the count of (char)(i + 'a') in substring(q[0], q[1] + 1) is even/odd.
        return ans;
    }
}
