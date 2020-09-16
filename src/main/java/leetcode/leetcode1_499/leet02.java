package leetcode.leetcode1_499;

import java.util.HashSet;
import java.util.Set;

public class leet02 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Set<Integer> res=new HashSet<>();

        Set<String> set=new HashSet<>();
        for (int i = 0; i < pairs.length; i++) {
            set.add(pairs[i][0]+"-"+pairs[i][1]);
            set.add(pairs[i][1]+"-"+pairs[i][0]);
        }
        for (int i = 0; i < pairs.length; i++) {
         int  x=pairs[i][0],y=pairs[i][1];
         if(check(x,y,preferences,set)){
             res.add(x);
         }
         if(check(y,x,preferences,set)){
             res.add(y);
         }
        }
        return res.size();
    }

   boolean check(int x,int y,int[][]preferences ,Set<String> set){
       for (int i = 0; i < preferences[x].length; i++) { //x的朋友列表
          if(preferences[x][i]==y) return  false;
         int u=preferences[x][i]; //寻找u的朋友v

           int indexX=0;
           for (int j = 0; j < preferences[u].length; j++) {
              if(preferences[u][j]==x) break;
              indexX=j;
           }
         for(int j=indexX+1;j<preferences[u].length;j++){
             int v=preferences[u][j];
            if(set.contains(u+"-"+v)) return true;
         }
       }
       return false;
   }
}
