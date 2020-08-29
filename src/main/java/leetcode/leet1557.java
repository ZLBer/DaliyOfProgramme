package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet1557 {

    //mine做了很多无用功
 /*   public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        Map<Integer,List<Integer>> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            map.get(edge.get(1)).add(edge.get(0));
        }
        List<Integer> res=new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            if(integerListEntry.getValue().size()==0){
             res.add(integerListEntry.getKey());
            }
        }
        return res;
    }*/


    //直接统计入度即可
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] nums=new int[n];
        for(List li:edges){
            ++nums[(int)li.get(1)];
        }
        List<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<n;++i){
            if(nums[i]==0){
                l.add(i);
            }
        }
        return l;
    }

}
