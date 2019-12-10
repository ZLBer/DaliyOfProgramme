package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetc4 {
    public int palindromePartition(String s, int k) {
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
    }


}
