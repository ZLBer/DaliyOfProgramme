package leetcode.leetcode1_499;

import java.util.*;

public class leet49 {

    //mine 临时数组统计字母
    public List<List<String>> groupAnagrams(String[] strs) {

       Map<String,List<String>> map=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
             int[]count=new int[26];
             for(char a:strs[i].toCharArray()){
                 count[a-'a']++;
             }
             StringBuilder sb=new StringBuilder();
            for (int a : count) {
                 sb.append(a);
            }
            if(map.containsKey(sb.toString())){
                map.get(sb.toString()).add(strs[i]);
            }else {
                List<String> list=new ArrayList<>();
               list.add(strs[i]);
                map.put(sb.toString(),list);
            }
        }
        List<List<String>> result=new ArrayList<>();
        for(List list:map.values()){
            result.add(list);
        }
        return result;
    }


    //简洁的版本
/*    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }*/




    //骚操作  每次累加质数
/*    public static List<List<String>> groupAnagrams(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z

        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<>();
                res.add(t);
                map.put(key, res.size() - 1);
            }
            t.add(s);
        }
        return res;
    }*/
}
