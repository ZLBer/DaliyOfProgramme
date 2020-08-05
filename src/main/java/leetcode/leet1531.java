package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leet1531 {
/*    public int getLengthOfOptimalCompression(String s, int k) {
       List<Character> list=new ArrayList<>();
       List<Integer> num=new ArrayList<>();

        int count=1;
        for (int i = 1; i < s.length(); i++) {
          if(s.charAt(i)==s.charAt(i-1)) count++;
          else {
              count=1;
          list.add(s.charAt(i-1));
              num.add(count);
          }
        }
        PriorityQueue<int []>priorityQueue=new PriorityQueue<>();

    }

    int min =Integer.MAX_VALUE;
   void dfs(  List<Character> list, List<Integer> num,boolean[]delte,int k,int length){

       if(k==0){
           min=Math.min(length,min);
           return;
       }
        for (int i = 0; i < delte.length; i++) {
           if(!delte[i]){
           delte[i]=true;
        dfs(list,num,delte);

           delte[i]=false;
           }
       }
   }*/


//四维dp  唉  不是一个量级
    Integer[][][][] dp;
    Set<Integer> add = new HashSet<>(Arrays.asList(1,9,99));//此时需要增加长度
    public int getLengthOfOptimalCompression(String s, int k) {
        int len = s.length();
        dp = new Integer[len + 1][27][len + 1][k + 1];
        return dfs(s, 0, (char) ('a' + 26), 0, k);
    }
    // idx, current index, p, previous char, cnt, previous char count, k, num of char removable
    private int dfs(String s, int idx, char p, int cnt, int k) {
        if (k < 0) return Integer.MAX_VALUE; //不合法的情况
        if (idx >= s.length()) return 0; //dfs到底了
        if (dp[idx][p - 'a'][cnt][k] != null) return dp[idx][p - 'a'][cnt][k];
        int res = 0;
        //和前一个字符相等
        if (s.charAt(idx) == p) res = dfs(s, idx + 1, p, cnt + 1, k) + (add.contains(cnt) ? 1 : 0);
        //不相等分两种情况，不删除 和 删除
        else res = Math.min(dfs(s, idx + 1, s.charAt(idx), 1, k) + 1, dfs(s, idx + 1, p, cnt, k - 1));
        dp[idx][p - 'a'][cnt][k] = res;
        return res;
    }



    //自己写一遍
 /*   public int getLengthOfOptimalCompression(String s, int k) {
   dp=new Integer[s.length()][27][s.length()][k+1];
        return dfs(s,0,(char)('a'+26),0,k);
    }
   Integer [][][][]dp;
   Set<Integer> set=new HashSet<>(Arrays.asList(1,9,99));
   int dfs(String s,int index,char p,int count,int k){
        if(k<0) return Integer.MAX_VALUE;
       if(index>=s.length()) return 0;
     if(dp[index][p-'a'][count][k]!=null) return dp[index][p-'a'][count][k];

     int res=0;
     if(s.charAt(index)==p) res=dfs(s,index+1,p,count+1,k)+(set.contains(count)?1:0);
     else {
        res=Math.min(dfs(s,index+1,s.charAt(index),1,k)+1,dfs(s,index+1,p,count,k-1));
     }
     return   dp[index][p-'a'][count][k]=res;

   }*/
}
