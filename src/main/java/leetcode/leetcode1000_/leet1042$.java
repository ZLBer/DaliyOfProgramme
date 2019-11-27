package leetcode.leetcode1000_;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leet1042$ {
    //用贪心做
    public int[] gardenNoAdj(int N, int[][] paths) {
        //把每个点的邻接点找出来
        Map<Integer, Set<Integer>> G = new HashMap<>();
        for (int i = 0; i < N; i++) G.put(i, new HashSet<>());
        for (int[] p : paths) {
            G.get(p[0] - 1).add(p[1] - 1);
            G.get(p[1] - 1).add(p[0] - 1);
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            int[] colors = new int[5];
            //遍历i的每个邻居，若该邻居已经涂色，则标记
            for (int j : G.get(i))
                colors[res[j]] = 1;
            //找出一个没有图的颜色  一定可以有一个颜色可以涂
            for (int c = 4; c > 0; --c)
                if (colors[c] == 0)
                    res[i] = c;
        }
        return res;
    }
/*  public int[] gardenNoAdj(int N, int[][] paths) {
      Map<Integer,Set<Integer>> map=new HashMap<>();
      for(int i=0;i<N;i++) map.put(i,new HashSet<>());
      for(int []p:paths){
          map.get(p[0]-1).add(p[1]-1);
          map.get(p[1]-1).add((p[0]-1));
      }
  int []res=new int[N];
      for(int i=0;i<N;i++){
        int []colors=new int[5];
         for(int j:map.get(i))
             colors[res[j]]=1;
         for(int c=4;c>0;c--){
             if(colors[c]==0)
                 res[i]=c;
         }

      }
        return res;
    }*/
}
