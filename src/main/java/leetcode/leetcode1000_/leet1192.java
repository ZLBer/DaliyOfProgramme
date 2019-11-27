package leetcode.leetcode1000_;

import java.util.*;

public class leet1192 {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        int []count=new int[n];
        for(List<Integer> list:connections){
            int a= list.get(0);
            int b=list.get(1);
           if(!map.containsKey(a)) map.put(a,new ArrayList<>());
           if(!map.containsKey(b)) map.put(b,new ArrayList<>());
           map.get(a).add(b);
           map.get(b).add(a);
           count[a]++;
           count[b]++;
         }
        List<List<Integer>> result=new ArrayList<>();
        Set<String> set=new HashSet<>();
        for (int i = 0; i < count.length; i++) {
            int a=i;
            int b=map.get(i).get(0);
            System.out.println(count[i]);
            if(count[i]==1&&!set.contains(a+""+b)){
                List<Integer> temp=new ArrayList<>();
                temp.add(i);
                temp.add(b);
                result.add(temp);
                set.add(a+""+b);
                set.add(b+""+a);
            }

        }

        return result;
    }
}
