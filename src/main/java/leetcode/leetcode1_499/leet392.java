package leetcode.leetcode1_499;


import leetcode.LQTest.A;

import java.util.*;

public class leet392 {
/*    public boolean isSubsequence(String s, String t) {
         int sIndex=0,tIndex=0;
         while (sIndex<s.length()&&tIndex<s.length()){
             if(s.charAt(sIndex)==t.charAt(tIndex)){
                 sIndex++;
                 tIndex++;
             }else tIndex++;
         }

         return sIndex==s.length();
    }*/

    //二分查找  但是并不快啊
    public boolean isSubsequence(String s, String t) {
        Map<Character,List<Integer>> map=new HashMap<>();
        for(int i=0;i<t.length();i++){
           List<Integer>list= map.computeIfAbsent(t.charAt(i),(key)->new ArrayList<>());
           list.add(i);
        }

        int pre=0;
        for(int i=0;i<s.length();i++){

            if(!map.containsKey(s.charAt(i))) return false;
            // 如果搜索键包含在列表中，则返回搜索键的索引；否则返回 (-(插入点) - 1)
           int j= Collections.binarySearch(map.get(s.charAt(i)),pre);

           if(j<0)
               j=-j-1;
           if(j==map.get(s.charAt(i)).size()) return false;
           pre=map.get(s.charAt(i)).get(j)+1;
        }

        return true;
    }
}
