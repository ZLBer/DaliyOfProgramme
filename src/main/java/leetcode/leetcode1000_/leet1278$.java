package leetcode.leetcode1000_;

import java.util.HashMap;
import java.util.Map;

public class leet1278$ {
    //mine 时间复杂度通不过
/*    public int palindromePartition(String s, int k) {
        DFS(s,0,0,0,k);
        return min;
    }
    int min=Integer.MAX_VALUE;
    void DFS(String s,int cur,int cost,int deep,int k){
        if(cur>=s.length()){
            min=Math.min(min,cost);
            return;
        }
        //剪枝
        if(cost>=min) return;
        if(deep>=k) return;

        for(int i=cur;i<s.length();i++){
             int c=check(s.substring(cur,i+1));
             DFS(s,i+1,cost+c,deep+1,k);
        }
    }
    Map<String,Integer> set=new HashMap<>();
    int check(String s){
        int res=0;
        if(set.containsKey(s)) return set.get(s);
      for(int i=0;i<s.length()/2;i++){
          if(s.charAt(i)!=s.charAt(s.length()-i-1)) res++;
       }
      set.put(s,res);
      return res;
    }*/

     // 动态规划

  public int palindromePartition(String s, int k) {
        if (s.length() == k) return 0;
        int len = s.length();
        int[][] dp = new int[k][len + 1];
        for (int i = 0; i < len; ++i){
            //表示不分割需要替换的数目
            dp[0][i + 1] = helper(s.substring(0, i + 1));
        }
        for (int i = 1; i < k; ++i){
            for (int j = i; j <= len; ++j){
                int cur = Integer.MAX_VALUE;
                // p >= i 保证前面至少偶i个字符 ，保证合法性
                for (int p = j; p >= i; p--){
                    //i-1表示要占用一个分分割给 helper(s.substring(p - 1,j )用
                    //然后在遍历从p到j (p--) ,得到最小，然后加上后边的一个串  求局部最小
                    cur = Math.min(cur, dp[i - 1][p - 1] + helper(s.substring(p - 1,j )));
                }
                //赋值
                dp[i][j] = cur;
            }
        }
        return dp[k - 1][len];
    }

    //求需要换几个字符 并缓存一下
 Map<String, Integer> map = new HashMap<>();
    private int helper(String str){
        if (str == null || str.length() == 0) return 0;
        if (map.containsKey(str)) return map.get(str);
        int res = 0;
        for (int i = 0; i < str.length(); ++i){
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) res++;
        }
        res /= 2;
        map.put(str, res);
        return res;
    }

/*    public int palindromePartition(String s, int k) {
        int [][]dp=new int[k][s.length()+1];

        for(int i=1;i<=s.length();i++){
            dp[0][i]=helper(s.substring(0,i));
        }

        for(int i=1;i<k;i++){
            for(int j=i;j<=s.length();j++){
                int cur=Integer.MAX_VALUE;
                for(int p=j;p>=i;p--){
                    cur=Math.min(cur,dp[i-1][p-1]+helper(s.substring(p-1,j)));
                }
            dp[i][j]=cur;
            }
        }
        return dp[k-1][s.length()];
    }*/
}
