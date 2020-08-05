package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet1519 {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
    Map<Integer, List<Integer>> map=new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i,new ArrayList<>());
        }    
        for (int[] edge : edges) {
           map.get(edge[0]).add(edge[1]);
           map.get(edge[1]).add(edge[0]);
        }
       int []res=new int[n];
        boolean[]visied=new boolean[n];
            dfs(0,res,map,labels,visied);


       return res;
    }

   int[] dfs(int index,int []res, Map<Integer, List<Integer>> map,String labels,boolean []visited){

        visited[index]=true;
        int []letter=new int[26];
       for (Integer integer : map.get(index)) {
          int []newletter=new int[26];
           if(!visited[integer]){
              newletter= dfs(integer,res,map,labels,visited);
               for (int i = 0; i < letter.length; i++) {
                   letter[i]+=newletter[i];
               }

          }

       }

       letter[labels.charAt(index)-'a']++;
       res[index]+=(letter[labels.charAt(index)-'a']);
       return letter;
   }
}
