package leetcode.leetcode1000_1499;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leet1443 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if(!map.containsKey(edges[i][0])) map.put(edges[i][0],new ArrayList<>());
            map.get(edges[i][0]).add(edges[i][1]);
        }
        dfs(map,0,0,hasApple);
        return res;
    }

    int res=0;
    boolean dfs(Map<Integer,List<Integer>> map,int step,int point, List<Boolean> hasApple){
        boolean flag=false;
        if(hasApple.get(point)){
            res+=step*2;
            flag=true;
        }

        if(map.containsKey(point)){
            for (Integer next : map.get(point)) {
                if(!flag){
                    flag|=dfs(map,step+1,next,hasApple);
                }else {
                    dfs(map,1,next,hasApple);
                }
            }
        }
        return flag;
    }
}
