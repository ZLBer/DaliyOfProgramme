package leetcode.leetcode1000_1499;

import java.util.*;

public class leet1418 {
    //mine
    public List<List<String>> displayTable(List<List<String>> orders) {
  Map<Integer, Map<String,Integer>> map=new TreeMap<>(Comparator.reverseOrder());
  Set<String> set=new TreeSet<>();
        for (List<String> order : orders) {
            set.add(order.get(2));
            if(!map.containsKey(Integer.parseInt(order.get(1)))) map.put(Integer.parseInt(order.get(1)),new HashMap<>());
            Map<String,Integer> m=map.get(Integer.parseInt(order.get(1)));
            m.put(order.get(2),m.getOrDefault(order.get(2),0)+1);
         }

       List<List<String>> res=new ArrayList<>();
        List<String> list=new ArrayList<>();
        list.add("Table");
        for (String s : set) {
            list.add(s);
        }
        res.add(list);

        for (Map.Entry<Integer, Map<String, Integer>> stringMapEntry : map.entrySet()) {
            list=new ArrayList<>();
            list.add(stringMapEntry.getKey()+"");
            Map<String,Integer> m=stringMapEntry.getValue();
            for (String s : set) {
                list.add(m.getOrDefault(s,0)+"");
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Map<String,Integer> map=new TreeMap<>();
        map.put("5",1);
        map.put("3",1);
        map.put("10",10);
        for (String s : map.keySet()) {
            System.out.println(s);
        }
    }
}
