package leetcode.leetcode1000_1499;

public class leet1320$ {


    //dp 记忆化dfs
    //从下往上开始遍历
 /*     public int minimumDistance(String word) {
      //26表示还没有开始放手指
     DFS(word,0,26,26);

     return dp[26][26][0]-1;
    }

    int dp[][][]=new int[27][27][301];
  int DFS(String word,int pos,int left,int right){
        //超过单词的长度 返回0
        if (pos >= word.length()) return 0;
        //若此处没有填
        if (dp[left][right][pos] == 0) {
            int to = word.charAt(pos)-'A';
            dp[left][right][pos] = Math.min(cost(left, to) + DFS(word, pos + 1, to, right),
                    cost(right, to) + DFS(word, pos + 1, left, to)) + 1;
        }
        return dp[left][right][pos] - 1;
       }*/
    int cost(int from, int to) {
        if (from == 26) return 0;
        return Math.abs(from / 6 - to / 6) + Math.abs(from % 6 - to % 6);
    }


    //不用递归
    //不太容易理解啊
    int minimumDistance(String word) {
        int dp[][][]=new int[301][27][27];
        for(int pos=word.length()-1;pos>=0;pos--){
           int to=word.charAt(pos)-'A';
           for(int i=0;i<27;i++){
               for(int j=0;j<27;j++){
                  // dp[pos][i][j]=Math.min(dp[pos+1][to][j]+cost(i,to),dp[pos+1][i][to]+cost(to,j));
                   dp[pos][i][j] = Math.min(dp[pos + 1][to][i] + cost(j, to), dp[pos + 1][to][j] + cost(i, to));
               }
           }
        }
        return dp[0][26][26];
    }
}
