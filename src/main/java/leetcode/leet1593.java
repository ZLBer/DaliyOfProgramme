package leetcode;

import java.util.HashSet;
import java.util.Set;

public class leet1593 {
   static public int maxUniqueSplit(String s) {
  return dfs(s,0,new HashSet<>());
    }
  static int dfs(String s, int index, Set<String> set){
    if(index>=s.length()) return 0;
    int max=-1;
    for(int i=index;i<s.length();i++){
        String key=s.substring(index,i+1);
        if(!set.contains(key)){
            set.add(key);
            max=Math.max(max,dfs(s,i+1,set)+1);
           set.remove(key);
        }
    }
    return max;
   }

    public static void main(String[] args) {
        maxUniqueSplit("ababccc");
    }
}
